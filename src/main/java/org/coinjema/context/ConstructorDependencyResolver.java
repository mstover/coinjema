package org.coinjema.context;

import java.lang.reflect.Parameter;
import java.util.concurrent.atomic.AtomicReference;

public class ConstructorDependencyResolver {

    private final Class<?> clzz;
    private final ConstructorDependency depAnn;
    private final Parameter param;
    AtomicReference<String> name = new AtomicReference<>();

    public ConstructorDependencyResolver(Class<?> clzz, Parameter param) {
        this.clzz = clzz;
        this.depAnn = param.getAnnotation(ConstructorDependency.class);
        this.param = param;
    }

    protected static String getSimpleName(final Class<?> clazz) {
        CoinjemaConstructorObject ann = findObjectConstructorAnnotation(clazz);
        if (ann != null && !ann.type().isEmpty())
            return ann.type();
        else
            return clazz.getSimpleName();
    }

    protected static CoinjemaConstructorObject findObjectConstructorAnnotation(Class<?> clazz) {
        Class<?> parent = clazz;
        CoinjemaConstructorObject ann = null;
        while (ann == null && parent != Object.class) {
            ann = (CoinjemaConstructorObject) parent.getAnnotation(CoinjemaConstructorObject.class);
            if (ann == null)
                parent = parent.getSuperclass();
        }
        return ann;
    }

    public String getFailedToFindMessage() {
        return name.get();
    }

    public Object findDependency(NameLoop<?> evaluator) {
        if (name.get() == null) calcName(evaluator);
        return evaluator.getDependency(name.get());
    }

    private Object calcName(NameLoop<?> evaluator) {
        if(depAnn != null) {
            if (depAnn.alias() != null && !depAnn.alias().isEmpty()) {
                Object obj = evaluator.getDependency(depAnn.alias());
                if (obj != null) {
                    name.compareAndSet(null, depAnn.alias());
                    return obj;
                }
            }
            if (depAnn.method() != null && !depAnn.method().isEmpty()) {
                String lbl = getSimpleName(clzz) + "." + depAnn.method();
                Object obj = evaluator.getDependency(lbl);
                if (obj != null) {
                    name.compareAndSet(null, lbl);
                    return obj;
                }
            }
            if (depAnn.type() != null && !depAnn.type().isEmpty()) {
                String lbl = depAnn.type();
                Object obj = evaluator.getDependency(lbl);
                if (obj != null) {
                    name.compareAndSet(null, lbl);
                    return obj;
                }
            }
        }
        String lbl = getSimpleName(clzz)+"."+param.getName();
        name.compareAndSet(null,lbl);
        return evaluator.getDependency(lbl);
    }
}
