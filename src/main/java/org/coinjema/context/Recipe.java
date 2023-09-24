package org.coinjema.context;

import org.coinjema.context.source.SimpleResource;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

@SuppressWarnings("unchecked")
public final class Recipe {

    static final Object DEFAULT_DEPENDENCY = new Object();
    static final ThreadLocal<ObjectSetterContextualizer> CONTEXTUALIZER = ThreadLocal.withInitial(() -> null);
    static final ThreadLocal<CoinjemaContext> contextStack = ThreadLocal.withInitial(() -> null);
    static final ThreadLocal<Set<DependencyGroup>> circle = ThreadLocal.withInitial(HashSet::new);
    static final ThreadLocal<LinkedList<ContextOriented>> unfinishedObjects = ThreadLocal.withInitial(LinkedList::new);
    /*
     * final static Object getExistingContextFor(final Functor f, final
     * CoinjemaContext context) throws Exception { SpiceRack master =
     * SpiceRack.getInstance(context); Object nContext =
     * master.lookupContext(f); return nContext; }
     */
    static final ConcurrentMap<Class<?>, FunctorSet> functorMap = new ConcurrentHashMap<Class<?>, FunctorSet>();
    private static final ConcurrentMap<Class<?>, ConstructorFuncterSet<?>> constructorFunctorMap = new ConcurrentHashMap<>();
    static DynamicDepTracker dynTracker = new DynamicDepTracker();

    static DiscoveredResource resolveScript(final Map<String, Object> values,
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

    private static DiscoveredResource resolveScriptNameLoop(Map<String, Object> values, ResourceNameResolver resolver, SpiceRack master, String resourceName, Set<DependencyGroup> s) {
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

    private static DiscoveredResource redirect(final Map<String, Object> values,
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

    static DiscoveredResource captureDepInContextStack(final Map<String, Object> values,
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

    static DiscoveredResource captureDep(final Map<String, Object> values,
                                         ResourceNameResolver resolver, SpiceRack master) {
        // boolean topLevel = contextStack.get().size() == 0;
        values.put("registry", master);
        return resolveScript(values, resolver, master);
    }

    public static void contextualize(final ContextOriented obj,
                                     final CoinjemaContext context, final CoinjemaContext base) {
        ObjectSetterContextualizer objectSetterContextualizer = CONTEXTUALIZER.get();
        if (objectSetterContextualizer != null) {
            objectSetterContextualizer.contextualize(obj, context, base);
            if (SpiceRack.getRoot().isReconfigurable()) {
                SpiceRack.contextObjects.addObject(obj);
            }
        } else {
            ObjectSetterContextualizer contextualizer = new ObjectSetterContextualizer();
            CONTEXTUALIZER.set(contextualizer);
            try {
                contextualizer.contextualize(obj, context, base);
                if (SpiceRack.getRoot().isReconfigurable()) {
                    SpiceRack.contextObjects.addObject(obj);
                }
            } finally {
                CONTEXTUALIZER.remove();
            }
        }
    }

    static void contextualizeWithoutSave(final ContextOriented obj,
                                         final CoinjemaContext context, final CoinjemaContext base) {
        new ObjectSetterContextualizer().contextualize(obj, context, base);
    }

    public static <T extends ConstructorContextOriented> T constructContextualized(final T obj, Object[] givenArgs,
                                                                                   final CoinjemaContext context, final CoinjemaContext base) {
        T newObj = contextualizeIt((Class<T>) obj.getClass(), givenArgs, context, base);
        if (SpiceRack.getRoot().isReconfigurable()) {
            SpiceRack.contextObjects.addObject(newObj);
        }
        return newObj;
    }

    private static <T extends ContextOriented> T contextualizeIt(final Class<T> clzz, Object[] givenArgs,
                                                                 final CoinjemaContext context, final CoinjemaContext base) {
        ConstructorFuncterSet<T> functors = (ConstructorFuncterSet<T>) constructorFunctorMap.computeIfAbsent(clzz, c -> new ConstructorFuncterSet<>(clzz));

        boolean topLevel = contextStack.get() == null;
        if (log.isLoggable(Level.FINER)) {
            log.finer("Base context = "
                    + (topLevel ? base : contextStack.get())
                    + " sub-context = " + context);
        }
        final SpiceRack baseContext = findBaseContext(topLevel ? base : contextStack.get(), context);
        if (log.isLoggable(Level.FINER)) {
            log.finer("Resolved context = " + baseContext.getContext());
        }
        Object[] argsToUse = new Object[functors.argCount()];
        int index = 0;
        for (ConstructorDependencyResolver resolver : functors) {
            Object dep = resolver.findDependency(resourceName -> baseContext.lookupContext(resourceName, clzz, givenArgs));
            if (dep != null) {
                argsToUse[index++] = dep;
            } else {
                throw new RuntimeException("I would prefer we always find the dependency, but we failed to find it for " + resolver.getFailedToFindMessage());
            }
        }
        try {
            return (T) functors.constructor().newInstance(argsToUse);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to construct object for " + functors.getFailedToConstructMessage(e), e);
        }

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

    static SpiceRack findBaseContext(CoinjemaContext base,
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

    static ObjectSetterContextualizer getContextualizer() {
        ObjectSetterContextualizer objectSetterContextualizer = CONTEXTUALIZER.get();
        if (objectSetterContextualizer != null) return objectSetterContextualizer;
        return new ObjectSetterContextualizer();
    }
}
