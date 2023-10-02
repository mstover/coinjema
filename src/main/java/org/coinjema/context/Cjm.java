package org.coinjema.context;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;

public final class Cjm {

    static final Object DEFAULT_DEPENDENCY = new Object();
    static final ReentrantLock globalSync = new ReentrantLock();
    static ScopedValue<ObjectSetterContextualizer> CONTEXTUALIZER = ScopedValue.newInstance();
    static ScopedValue<ConstructorContextualizer> CONSTRUCTOR_CONTEXTUALIZER = ScopedValue.newInstance();


    public static void contextualize(ContextOriented obj) {
        contextualize(obj, null, ContextFactory.getContext());
    }

    public static void contextualize(ContextOriented obj, CjmContext context) {
        contextualize(obj, context, ContextFactory.getContext());
    }

    public static void contextualize(final ContextOriented obj,
                                     final CjmContext context, final CjmContext base) {
        runWithContextualizer(contextualizer -> {
            contextualizer.contextualize(obj, context, base);
            if (SpiceRack.getRoot().isReconfigurable()) {
                SpiceRack.contextObjects.addObject(obj);
            }
        });
    }


    static void runWithContextualizer(Consumer<ObjectSetterContextualizer> func) {
        if (CONTEXTUALIZER.isBound()) func.accept(CONTEXTUALIZER.get());
        else
            ScopedValue.runWhere(CONTEXTUALIZER, new ObjectSetterContextualizer(), () -> func.accept(CONTEXTUALIZER.get()));

    }

