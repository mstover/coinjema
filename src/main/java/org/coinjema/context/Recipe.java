package org.coinjema.context;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

public final class Recipe {

    static final Object DEFAULT_DEPENDENCY = new Object();
    static final ThreadLocal<ObjectSetterContextualizer> CONTEXTUALIZER = ThreadLocal.withInitial(() -> null);
    static final ThreadLocal<ConstructorContextualizer> CONSTRUCTOR_CONTEXTUALIZER = ThreadLocal.withInitial(() -> null);
    static final ThreadLocal<CoinjemaContext> contextStack = ThreadLocal.withInitial(() -> null);
    static final ReentrantLock globalSync = new ReentrantLock();
    private static final ConcurrentMap<Class<?>, ConstructorFuncterSet<?>> constructorFunctorMap = new ConcurrentHashMap<>();
    private static final Map<Object, Object> inConstruction = new ConcurrentHashMap<>();
    static DynamicDepTracker dynTracker = new DynamicDepTracker();


    public static void contextualize(ContextOriented obj) {
        contextualize(obj, null, ContextFactory.peek());
    }

    public static void contextualize(ContextOriented obj, CoinjemaContext context) {
        contextualize(obj, context, ContextFactory.peek());
    }

    public static void contextualize(final ContextOriented obj,
                                     final CoinjemaContext context, final CoinjemaContext base) {
        runWithContextualizer(contextualizer -> {
            contextualizer.contextualize(obj, context, base);
            if (SpiceRack.getRoot().isReconfigurable()) {
                SpiceRack.contextObjects.addObject(obj);
            }
        });
    }

    static boolean enterConstruct(ConstructorContextOriented obj) {
        Object o = inConstruction.putIfAbsent(obj.getClass(), obj);
        return o == null;
    }

    static void exitConstruct(ConstructorContextOriented obj) {
        inConstruction.remove(obj.getClass());
    }


    static void runWithContextualizer(Consumer<ObjectSetterContextualizer> func) {
        ObjectSetterContextualizer objectSetterContextualizer = CONTEXTUALIZER.get();
        if (objectSetterContextualizer != null) {
            func.accept(objectSetterContextualizer);
        } else {
            ObjectSetterContextualizer contextualizer = new ObjectSetterContextualizer();
            CONTEXTUALIZER.set(contextualizer);
            try {
                func.accept(contextualizer);
            } finally {
                CONTEXTUALIZER.remove();
            }
        }
    }

    static <T> T returnWithContextualizer(Function<ObjectSetterContextualizer, T> func) {
        T out = null;
        ObjectSetterContextualizer objectSetterContextualizer = CONTEXTUALIZER.get();
        if (objectSetterContextualizer != null) {
            out = func.apply(objectSetterContextualizer);
        } else {
            ObjectSetterContextualizer contextualizer = new ObjectSetterContextualizer();
            CONTEXTUALIZER.set(contextualizer);
            try {
                out = func.apply(contextualizer);
            } finally {
                CONTEXTUALIZER.remove();
            }
        }
        return out;
    }

    static <T> T returnWithConstructorContextualizer(Function<ConstructorContextualizer, T> func) {
        T out = null;
        ConstructorContextualizer cc = CONSTRUCTOR_CONTEXTUALIZER.get();
        if (cc != null) {
            out = func.apply(cc);
        } else {
            ConstructorContextualizer contextualizer = new ConstructorContextualizer();
            CONSTRUCTOR_CONTEXTUALIZER.set(contextualizer);
            try {
                out = func.apply(contextualizer);
            } finally {
                CONSTRUCTOR_CONTEXTUALIZER.remove();
            }
        }
        return out;
    }

    static void contextualizeWithoutSave(final ContextOriented obj,
                                         final CoinjemaContext context, final CoinjemaContext base) {
        runWithContextualizer(contextualizer -> {
            contextualizer.contextualize(obj, context, base);
        });
    }

