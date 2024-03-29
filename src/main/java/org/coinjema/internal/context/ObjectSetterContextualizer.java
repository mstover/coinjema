package org.coinjema.internal.context;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.CjmDynamic;
import org.coinjema.cjm.ContextOriented;
import org.coinjema.cjm.DependencyInjectionException;
import org.coinjema.internal.context.names.DynamicDependencyNameResolver;
import org.coinjema.internal.context.names.InjectorNameResolver;
import org.coinjema.internal.context.names.ResourceNameResolver;
import org.coinjema.cjm.source.SimpleResource;
import org.coinjema.cjm.util.DependencyFunctor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

public class ObjectSetterContextualizer extends AbstractContextualizer {

    private static final ConcurrentMap<Class<?>, FunctorSet> functorMap = new ConcurrentHashMap<>();

    private static final ConcurrentMap<ClassContextKey, Boolean> contextInitialized = new ConcurrentHashMap<>();

    private static Object findPreviouslyResolvedDep(Class<?> objClass, Method meth, ResourceNameResolver resolver, SpiceRack baseContext) {
        Object dep = resolver.findDependency(resourceName -> baseContext.lookupContext(resourceName, objClass, null));
        if (dep != null) {
            if (dep == InternalCjm.DEFAULT_DEPENDENCY) {
                throw new DependencyInjectionException(
                        "Failed to find dependency: " + objClass + " : "
                                + meth.getName());
            } else {
                return dep;
            }
        }
        return null;
    }

    public static void clear() {
        contextInitialized.clear();
    }

    public void contextualize(final ContextOriented obj, final CjmContext context, CjmContext base) {
        contextualizeIt(obj, InternalCjm.findBaseContext(base, context));
    }

