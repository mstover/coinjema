package org.coinjema.context;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorFuncterSet<T extends ContextOriented> implements Iterable<ConstructorDependencyResolver> {
    private final Class<T> clzz;
    private final List<ConstructorDependencyResolver> resolvers = new ArrayList<>();

    public ConstructorFuncterSet(Class<T> clzz) {
        this.clzz = clzz;
        initResolvers();
    }

    private void initResolvers() {
        for (Constructor<?> constructor : clzz.getConstructors()) {
            Parameter[] parameters = constructor.getParameters();
            if (parameters.length > 0) {
                if(isCoinjemaConstructor(parameters)) {
                    resolvers.addAll(Arrays.stream(parameters).map(p -> new ConstructorDependencyResolver(clzz,p)).collect(Collectors.toList()));
                }
            }
        }
    }

    private static boolean isCoinjemaConstructor(Parameter[] parameters) {
        boolean hasAnnotations = false;
        for (Parameter parameter : parameters) {
            ConstructorDependency annotation = parameter.getAnnotation(ConstructorDependency.class);
            if (annotation != null) {
                hasAnnotations = true;
                break;
            }
        }
        return hasAnnotations;
    }

    @Override
    public Iterator<ConstructorDependencyResolver> iterator() {
        return resolvers.iterator();
    }

    public int argCount() {
        return resolvers.size();
    }

    public Constructor constructor() {
        return null;
    }

    public String getFailedToConstructMessage(ReflectiveOperationException e) {
        return null;
    }
}
