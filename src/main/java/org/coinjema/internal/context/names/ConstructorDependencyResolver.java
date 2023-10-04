package org.coinjema.internal.context.names;

import org.coinjema.cjm.*;
import org.coinjema.internal.context.*;

import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

public class ConstructorDependencyResolver<T extends ConstructorContextOriented> implements ResourceNameResolver {

    private final Class<T> clzz;
    private final ConstructorDependency depAnn;
    private final Parameter param;
    AtomicReference<String> name = new AtomicReference<>();

    public ConstructorDependencyResolver(Class<T> clzz, Parameter param) {
        this.clzz = clzz;
        this.depAnn = param.getAnnotation(ConstructorDependency.class);
        this.param = param;
    }

    protected static String getSimpleName(final Class<?> clazz) {
        CjmConstructorObject ann = findObjectConstructorAnnotation(clazz);
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

    public String getFailedToFindMessage() {
        return name.get();
    }

    public boolean hasDefault() {
        return depAnn.hasDefault();
    }

    @Override
    public <R> R findDependency(NameLoop<R> evaluator) {
        if (name.get() == null) calcName(evaluator);
        if (name.get() == null) return null;
        return evaluator.getDependency(name.get());
    }

    @Override
    public Object findMatchingUnfinishedObject(Collection<ContextOriented> unfinishedObjects, CjmContext cc) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("DynamicDependencyResolver: looking for match with resource: " + getName() + " in context: " + cc);
        }
        for (ContextOriented co : unfinishedObjects) {
            if (log.isLoggable(Level.FINEST)) {
                log.finest("DynamicDependencyResolver: Examining object: " + co + " against " + this);
            }
            if (co.getCoinjemaContext().equals(cc) && param.getType().isAssignableFrom(co.getClass())) {
                if (log.isLoggable(Level.FINEST)) {
                    log.finest("DynamicDependencyResolver: Examining object: " + co + " against " + this + " it matches");
                }
                return co;
            }
        }
        return null;
    }

    private Object calcName(NameLoop<?> evaluator) {
        if (depAnn != null) {
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
        String lbl = param.getType().getSimpleName();
        Object obj = evaluator.getDependency(lbl);
        if (obj != null) {
            name.compareAndSet(null, lbl);
            return obj;
        }
        return null;
    }

    public Class<T> getTargetClass() {
        return clzz;
    }

    @Override
    public String getLocalName() {
        if (depAnn != null) {
            if (depAnn.alias() != null && !depAnn.alias().isEmpty()) {
                return depAnn.alias();
            }
            if (depAnn.method() != null && !depAnn.method().isEmpty()) {
                String lbl = getSimpleName(clzz) + "." + depAnn.method();
                return lbl;
            }
            if (depAnn.type() != null && !depAnn.type().isEmpty()) {
                String lbl = depAnn.type();
                return lbl;
            }
        }
        return getSimpleName(clzz) + "." + this.param.getName();
    }

    @Override
    public String getName() {
        return name.get();
    }
}
