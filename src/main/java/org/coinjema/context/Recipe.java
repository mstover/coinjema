package org.coinjema.context;

import org.coinjema.context.source.SimpleResource;
import org.coinjema.util.DependencyFunctor;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

final class Recipe {

    static final Object DEFAULT_DEPENDENCY = new Object();
    static final String SELF = ".Self";
    static final ThreadLocal<CoinjemaContext> contextStack = ThreadLocal.withInitial( () -> null);
    static final ThreadLocal<Set<DependencyGroup>> circle = ThreadLocal.withInitial(() -> new HashSet<>());
    static final ThreadLocal<LinkedList<ContextOriented>> unfinishedObjects = ThreadLocal.withInitial(() -> new LinkedList<>());
    static DynamicDepTracker dynTracker = new DynamicDepTracker();

    /*
     * final static Object getExistingContextFor(final Functor f, final
     * CoinjemaContext context) throws Exception { SpiceRack master =
     * SpiceRack.getInstance(context); Object nContext =
     * master.lookupContext(f); return nContext; }
     */
    private static ConcurrentMap<Class<?>, FunctorSet> functorMap = new ConcurrentHashMap<Class<?>, FunctorSet>();

    final static DiscoveredResource resolveScript(final Map<String,Object> values,
                                                  final ResourceNameResolver resolver, final SpiceRack master) {
        // since redirect preserves original context, have to look all the way
        // down for the redirect before
        // accepting any deps saved to the injector.
        DiscoveredResource dep = new DiscoveredResource(null, null);
        String redirect = resolver.findDependency(resourceName -> RedirectionEvaluator.findRedirectName(resourceName, master));
        if (redirect == null) {
            dep.dep = resolver.findDependency(resourceName -> master.lookupContext(resourceName, (Class<?>) values.get("objClass"), values.get("obj")));
            if (dep != null && dep.dep != null) {
                return dep;
            }
            final Set<DependencyGroup> s = circle.get();
            dep = resolver.findDependency(resourceName -> resolveScriptNameLoop(values, resolver, master, resourceName, s));
            if (dep != null && dep.dep != null) {
                dep.dep = master.addContext(dep.res, (Class<?>) values
                        .get("objClass"), values.get("obj"), dep.dep);
            }
        } else {
            dep = redirect(values, master, redirect, resolver);

        }
        return dep;
    }