    private void contextualizeIt(final ContextOriented obj,
                                 final SpiceRack contextRegistry) {
        FunctorSet functors = functorMap.get(obj.getClass());
        if (functors != null && contextInitialized.getOrDefault(new ClassContextKey(obj.getClass(), contextRegistry.getContext()), false)) {
            contextualizeItWithFunctors(obj, contextRegistry, functors);

        } else {
            boolean tryAgain = false;
            try {
                boolean haveLock = InternalCjm.globalSync.tryLock(10, TimeUnit.MILLISECONDS);
                if (haveLock) {
                    try {
                        functors = functorMap.get(obj.getClass());
                        if (functors == null || !contextInitialized.getOrDefault(new ClassContextKey(obj.getClass(), contextRegistry.getContext()), false)) {
                            contextualizeClassFirstTime(obj, contextRegistry);
                        } else {
                            tryAgain = true;
                        }
                    } finally {
                        InternalCjm.globalSync.unlock();
                    }

                } else {
                    tryAgain = true;
                }
                if (tryAgain) contextualizeIt(obj, contextRegistry);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }

    private void contextualizeItWithFunctors(ContextOriented obj, SpiceRack baseContextInput, FunctorSet functors) {
        boolean topLevel = currentTopContext == null;
        if (log.isLoggable(Level.FINER)) {
            log.finer("Base context = "
                    + (topLevel ? baseContextInput : currentTopContext));
        }
        final SpiceRack baseContext = topLevel ? baseContextInput : SpiceRack.getInstance(currentTopContext);
        if (log.isLoggable(Level.FINER)) {
            log.finer("Resolved context = " + baseContext.getContext());
        }
        obj.setCoinjemaContext(baseContext.getContext());
        injectFunctors(obj, functors, baseContext);
    }

    private void injectFunctors(final ContextOriented obj,
                                FunctorSet functors, final SpiceRack baseContext) {
        for (DependencyFunctor<Object> injector : functors) {
            if (!functors.isMarked(injector, baseContext.getContext())) {
                InjectorNameResolver injResolver = injector.getNameResolver();
                Object dep = injResolver.findDependency(resourceName -> baseContext.lookupContext(resourceName, obj.getClass(), obj));
                if (dep == InternalCjm.DEFAULT_DEPENDENCY) {
                    functors.markForRemoval(injector, baseContext.getContext());
                } else if (dep != null) {
                    injector.invoke(obj, dep);
                } else {
                    try {
                        InternalCjm.globalSync.lock();
                        contextualizeContextFirstTime(functors, obj, baseContext);
                    } finally {
                        InternalCjm.globalSync.unlock();
                    }
                    break;
                }
            }
        }
    }

    private void contextualizeClassFirstTime(
            final ContextOriented obj, SpiceRack baseContext) {
        FunctorSet functors = retrieveFunctors(obj);
        contextualizeContextFirstTime(functors, obj, baseContext);
        functorMap.put(obj.getClass(), functors);
        contextInitialized.put(new ClassContextKey(obj.getClass(), baseContext.getContext()), true);
    }

    private void contextualizeContextFirstTime(
            FunctorSet functors, final ContextOriented obj, SpiceRack baseContextInput) {
        boolean topLevel = currentTopContext == null;
        if (log.isLoggable(Level.FINER)) {
            log.finer("Base context = "
                    + (topLevel ? baseContextInput : currentTopContext));
        }
        SpiceRack baseContext = topLevel ? baseContextInput : SpiceRack.getInstance(currentTopContext);
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
    }

    private void contextualizing(ContextOriented obj) {
        unfinishedObjects.addFirst(obj);
    }

    private void doneContextualizing() {
        unfinishedObjects.removeFirst();
    }

    private FunctorSet retrieveFunctors(Object obj) {
        return new FunctorSet(obj);
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
                        .getLocalName()), InternalCjm.DEFAULT_DEPENDENCY);
            } else {
                throw new DependencyInjectionException(
                        "Failed to find dependency for "
                                + resolver.getName() + " of class "
                                + obj.getClass().getName() + " in context " + baseContext.getContext());
            }
        } else if (dep.dep != InternalCjm.DEFAULT_DEPENDENCY) {
            injector.invoke(obj, dep.dep);
        }
        if (dep.hasNoResource() && resolver.getName() != null) {
            dep.res.add(new SimpleResource(resolver.getName(), racks.getFirst()
                    .getScope(resolver.getName(), obj.getClass(), obj)));
        }
        for (SpiceRack rack : racks) {
            if (dep.dep == InternalCjm.DEFAULT_DEPENDENCY) {
                dep.dep = dep.rackAllResources(rack, obj.getClass(), obj, dep.dep);
            } else if (resolver.getName() == null) {
                break;
            } else {
                dep.dep = dep.rackAllResources(rack, obj.getClass(), obj, dep.dep);
            }
        }
    }

    public Object findDynamicDependency(final Object obj, final Class<?> objClass,
                                        final CjmDynamic ann, final Method meth,
                                        CjmContext context) {
        if (log.isLoggable(Level.FINE)) {
            log.fine("Finding dynamic dependency for " + objClass.getName()
                    + " method: " + meth.getName() + " in context " + context);
        }
        final ResourceNameResolver resolver = new DynamicDependencyNameResolver(objClass, ann, meth);
        final SpiceRack baseContext = InternalCjm.findBaseContext(context, getOptionalDynContext(ann, obj));
        Object dep = findPreviouslyResolvedDep(objClass, meth, resolver, baseContext);
        if (dep != null) return dep;
        try {
            boolean success = InternalCjm.globalSync.tryLock(1, TimeUnit.MILLISECONDS);
            if (success) {
                try {
                    Object depAgain = findPreviouslyResolvedDep(objClass, meth, resolver, baseContext);
                    if (depAgain != null) return depAgain;
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
                                .getLocalName()), InternalCjm.DEFAULT_DEPENDENCY);
                    }
                    if (newDep.res == null && resolver.getName() != null) {
                        newDep.addRes(new SimpleResource(resolver.getName(), racks
                                .getFirst().getScope(resolver.getName(), objClass, null)));
                    }
                    for (SpiceRack rack : racks) {
                        newDep.dep = newDep.rackAllResources(rack, objClass, obj, newDep.dep);
                    }
                    if (newDep.dep == InternalCjm.DEFAULT_DEPENDENCY) {
                        throw new DependencyInjectionException(
                                "Failed to find dependency: " + newDep.res);
                    } else {
                        return newDep.dep;
                    }
                } finally {
                    InternalCjm.globalSync.unlock();
                }
            } else {
                return findDynamicDependency(obj, objClass, ann, meth, context);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private CjmContext getOptionalDynContext(CjmDynamic ann, Object obj) {
        String contextMethod = ann.contextMethod();
        if (!"".equals(contextMethod)) {
            try {
                Method m = obj.getClass().getMethod(contextMethod);
                return new CjmContext((String) m.invoke(obj));
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

    private void logAnnotatedMock(SpiceRack rack, DiscoveredResource
            objDep, DependencyFunctor<Object> depInjector) {
        if (objDep == null && "AnnotatedMock".equals(depInjector.getInjectedLabel())) {
            System.out.println("Looking in " + rack.getDirectory().getName());
        }
    }

    private static class ClassContextKey {
        final Class<?> clzz;
        final CjmContext cc;

        public ClassContextKey(Class<?> clzz, CjmContext cc) {
            this.clzz = clzz;
            this.cc = cc;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassContextKey that = (ClassContextKey) o;

            if (!Objects.equals(clzz, that.clzz)) return false;
            return Objects.equals(cc, that.cc);
        }

        @Override
        public int hashCode() {
            int result = clzz != null ? clzz.hashCode() : 0;
            result = 31 * result + (cc != null ? cc.hashCode() : 0);
            return result;
        }
    }
}
