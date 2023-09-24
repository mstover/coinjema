package org.coinjema.context;

import org.coinjema.context.source.SimpleResource;
import org.coinjema.util.DependencyFunctor;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

class ObjectSetterContextualizer {

    private static ReentrantLock globalSync = new ReentrantLock();
    private static ReentrantLock objectSync = new ReentrantLock();

    private final LinkedList<ContextOriented> unfinishedObjects = new LinkedList<>();
    private final Set<DependencyGroup> circleProtection = new HashSet<>();
    private CoinjemaContext currentTopContext;

    void contextualize(final ContextOriented obj, final CoinjemaContext context, CoinjemaContext base) {
        contextualizeIt(obj, context, base);
    }

    private void contextualizeIt(final ContextOriented obj,
                                 final CoinjemaContext context, final CoinjemaContext base) {
        FunctorSet functors = Recipe.functorMap.get(obj.getClass());
        if (functors == null) {
            contextualizeClassFirstTime(obj, context, base);
        } else {
            boolean topLevel = currentTopContext == null;
            if (log.isLoggable(Level.FINER)) {
                log.finer("Base context = "
                        + (topLevel ? base : currentTopContext)
                        + " sub-context = " + context);
            }
            final SpiceRack baseContext = findBaseContext(topLevel ? base
                    : currentTopContext, context);
            if (log.isLoggable(Level.FINER)) {
                log.finer("Resolved context = " + baseContext.getContext());
            }
            obj.setCoinjemaContext(baseContext.getContext());
            injectFunctors(obj, context, base, functors, baseContext);
        }
    }

    private void injectFunctors(final ContextOriented obj,
                                final CoinjemaContext context, final CoinjemaContext base,
                                FunctorSet functors, final SpiceRack baseContext) {
        for (DependencyFunctor<Object> injector : functors) {
            if (!functors.isMarked(injector, baseContext.getContext())) {
                InjectorNameResolver injResolver = injector.getNameResolver();
                Object dep = injResolver.findDependency(resourceName -> baseContext.lookupContext(resourceName, obj.getClass(), obj));
                if (dep == Recipe.DEFAULT_DEPENDENCY) {
                    functors.markForRemoval(injector, baseContext.getContext());
                } else if (dep != null) {
                    try {
                        globalSync.lock();
                        injector.invoke(obj, dep);
                    } finally {
                        globalSync.unlock();
                    }
                } else {
                    contextualizeContextFirstTime(functors, obj, context, base);
                    break;
                }
            }
        }
    }

    private SpiceRack findBaseContext(CoinjemaContext base,
                                      CoinjemaContext sub) {
        if (base == null && sub == null) {
            return SpiceRack.getRoot();
        } else if (base == null) {
            base = SpiceRack.getRoot().getContext();
        } else if (sub == null) {
            sub = SpiceRack.getRoot().getContext();
        }
        SpiceRack rack = null;
        CoinjemaContext subParent = sub;
        while (subParent != null && rack == null) {
            CoinjemaContext parent = base;
            while (parent != null && rack == null) {
                rack = SpiceRack.getInstance(new CoinjemaContext(parent,
                        subParent));
                parent = parent.getParentContext();
            }
            subParent = subParent.getParentContext();
        }
        if (rack == null) {
            return SpiceRack.getRoot();
        }
        return rack;
    }


    private void contextualizeClassFirstTime(
            final ContextOriented obj, final CoinjemaContext context,
            final CoinjemaContext base) {
        contextualizeContextFirstTime(retrieveFunctors(obj), obj, context, base);
    }

    private void contextualizeContextFirstTime(
            FunctorSet functors, final ContextOriented obj,
            final CoinjemaContext context, final CoinjemaContext base) {
        try {
            globalSync.lock();
            boolean topLevel = currentTopContext == null;
            if (log.isLoggable(Level.FINER)) {
                log.finer("Base context = "
                        + (topLevel ? base : currentTopContext)
                        + " sub-context = " + context);
            }
            SpiceRack baseContext = findBaseContext(topLevel ? base : currentTopContext, context);
            if (log.isLoggable(Level.FINER)) {
                log.finer("Resolved context = " + baseContext.getContext());
            }
            obj.setCoinjemaContext(baseContext.getContext());
            contextualizing(obj);
            try {
                iterateFunctors(obj, baseContext, functors);
            } finally {
                doneContextualizing();
            }
        } finally {
            globalSync.unlock();
        }
    }

    private void contextualizing(ContextOriented obj) {
        unfinishedObjects.addFirst(obj);
    }

    private void doneContextualizing() {
        unfinishedObjects.removeFirst();
    }

    private FunctorSet retrieveFunctors(ContextOriented obj) {
        return Recipe.functorMap.computeIfAbsent(obj.getClass(), cl -> new FunctorSet(obj));
    }

    private void iterateFunctors(final ContextOriented obj,
                                 SpiceRack baseContext, FunctorSet functors) {
        for (DependencyFunctor<Object> injector : functors) {
            findAndInject(obj, baseContext, injector);
        }
    }

