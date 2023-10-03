package org.coinjema.context;

import org.coinjema.util.DependencyFunctor;

import java.util.Collection;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

public class InjectorNameResolver extends AbstractNameResolver {

    DependencyFunctor<?> injector;
    Class<?> objClass;
    String fixedName = null;
    String localName, typeName, globalName;
    int count = -1;

    public InjectorNameResolver(Class objClass, DependencyFunctor<?> injector) {
        this.objClass = objClass;
        this.injector = injector;
    }

    @Override
    public String toString() {
        return "InjectorNameResolver{" +
                "injector=" + injector +
                ", objClass=" + objClass +
                ", fixedName='" + fixedName + '\'' +
                ", localName='" + localName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", globalName='" + globalName + '\'' +
                ", count=" + count +
                '}';
    }

    protected void reset() {
        fixedName = null;
        count = -1;
    }

    @Override
    public Object findDependency(NameLoop evaluator) {
        String name = getLocalName();
        Object res = evaluator.getDependency(name);
        if (res != null) {
            fixedName = name;
            return res;
        }
        name = getTypeName();
        res = evaluator.getDependency(name);
        if (res != null) {
            fixedName = name;
            return res;
        }
        name = getGlobalName();
        if (name != null)
            res = evaluator.getDependency(name);
        if (res != null) {
            fixedName = name;
            return res;
        }
        fixedName = null;
        return null;
    }

    public String getLocalName() {
        return localName != null ? localName : (localName = (injector.isAliased() ? injector.getAliasLabel() : getSimpleName(objClass) + "." + injector.getMethodLabel()));
    }

    public String getName() {
        return fixedName;
    }

    public String nextName() {
        count++;
        switch (count) {
            case 0:
                fixedName = getLocalName();
                return fixedName;
            case 1:
                fixedName = getTypeName();
                return fixedName;
            case 2:
                fixedName = getGlobalName();
                return fixedName;
            default:
                return null;
        }
    }

    private String getGlobalName() {
        return globalName != null ? globalName : (globalName = injector.isAliased() ? injector.getInjectedLabel() : null);
    }

    private String getTypeName() {
        return typeName != null ? typeName : (typeName = injector.isAliased() ? getSimpleName(objClass) + "." + injector.getMethodLabel() : injector.getInjectedLabel());
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((injector == null) ? 0 : injector.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final InjectorNameResolver other = (InjectorNameResolver) obj;
        if (injector == null) {
            if (other.injector != null)
                return false;
        } else if (!injector.equals(other.injector))
            return false;
        return true;
    }

    public Object findMatchingUnfinishedObject(Collection<ContextOriented> unfinishedObjects,
                                               CjmContext cc) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("DynamicDependencyResolver: looking for match with resource: " + getName() + " in context: " + cc);
        }
        for (ContextOriented co : unfinishedObjects) {
            if (log.isLoggable(Level.FINEST)) {
                log.finest("DynamicDependencyResolver: Examining object: " + co + " against " + this);
            }
            if (co.getCoinjemaContext().equals(cc) && injector.getInjectedClass().isAssignableFrom(co.getClass())) {
                if (log.isLoggable(Level.FINEST)) {
                    log.finest("DynamicDependencyResolver: Examining object: " + co + " against " + this + " it matches");
                }
                return co;
            }
        }
        return null;
    }

}
