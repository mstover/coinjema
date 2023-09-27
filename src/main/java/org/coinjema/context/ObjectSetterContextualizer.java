package org.coinjema.context;

import org.coinjema.context.source.SimpleResource;
import org.coinjema.util.DependencyFunctor;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

class ObjectSetterContextualizer {

    static final ReentrantLock globalSync = new ReentrantLock();

    private final LinkedList<ContextOriented> unfinishedObjects = new LinkedList<>();
    private final Set<DependencyGroup> circleProtection = new HashSet<>();
    private CoinjemaContext currentTopContext;
    private static final ConcurrentMap<Class<?>, FunctorSet> functorMap = new ConcurrentHashMap<>();

    void contextualize(final ContextOriented obj, final CoinjemaContext context, CoinjemaContext base) {
        contextualizeIt(obj, context, base);
    }

    private void contextualizeIt(final ContextOriented obj,
                                 final CoinjemaContext context, final CoinjemaContext base) {
        FunctorSet functors = functorMap.get(obj.getClass());
        if (functors == null) {
            contextualizeClassFirstTime(obj, context, base);
        } else {
            boolean topLevel = currentTopContext == null;
            if (log.isLoggable(Level.FINER)) {
                log.finer("Base context = "
                        + (topLevel ? base : currentTopContext)
                        + " sub-context = " + context);
            }
            final SpiceRack baseContext = Recipe.findBaseContext(topLevel ? base
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
            SpiceRack baseContext = Recipe.findBaseContext(topLevel ? base : currentTopContext, context);
            if (log.isLoggable(Level.FINER)) {
                log.finer("Resolved context = " + baseContext.getContext());
            }
            obj.setCoinjemaContext(baseContext.getContext());
            contextualizing(obj);
            try {
                iterateFunctors(obj, baseContext, functors);
            }finally {
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
        return functorMap.computeIfAbsent(obj.getClass(), cl -> new FunctorSet(obj));
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
                                + obj.getClass().getName() + " in context " + baseContext.getContext());
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

    Object findDynamicDependency(final Object obj, final Class<?> objClass,
                                        final CoinjemaDynamic ann, final Method meth,
                                        CoinjemaContext context) {
        if (log.isLoggable(Level.FINE)) {
            log.fine("Finding dynamic dependency for " + objClass.getName()
                    + " method: " + meth.getName() + " in context " + context);
        }
        final ResourceNameResolver resolver = Recipe.dynTracker.getNameResolver(meth,
                objClass, ann);
        final SpiceRack baseContext = Recipe.findBaseContext(context,
                getOptionalDynContext(ann, obj));
        Object dep = resolver.findDependency(resourceName -> baseContext.lookupContext(resourceName, objClass, null));
        if (dep != null) {
            if (dep == Recipe.DEFAULT_DEPENDENCY) {
                throw new DependencyInjectionException(
                        "Failed to find dependency: " + objClass + " : "
                                + meth.getName());
            } else {
                return dep;
            }
        }
        final Map<String, Object> values = new HashMap<String, Object>();
        values.put("objClass", objClass);
        values.put("obj", obj);
        values.put("injector", null);
        final LinkedList<SpiceRack> racks = new LinkedList<SpiceRack>();
        DiscoveredResource newDep = RackLoop.loop(baseContext, rack -> {
            return findDynamicDep(objClass, rack, resolver, values, racks);
        });
        if (newDep == null || newDep.dep == null) {
            newDep = new DiscoveredResource(new SimpleResource(resolver
                    .getLocalName()), Recipe.DEFAULT_DEPENDENCY);
        }
        if (newDep.res == null && resolver.getName() != null) {
            newDep.res = new SimpleResource(resolver.getName(), racks
                    .getFirst().getScope(resolver.getName(), objClass, null));
        }
        for (SpiceRack rack : racks) {
            newDep.dep = rack
                    .addContext(newDep.res, objClass, null, newDep.dep);
        }
        if (newDep.dep == Recipe.DEFAULT_DEPENDENCY) {
            throw new DependencyInjectionException(
                    "Failed to find dependency: " + newDep.res);
        } else {
            return newDep.dep;
        }
    }

    private CoinjemaContext getOptionalDynContext(CoinjemaDynamic ann, Object obj) {
        String contextMethod = ann.contextMethod();
        if (!"".equals(contextMethod)) {
            try {
                Method m = obj.getClass().getMethod(contextMethod);
                return new CoinjemaContext((String) m.invoke(obj));
            } catch (Exception e) {
                log.warning("Context Method resulted in error: method="
                        + contextMethod + " class = "
                        + obj.getClass().getName());
                return null;
            }
        } else {
            return null;
        }
    }

    private DiscoveredResource findDynamicDep(Class<?> objClass, SpiceRack rack, ResourceNameResolver resolver,
                                                     Map<String, Object> values, LinkedList<SpiceRack> racks) {
        Object depObj = resolver
                .findDependency(resourceName -> rack.lookupContext(resourceName, objClass, null));
        DiscoveredResource discRes = null;
        if (depObj == null) {
            discRes = captureDepInContextStack(values,
                    resolver, rack);
        } else {
            discRes = new DiscoveredResource(null, depObj);
        }
        racks.addFirst(rack);
        return discRes;
    }

    private void logAnnotatedMock(SpiceRack rack, DiscoveredResource objDep, DependencyFunctor<Object> depInjector) {
        if (objDep == null && "AnnotatedMock".equals(depInjector.getInjectedLabel())) {
            System.out.println("Looking in " + rack.getDirectory().getName());
        }
    }

    DiscoveredResource captureDepInContextStack(final Map<String, Object> values,
                                                ResourceNameResolver resolver, SpiceRack base) {
        CoinjemaContext cc = currentTopContext;
        try {
            currentTopContext = base.getContext();
            return captureDep(values, resolver, base);
        } finally {
            currentTopContext = cc;
        }
    }

    DiscoveredResource captureDep(final Map<String, Object> values,
                                  ResourceNameResolver resolver, SpiceRack base) {
        values.put("registry", base);
        return resolveScript(values, resolver, base);
    }

    private DiscoveredResource resolveScript(final Map<String, Object> values,
                                             final ResourceNameResolver resolver, final SpiceRack base) {
        // since redirect preserves original context, have to look all the way
        // down for the redirect before
        // accepting any deps saved to the injector.
        DiscoveredResource dep = new DiscoveredResource(null, null);
        String redirect = resolver.findDependency(resourceName -> RedirectionEvaluator.findRedirectName(resourceName, base));
        if (redirect == null) {
            dep.dep = resolver.findDependency(resourceName -> base.lookupContext(resourceName, (Class<?>) values.get("objClass"), values.get("obj")));
            if (dep.dep != null) {
                return dep;
            }
            dep = resolver.findDependency(resourceName -> resolveScriptNameLoop(values, resolver, base, resourceName));
            if (dep != null && dep.dep != null) {
                dep.dep = base.addContext(dep.res, (Class<?>) values
                        .get("objClass"), values.get("obj"), dep.dep);
            }
        } else {
            dep = redirect(values, base, redirect, resolver);

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
            sub = Recipe.findBaseContext(master.getContext(), new CoinjemaContext(
                    redirect.substring(0, x)));
            redirect = redirect.substring(x + 1);
        }
        final RedirectNameResolver redirectResolve = new RedirectNameResolver(
                redirect, parentResolver);
        dep = RackLoop.limitedLoop(sub, master, rack -> captureDepInContextStack(newValues, redirectResolve, rack));
        return dep;
    }
}