    public static <T extends ConstructorContextOriented> T constructContextualized(final Class<T> objClass, Object[] givenArgs,
                                                                                   final CoinjemaContext context, final CoinjemaContext base) {
        T newObj = returnWithConstructorContextualizer(cc -> cc.constructContextualized(objClass, givenArgs, context, base));
        if (SpiceRack.getRoot().isReconfigurable()) {
            SpiceRack.contextObjects.addObject(newObj);
        }
        return newObj;
    }

    static Object captureDep(final Map<String, Object> values,
                             ResourceNameResolver resolver, SpiceRack master) {
        return returnWithContextualizer(contextualizer -> contextualizer.captureDep(values, resolver, master));
    }

    public static Object dynamicGetter(Object obj, Class<?> clzz, String methodName) {
        Method method = null;
        try {
            method = clzz.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        if (obj instanceof ContextOriented && ((ContextOriented) obj).isGiven())
            return findDynamicDependency(obj, clzz, method.getAnnotation(CoinjemaDynamic.class), method, ((ContextOriented) obj).getCoinjemaContext());
        else {
            return findDynamicDependency(obj, clzz, method.getAnnotation(CoinjemaDynamic.class), method, ContextFactory.peek());
        }
    }

    static Object findDynamicDependency(final Object obj, final Class objClass,
                                        final CoinjemaDynamic ann, final Method meth,
                                        CoinjemaContext context) {
        return returnWithContextualizer(contextualizer -> contextualizer.findDynamicDependency(obj, objClass, ann, meth, context));
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

    public static <T> T getDep(DependencyDefinitionI<T> def) {
        return switch (def) {
            case AliasDefinition(var obj, var depClass, var alias) ->
                    (T) new SingleDepContextualizer(obj, new DepForAliasNameResolver(alias), ContextFactory.peek()).getDepOf();
            case TypeDefinition(var obj, var depClass) ->
                    (T) new SingleDepContextualizer(obj, new DepOfResolver<>(depClass), ContextFactory.peek()).getDepOf();
            case DependencyDefinition(
                    var obj, var depClass, var method, var type
            ) when method != null && type != null ->
                    (T) new SingleDepContextualizer(obj, new DepForTypeNameResolver(type, method), ContextFactory.peek()).getDepOf();
            case DependencyDefinition(
                    var obj, var depClass, var method, var type
            ) ->
                    (T) new SingleDepContextualizer(obj, new DepForMethodNameResolver(obj.getClass(), method), ContextFactory.peek()).getDepOf();
            case ObjectDependencyDefinition(var obj,var depClass,var method,var type) when method != null && type == null ->
                    (T) new SingleDepContextualizer(obj, new DepForMethodNameResolver(obj.getClass(), method), ContextFactory.peek()).getDepOf();
            case ObjectDependencyDefinition(var obj,var depClass,var method,var type) ->
                    (T) new SingleDepContextualizer(obj, new DepForTypeNameResolver(type, method), ContextFactory.peek()).getDepOf();
            default -> throw new IllegalStateException("Unexpected value: " + def);
        };
    }

    public static <T> T getDep(DependencyDefinitionI<T> def, CoinjemaContext givenContext) {
        return switch (def) {
            case AliasDefinition(var obj, var depClass, var alias) ->
                    (T) new SingleDepContextualizer(obj, new DepForAliasNameResolver(alias), ContextFactory.peek(), givenContext).getDepOf();
            case TypeDefinition(var obj, var depClass) ->
                    (T) new SingleDepContextualizer(obj, new DepOfResolver<>(depClass), ContextFactory.peek(), givenContext).getDepOf();
            case DependencyDefinition(var obj, var depClass, var method, var type)
                    when method != null && type != null ->
                    (T) new SingleDepContextualizer(obj, new DepForTypeNameResolver(type, method), ContextFactory.peek(), givenContext).getDepOf();
            case DependencyDefinition(var obj, var depClass, var method, var type)
                    when method != null ->
                    (T) new SingleDepContextualizer(obj, new DepForMethodNameResolver(obj.getClass(), method), ContextFactory.peek(), givenContext).getDepOf();
            default -> throw new IllegalStateException("Unexpected value: " + def);
        };
    }

    private <T extends ContextOriented> T contextualizeIt(final Class<T> clzz, Object[] givenArgs,
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
}
