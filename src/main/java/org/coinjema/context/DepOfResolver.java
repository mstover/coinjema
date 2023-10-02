package org.coinjema.context;

import java.util.Collection;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

public class DepOfResolver<T> extends AbstractSingleDepResolver {
    private final Class<T> clzz;

    public DepOfResolver(Class<T> clzz) {
        super(getSimpleName(clzz));
        this.clzz = clzz;
    }

    @Override
    public Object findMatchingUnfinishedObject(Collection<ContextOriented> unfinishedObjects, CjmContext cc) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("DepOfResolver: looking for match with resource: " + getName() + " in context: " + cc);
        }
        for (ContextOriented co : unfinishedObjects) {
            if (log.isLoggable(Level.FINEST)) {
                log.finest("DepOfResolver: Examining object: " + co + " against " + this);
            }
            if (co.getCoinjemaContext().equals(cc) && clzz.isAssignableFrom(co.getClass())) {
                if (log.isLoggable(Level.FINEST)) {
                    log.finest("DynamicDependencyResolver: Examining object: " + co + " against " + this + " it matches");
                }
                return co;
            }
        }
        return null;
    }

}
