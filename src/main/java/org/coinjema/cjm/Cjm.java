package org.coinjema.cjm;

import org.coinjema.internal.context.*;
import org.coinjema.internal.context.names.*;

import java.lang.reflect.Method;

public final class Cjm {



    public static void contextualize(ContextOriented obj) {
        contextualize(obj, null, ContextFactory.getContext());
    }

    public static void contextualize(ContextOriented obj, CjmContext context) {
        contextualize(obj, context, ContextFactory.getContext());
    }

    public static void contextualize(final ContextOriented obj,
                                     final CjmContext context, final CjmContext base) {
        InternalCjm.runWithContextualizer(contextualizer -> {
            contextualizer.contextualize(obj, context, base);
            if (SpiceRack.getRoot().isReconfigurable()) {
                SpiceRack.contextObjects.addObject(obj);
            }
        });
    }


    public static <T extends ConstructorContextOriented> T constructContextualized(final Class<T> objClass, Object[] givenArgs,
                                                                                   final CjmContext context, final CjmContext base) {
        T newObj = InternalCjm.returnWithConstructorContextualizer(cc -> cc.constructContextualized(objClass, givenArgs, context, base));
        if (SpiceRack.getRoot().isReconfigurable()) {
            SpiceRack.contextObjects.addObject(newObj);
        }
        return newObj;
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
        return InternalCjm.returnWithContextualizer(contextualizer -> contextualizer.findDynamicDependency(obj, objClass, ann, meth, context));
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