    private static DiscoveredResource resolveScriptNameLoop(Map<String,Object> values, ResourceNameResolver resolver, SpiceRack master, String resourceName, Set<DependencyGroup> s) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("looking for resource: " + resourceName
                    + " in context '"
                    + master.getContext().getName() + "'");
        }
        DependencyGroup dp = new DependencyGroup(resourceName,
                master.getContext());
        if (s.contains(dp)) {
            if (log.isLoggable(Level.FINEST)) {
                log.finest("Retrieving unfinished Resource "
                        + resourceName + " in context "
                        + master.getContext().getName());
            }
            DiscoveredResource dr = new DiscoveredResource(null,
                    resolver.findMatchingUnfinishedObject(
                            unfinishedObjects.get(), master
                                    .getContext()));
            if (dr.dep != null) {
                return dr;
            }
        }
        DiscoveredResource tempDep = null;
        try {
            s.add(dp);
            tempDep = ScriptEvaluator.evaluate(resourceName, master
                    .getDirectory(), values);
        } finally {
            s.remove(dp);
        }
        return tempDep;
    }

    private static DiscoveredResource redirect(final Map values,
                                               final SpiceRack master, String redirect,
                                               ResourceNameResolver parentResolver) {
        DiscoveredResource dep;
        final Map<String, Object> newValues = new HashMap<String, Object>();
        SpiceRack sub = master;
        int x = -1;
        if ((x = redirect.lastIndexOf("/")) > -1) {
            sub = findBaseContext(master.getContext(), new CoinjemaContext(
                    redirect.substring(0, x)));
            redirect = redirect.substring(x + 1);
        }
        newValues.putAll(values);
        final RedirectNameResolver redirectResolve = new RedirectNameResolver(
                redirect, parentResolver);
        dep = RackLoop.limitedLoop(sub, master, rack -> captureDepInContextStack(newValues, redirectResolve, rack));
        return dep;
    }

    static DiscoveredResource captureDepInContextStack(final Map values,
                                                       ResourceNameResolver resolver, SpiceRack master) {
        CoinjemaContext cc = contextStack.get();
        try {
            contextStack.set(master.getContext());
            return captureDep(values, resolver, master);
        } finally {
            if (cc != null) {
                contextStack.set(cc);
            } else {
                contextStack.remove();
            }
        }
    }

    static DiscoveredResource captureDep(final Map values,
                                         ResourceNameResolver resolver, SpiceRack master) {
        // boolean topLevel = contextStack.get().size() == 0;
        values.put("registry", master);
        return resolveScript(values, resolver, master);
    }

    final public static void contextualize(final ContextOriented obj,
                                           final CoinjemaContext context, final CoinjemaContext base) {
        contextualizeIt(obj, context, base);
        if (SpiceRack.getRoot().isReconfigurable()) {
            SpiceRack.contextObjects.addObject(obj);
        }
    }

    final static void contextualizeWithoutSave(final ContextOriented obj,
                                               final CoinjemaContext context, final CoinjemaContext base) {
        contextualizeIt(obj, context, base);
    }

    final private static void contextualizeIt(final ContextOriented obj,
                                              final CoinjemaContext context, final CoinjemaContext base) {
        FunctorSet functors = functorMap.get(obj.getClass());
        if (functors == null) {
            contextualizeClassFirstTime(obj, context, base);
        } else {
            boolean topLevel = contextStack.get() == null;
            if (log.isLoggable(Level.FINER)) {
                log.finer("Base context = "
                        + (topLevel ? base : contextStack.get())
                        + " sub-context = " + context);
            }
            final SpiceRack baseContext = findBaseContext(topLevel ? base
                    : contextStack.get(), context);
            if (log.isLoggable(Level.FINER)) {
                log.finer("Resolved context = " + baseContext.getContext());
            }
            obj.setCoinjemaContext(baseContext.getContext());
            injectFunctors(obj, context, base, functors, baseContext);
        }
    }

    private static void injectFunctors(final ContextOriented obj,
                                       final CoinjemaContext context, final CoinjemaContext base,
                                       FunctorSet functors, final SpiceRack baseContext) {
        for (DependencyFunctor<Object> injector : functors) {
            if (!functors.isMarked(injector, baseContext.getContext())) {
                InjectorNameResolver injResolver = injector.getNameResolver();
                Object dep = injResolver.findDependency(resourceName -> baseContext.lookupContext(resourceName, obj.getClass(), obj));
                if (dep == DEFAULT_DEPENDENCY) {
                    functors.markForRemoval(injector, baseContext.getContext());
                } else if (dep != null) {
                    synchronized (Recipe.class) {
                        injector.invoke(obj, dep);
                    }
                } else {
                    contextualizeContextFirstTime(functors, obj, context, base);
                    break;
                }
            }
        }
    }

    final synchronized private static void contextualizeContextFirstTime(
            FunctorSet functors, final ContextOriented obj,
            final CoinjemaContext context, final CoinjemaContext base) {
        boolean topLevel = contextStack.get() == null;
        if (log.isLoggable(Level.FINER)) {
            log.finer("Base context = "
                    + (topLevel ? base : contextStack.get())
                    + " sub-context = " + context);
        }
        SpiceRack baseContext = findBaseContext(topLevel ? base : contextStack
                .get(), context);
        if (log.isLoggable(Level.FINER)) {
            log.finer("Resolved context = " + baseContext.getContext());
        }
        obj.setCoinjemaContext(baseContext.getContext());
        contextualizing(obj);
        try {
            iterateFunctors(obj, context, base, baseContext, functors);
        } finally {
            doneContextualizing(obj);
        }
    }

    final private static void contextualizing(ContextOriented obj) {
        unfinishedObjects.get().addFirst(obj);
    }

    final private static void doneContextualizing(ContextOriented obj) {
        unfinishedObjects.get().removeFirst();
    }

    final private static void contextualizeClassFirstTime(
            final ContextOriented obj, final CoinjemaContext context,
            final CoinjemaContext base) {
        contextualizeContextFirstTime(retrieveFunctors(obj), obj, context, base);
    }

    static CoinjemaContext getOptionalDynContext(CoinjemaDynamic ann, Object obj) {
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

    static Object findDynamicDependency(final Object obj, final Class objClass,
                                        final CoinjemaDynamic ann, final Method meth,
                                        CoinjemaContext context) {
        if (log.isLoggable(Level.FINE)) {
            log.fine("Finding dynamic dependency for " + objClass.getName()
                    + " method: " + meth.getName() + " in context " + context);
        }
        final ResourceNameResolver resolver = dynTracker.getNameResolver(meth,
                objClass, ann);
        final SpiceRack baseContext = findBaseContext(context,
                getOptionalDynContext(ann, obj));
        Object dep = resolver.findDependency(resourceName -> baseContext.lookupContext(resourceName, objClass, null));
        if (dep != null) {
            if (dep == DEFAULT_DEPENDENCY) {
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
                    .getLocalName()), DEFAULT_DEPENDENCY);
        }
        if (newDep.res == null && resolver.getName() != null) {
            newDep.res = new SimpleResource(resolver.getName(), racks
                    .getFirst().getScope(resolver.getName(), objClass, null));
        }
        for (SpiceRack rack : racks) {
            newDep.dep = rack
                    .addContext(newDep.res, objClass, null, newDep.dep);
        }
        if (newDep.dep == DEFAULT_DEPENDENCY) {
            throw new DependencyInjectionException(
                    "Failed to find dependency: " + newDep.res);
        } else {
            return newDep.dep;
        }
    }

    private static DiscoveredResource findDynamicDep(Class objClass, SpiceRack rack, ResourceNameResolver resolver,
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

    static void iterateFunctors(final ContextOriented obj,
                                final CoinjemaContext context, final CoinjemaContext base,
                                SpiceRack baseContext, FunctorSet functors) {
        for (DependencyFunctor<Object> injector : functors) {
            findAndInject(obj, baseContext, injector);
        }
    }

    static FunctorSet retrieveFunctors(ContextOriented obj) {
        FunctorSet set = null;
        synchronized (obj.getClass()) {
            if ((set = functorMap.get(obj.getClass())) != null) {
                return set;
            }
            int previousPriority = Thread.currentThread().getPriority();
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            try {
                set = new FunctorSet(obj);
                FunctorSet s = functorMap.putIfAbsent(obj.getClass(), set);
                if (s != null) {
                    set = s;
                }
            } finally {
                Thread.currentThread().setPriority(previousPriority);
            }
        }
        return set;
    }

    static void findAndInject(final ContextOriented obj, SpiceRack baseContext,
                              final DependencyFunctor<Object> injector) {
        final LinkedList<SpiceRack> racks = new LinkedList<SpiceRack>();
        final Map values = new HashMap();
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
                        .getLocalName()), DEFAULT_DEPENDENCY);
            } else {
                throw new DependencyInjectionException(
                        "Failed to find dependency for "
                                + injector.getMethodName() + " of class "
                                + obj.getClass().getName());
            }
        } else if (dep.dep != DEFAULT_DEPENDENCY) {
            injector.invoke(obj, dep.dep);
        }
        if (dep.res == null && resolver.getName() != null) {
            dep.res = new SimpleResource(resolver.getName(), racks.getFirst()
                    .getScope(resolver.getName(), obj.getClass(), obj));
        }
        for (SpiceRack rack : racks) {
            if (dep.dep == DEFAULT_DEPENDENCY) {
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

    private static void logAnnotatedMock(SpiceRack rack, DiscoveredResource objDep, DependencyFunctor<Object> depInjector) {
        if (objDep == null && "AnnotatedMock".equals(depInjector.getInjectedLabel())) {
            System.out.println("Looking in " + rack.getDirectory().getName());
        }
    }

    /*
     * private static void redoCircularDeps() { if (circle.get().size() == 0) {
     * List<DependencyGroup> unfinished = new LinkedList(unfinishedObjects
     * .get()); unfinishedObjects.get().clear(); for (DependencyGroup g :
     * unfinished) { synchronized (SELF) { contextualize(g.obj, g.sub, g.base);
     * } } } }
     */

    final static SpiceRack findBaseContext(CoinjemaContext base,
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

}
