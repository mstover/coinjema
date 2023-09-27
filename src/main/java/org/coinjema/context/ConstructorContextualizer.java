package org.coinjema.context;

import org.coinjema.context.source.SimpleResource;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

public class ConstructorContextualizer {
    private static final ConcurrentMap<Class<?>, ConstructorFuncterSet<?>> constructorFunctorMap = new ConcurrentHashMap<>();
    private CoinjemaContext currentTopContext;

    public <T extends ConstructorContextOriented> T constructContextualized(Class<T> objClass, Object[] givenArgs, CoinjemaContext context, CoinjemaContext base) {
        return contextualizeIt(objClass, givenArgs, context, base);
    }

    private <T extends ConstructorContextOriented> T contextualizeIt(Class<T> clzz, Object[] givenArgs, CoinjemaContext context, CoinjemaContext base) {
        ConstructorFuncterSet<T> functors = (ConstructorFuncterSet<T>) constructorFunctorMap.computeIfAbsent(clzz, c -> new ConstructorFuncterSet<>(clzz));

        boolean topLevel = currentTopContext == null;
        if (log.isLoggable(Level.FINER)) {
            log.finer("Base context = "
                    + (topLevel ? base : currentTopContext)
                    + " sub-context = " + context);
        }
        final SpiceRack baseContext = Recipe.findBaseContext(topLevel ? base : currentTopContext, context);
        if (log.isLoggable(Level.FINER)) {
            log.finer("Resolved context = " + baseContext.getContext());
        }
        Object[] argsToUse = new Object[functors.argCount()];
        int index = 0;
        for (ConstructorDependencyResolver<?> resolver : functors) {
            Object dep = resolver.findDependency(resourceName -> baseContext.lookupContext(resourceName, clzz, null));
            if (dep != null) {
                argsToUse[index] = dep;
            } else {
                argsToUse = contextualizeFirstTime(functors, givenArgs, context, base);
                break;
            }
            index++;
        }
        try {
            return (T) functors.constructor().newInstance(argsToUse);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to construct object for " + functors.getFailedToConstructMessage(e), e);
        }

    }

    private <T extends ConstructorContextOriented> Object[] contextualizeFirstTime(ConstructorFuncterSet<T> functors, Object[] givenArgs, CoinjemaContext context, CoinjemaContext base) {
        try {
            ObjectSetterContextualizer.globalSync.lock();
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
            return createContextArgValues(functors, givenArgs, baseContext);
        } finally {
            ObjectSetterContextualizer.globalSync.unlock();
        }
    }

    private <T extends ConstructorContextOriented> Object[] createContextArgValues(ConstructorFuncterSet<T> functors, Object[] givenArgs, SpiceRack baseContext) {
        Object[] argsToUse = new Object[functors.argCount()];
        int index = 0;
        for (ConstructorDependencyResolver resolver : functors) {
            argsToUse[index] = resolveDep(resolver, baseContext);
            index++;
        }
        return argsToUse;
    }

    private Object resolveDep(ConstructorDependencyResolver resolver, SpiceRack baseContext) {
        final LinkedList<SpiceRack> racks = new LinkedList<SpiceRack>();
        final Map<String, Object> values = new HashMap<>();
        Object out = null;
        values.put("resolver", resolver);
        values.put("objClass", resolver.getTargetClass());
        DiscoveredResource dep = RackLoop.loop(baseContext, rack -> {
            DiscoveredResource objDep = captureDepInContextStack(values, resolver, rack);
            racks.addFirst(rack);
            return objDep;
        });
        if (dep == null || dep.dep == null) {
            if (resolver.hasDefault()) {
                dep = new DiscoveredResource(new SimpleResource(resolver
                        .getLocalName()), Recipe.DEFAULT_DEPENDENCY);
            } else {
                throw new DependencyInjectionException(
                        "Failed to find dependency for "
                                + resolver.getLocalName() + " of class "
                                + resolver.getTargetClass().getName());
            }
        } else if (dep.dep != Recipe.DEFAULT_DEPENDENCY) {
            out = dep.dep;
        }
        if (dep.res == null && resolver.getName() != null) {
            dep.res = new SimpleResource(resolver.getName(), racks.getFirst()
                    .getScope(resolver.getName(), resolver.getTargetClass(), null));
        }
        for (SpiceRack rack : racks) {
            if (dep.dep == Recipe.DEFAULT_DEPENDENCY) {
                dep.dep = rack
                        .addContext(dep.res, resolver.getTargetClass(), null, dep.dep);
            } else if (resolver.getName() == null) {
                break;
            } else {
                dep.dep = rack
                        .addContext(dep.res, resolver.getTargetClass(), null, dep.dep);
            }
        }
        return out;
    }

    private DiscoveredResource captureDepInContextStack(Map<String, Object> values, ResourceNameResolver resolver, SpiceRack base) {
        CoinjemaContext cc = currentTopContext;
        try {
            currentTopContext = base.getContext();
            return captureDep(values, resolver, base);
        } finally {
            currentTopContext = cc;
        }
    }

    DiscoveredResource captureDep(final Map<String, Object> values, ResourceNameResolver resolver, SpiceRack base) {
        values.put("registry", base);
        return resolveScript(values, resolver, base);
    }

    private DiscoveredResource resolveScript(Map<String, Object> values, ResourceNameResolver resolver, SpiceRack base) {
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

    private DiscoveredResource resolveScriptNameLoop(Map<String, Object> values, ResourceNameResolver resolver, SpiceRack base, String resourceName) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("looking for resource: " + resourceName
                    + " in context '"
                    + base.getContext().getName() + "'");
        }
        return ScriptEvaluator.evaluate(resourceName, base.getDirectory(), values);
    }

    private DiscoveredResource redirect(Map<String, Object> values, SpiceRack base, String redirect, ResourceNameResolver parentResolver) {
        DiscoveredResource dep;
        final Map<String, Object> newValues = new HashMap<String, Object>(values);
        SpiceRack sub = base;
        int x = -1;
        if ((x = redirect.lastIndexOf("/")) > -1) {
            sub = Recipe.findBaseContext(base.getContext(), new CoinjemaContext(
                    redirect.substring(0, x)));
            redirect = redirect.substring(x + 1);
        }
        final RedirectNameResolver redirectResolve = new RedirectNameResolver(
                redirect, parentResolver);
        dep = RackLoop.limitedLoop(sub, base, rack -> captureDepInContextStack(newValues, redirectResolve, rack));
        return dep;
    }
}
