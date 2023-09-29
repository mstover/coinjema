package org.coinjema.context;

import org.coinjema.context.source.SimpleResource;
import org.coinjema.util.DependencyFunctor;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

class ObjectSetterContextualizer extends AbstractContextualizer{

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
                        Recipe.globalSync.lock();
                        injector.invoke(obj, dep);
                    } finally {
                        Recipe.globalSync.unlock();
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
            Recipe.globalSync.lock();
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
            Recipe.globalSync.unlock();
        }
    }

    private void contextualizing(ContextOriented obj) {
        unfinishedObjects.addFirst(obj);
    }

    private void doneContextualizing() {
        unfinishedObjects.removeFirst();
    }

    private FunctorSet retrieveFunctors(Object obj) {
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
                                + resolver.getName() + " of class "
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

}
