package org.coinjema.context;

import java.util.Collection;

public abstract class AbstractSingleDepResolver implements ResourceNameResolver {

    private final String name;

    protected AbstractSingleDepResolver(String name) {
        this.name = name;
    }

    protected static String getSimpleName(final Class<?> clazz) {
        CjmConstructorObject ann = AbstractSingleDepResolver.findObjectConstructorAnnotation(clazz);
        if (ann != null && !ann.type().isEmpty())
            return ann.type();
        else
            return clazz.getSimpleName();
    }

    protected static CjmConstructorObject findObjectConstructorAnnotation(Class<?> clazz) {
        Class<?> parent = clazz;
        CjmConstructorObject ann = null;
        while (ann == null && parent != Object.class) {
            ann = (CjmConstructorObject) parent.getAnnotation(CjmConstructorObject.class);
            if (ann == null)
                parent = parent.getSuperclass();
        }
        return ann;
    }

    @Override
    public String getLocalName() {
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public <T> T findDependency(NameLoop<T> evaluator) {
        return evaluator.getDependency(name);
    }

    @Override
    public Object findMatchingUnfinishedObject(Collection<ContextOriented> unfinishedObjects, CjmContext cc) {
        return null;
    }
}