    static <T> T returnWithContextualizer(Function<ObjectSetterContextualizer, T> func) {
        if (CONTEXTUALIZER.isBound()) return func.apply(CONTEXTUALIZER.get());
        else {
            try {
                return ScopedValue.callWhere(CONTEXTUALIZER, new ObjectSetterContextualizer(), () -> func.apply(CONTEXTUALIZER.get()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static <T> T returnWithConstructorContextualizer(Function<ConstructorContextualizer, T> func) {
        if (CONSTRUCTOR_CONTEXTUALIZER.isBound()) return func.apply(CONSTRUCTOR_CONTEXTUALIZER.get());
        else {
            try {
                return ScopedValue.callWhere(CONSTRUCTOR_CONTEXTUALIZER, new ConstructorContextualizer(), () -> func.apply(CONSTRUCTOR_CONTEXTUALIZER.get()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void contextualizeWithoutSave(final ContextOriented obj,
                                         final CjmContext context, final CjmContext base) {
        runWithContextualizer(contextualizer -> {
            contextualizer.contextualize(obj, context, base);
        });
    }

    public static <T extends ConstructorContextOriented> T constructContextualized(final Class<T> objClass, Object[] givenArgs,
                                                                                   final CjmContext context, final CjmContext base) {
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
            return findDynamicDependency(obj, clzz, method.getAnnotation(CjmDynamic.class), method, ((ContextOriented) obj).getCoinjemaContext());
        else {
            return findDynamicDependency(obj, clzz, method.getAnnotation(CjmDynamic.class), method, ContextFactory.getContext());
        }
    }

    static Object findDynamicDependency(final Object obj, final Class objClass,
                                        final CjmDynamic ann, final Method meth,
                                        CjmContext context) {
        return returnWithContextualizer(contextualizer -> contextualizer.findDynamicDependency(obj, objClass, ann, meth, context));
    }

    static SpiceRack findBaseContext(CjmContext base,
                                     CjmContext sub) {
        if (base == null && sub == null) {
            return SpiceRack.getRoot();
        } else if (base == null) {
            base = SpiceRack.getRoot().getContext();
        } else if (sub == null) {
            sub = SpiceRack.getRoot().getContext();
        }
        SpiceRack rack = null;
        CjmContext subParent = sub;
        while (subParent != null && rack == null) {
            CjmContext parent = base;
            while (parent != null && rack == null) {
                rack = SpiceRack.getInstance(new CjmContext(parent,
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
        if (CONTEXTUALIZER.isBound()) return CONTEXTUALIZER.get();
        else return new ObjectSetterContextualizer();
    }

    public static <T> T getDep(DependencyDefinitionI<T> def) {
        return switch (def) {
            case AliasDefinition(var obj, var depClass, var alias) ->
                    (T) new SingleDepContextualizer(obj, new SimpleStringResolver(alias), ContextFactory.getContext()).getDepOf();
            case TypeDefinition(var obj, var depClass) ->
                    (T) new SingleDepContextualizer(obj, new DepOfResolver<>(depClass), ContextFactory.getContext()).getDepOf();
            case DependencyDefinition(
                    var obj, var depClass, var method, var type
            ) when method != null && type != null ->
                    (T) new SingleDepContextualizer(obj, new DepForTypeNameResolver(type, method), ContextFactory.getContext()).getDepOf();
            case DependencyDefinition(
                    var obj, var depClass, var method, var type
            ) ->
                    (T) new SingleDepContextualizer(obj, new DepForMethodNameResolver(obj.getClass(), method), ContextFactory.getContext()).getDepOf();
            case ObjectDependencyDefinition(
                    var obj, var depClass, var method, var type
            ) when method != null && type == null ->
                    (T) new SingleDepContextualizer(obj, new DepForMethodNameResolver(obj.getClass(), method), ContextFactory.getContext()).getDepOf();
            case ObjectDependencyDefinition(var obj, var depClass, var method, var type) ->
                    (T) new SingleDepContextualizer(obj, new DepForTypeNameResolver(type, method), ContextFactory.getContext()).getDepOf();
            case ResourceNameDefinition(var resName) ->
                    (T) new ResourceNameContextualizer(new SimpleStringResolver(resName), ContextFactory.getContext()).getDepOf();
            default -> throw new IllegalStateException("Unexpected value: " + def);
        };
    }

    public static <T> T getDep(DependencyDefinitionI<T> def, CjmContext givenContext) {
        return switch (def) {
            case AliasDefinition(var obj, var depClass, var alias) ->
                    (T) new SingleDepContextualizer(obj, new SimpleStringResolver(alias), ContextFactory.getContext(), givenContext).getDepOf();
            case TypeDefinition(var obj, var depClass) ->
                    (T) new SingleDepContextualizer(obj, new DepOfResolver<>(depClass), ContextFactory.getContext(), givenContext).getDepOf();
            case DependencyDefinition(var obj, var depClass, var method, var type)
                    when method != null && type != null ->
                    (T) new SingleDepContextualizer(obj, new DepForTypeNameResolver(type, method), ContextFactory.getContext(), givenContext).getDepOf();
            case DependencyDefinition(var obj, var depClass, var method, var type) ->
                    (T) new SingleDepContextualizer(obj, new DepForMethodNameResolver(obj.getClass(), method), ContextFactory.getContext(), givenContext).getDepOf();
            case ObjectDependencyDefinition(
                    var obj, var depClass, var method, var type
            ) when method != null && type == null ->
                    (T) new SingleDepContextualizer(obj, new DepForMethodNameResolver(obj.getClass(), method), ContextFactory.getContext(), givenContext).getDepOf();
            case ObjectDependencyDefinition(var obj, var depClass, var method, var type) ->
                    (T) new SingleDepContextualizer(obj, new DepForTypeNameResolver(type, method), ContextFactory.getContext(), givenContext).getDepOf();
            case ResourceNameDefinition(var resName) ->
                    (T) new ResourceNameContextualizer(new SimpleStringResolver(resName), ContextFactory.getContext(),givenContext).getDepOf();
            default -> throw new IllegalStateException("Unexpected value: " + def);
        };
    }

    public static Object getDep(String resourceName) {
        return getDep(new ResourceNameDefinition(resourceName));
    }
}