    private void findAndInject(final ContextOriented obj, SpiceRack baseContext,
                               final DependencyFunctor<Object> injector) {
        final LinkedList<SpiceRack> racks = new LinkedList<SpiceRack>();
        final Map<String, Object> values = new HashMap<>();
        values.put("injector", injector);
        values.put("obj", obj);
        values.put("objClass", obj.getClass());
        final ResourceNameResolver resolver = injector.getNameResolver();
        DiscoveredResource dep = RackLoop.loop(baseContext, rack -> {
            DependencyFunctor<Object> depInjector = (DependencyFunctor<Object>) values.get("injector");
            DiscoveredResource objDep = captureDepInContextStack(values, resolver, rack);
            logAnnotatedMock(rack, objDep, depInjector);
            racks.addFirst(rack);
            return objDep;
        });
        if (dep == null || dep.dep == null) {
            if (injector.hasDefault()) {
                dep = new DiscoveredResource(new SimpleResource(resolver
                        .getLocalName()), Recipe.DEFAULT_DEPENDENCY);
            } else {
                throw new DependencyInjectionException(
                        "Failed to find dependency for "
                                + injector.getMethodName() + " of class "
                                + obj.getClass().getName());
            }
        } else if (dep.dep != Recipe.DEFAULT_DEPENDENCY) {
            injector.invoke(obj, dep.dep);
        }
        if (dep.res == null && resolver.getName() != null) {
            dep.res = new SimpleResource(resolver.getName(), racks.getFirst()
                    .getScope(resolver.getName(), obj.getClass(), obj));
        }
        for (SpiceRack rack : racks) {
            if (dep.dep == Recipe.DEFAULT_DEPENDENCY) {
                dep.dep = rack
                        .addContext(dep.res, obj.getClass(), obj, dep.dep);
            } else if (resolver.getName() == null) {
                break;
            } else {
                dep.dep = rack
                        .addContext(dep.res, obj.getClass(), obj, dep.dep);
            }
        }
    }

    private void logAnnotatedMock(SpiceRack rack, DiscoveredResource objDep, DependencyFunctor<Object> depInjector) {
        if (objDep == null && "AnnotatedMock".equals(depInjector.getInjectedLabel())) {
            System.out.println("Looking in " + rack.getDirectory().getName());
        }
    }

    DiscoveredResource captureDepInContextStack(final Map<String, Object> values,
                                                ResourceNameResolver resolver, SpiceRack master) {
        CoinjemaContext cc = currentTopContext;
        try {
            currentTopContext = master.getContext();
            return captureDep(values, resolver, master);
        } finally {
            currentTopContext = cc;
        }
    }

    DiscoveredResource captureDep(final Map<String, Object> values,
                                  ResourceNameResolver resolver, SpiceRack master) {
        values.put("registry", master);
        return resolveScript(values, resolver, master);
    }

    private DiscoveredResource resolveScript(final Map<String, Object> values,
                                             final ResourceNameResolver resolver, final SpiceRack master) {
        // since redirect preserves original context, have to look all the way
        // down for the redirect before
        // accepting any deps saved to the injector.
        DiscoveredResource dep = new DiscoveredResource(null, null);
        String redirect = resolver.findDependency(resourceName -> RedirectionEvaluator.findRedirectName(resourceName, master));
        if (redirect == null) {
            dep.dep = resolver.findDependency(resourceName -> master.lookupContext(resourceName, (Class<?>) values.get("objClass"), values.get("obj")));
            if (dep.dep != null) {
                return dep;
            }
            dep = resolver.findDependency(resourceName -> resolveScriptNameLoop(values, resolver, master, resourceName));
            if (dep != null && dep.dep != null) {
                dep.dep = master.addContext(dep.res, (Class<?>) values
                        .get("objClass"), values.get("obj"), dep.dep);
            }
        } else {
            dep = redirect(values, master, redirect, resolver);

        }
        return dep;
    }

    private DiscoveredResource resolveScriptNameLoop(Map<String, Object> values, ResourceNameResolver resolver, SpiceRack master, String resourceName) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("looking for resource: " + resourceName
                    + " in context '"
                    + master.getContext().getName() + "'");
        }
        DependencyGroup dp = new DependencyGroup(resourceName,
                master.getContext());
        if (circleProtection.contains(dp)) {
            if (log.isLoggable(Level.FINEST)) {
                log.finest("Retrieving unfinished Resource "
                        + resourceName + " in context "
                        + master.getContext().getName());
            }
            DiscoveredResource dr = new DiscoveredResource(null, resolver.findMatchingUnfinishedObject(unfinishedObjects, master.getContext()));
            if (dr.dep != null) {
                return dr;
            }
        }
        DiscoveredResource tempDep = null;
        try {
            circleProtection.add(dp);
            tempDep = ScriptEvaluator.evaluate(resourceName, master
                    .getDirectory(), values);
        } finally {
            circleProtection.remove(dp);
        }
        return tempDep;
    }

    private DiscoveredResource redirect(final Map<String, Object> values,
                                        final SpiceRack master, String redirect,
                                        ResourceNameResolver parentResolver) {
        DiscoveredResource dep;
        final Map<String, Object> newValues = new HashMap<String, Object>(values);
        SpiceRack sub = master;
        int x = -1;
        if ((x = redirect.lastIndexOf("/")) > -1) {
            sub = findBaseContext(master.getContext(), new CoinjemaContext(
                    redirect.substring(0, x)));
            redirect = redirect.substring(x + 1);
        }
        final RedirectNameResolver redirectResolve = new RedirectNameResolver(
                redirect, parentResolver);
        dep = RackLoop.limitedLoop(sub, master, rack -> captureDepInContextStack(newValues, redirectResolve, rack));
        return dep;
    }
}
