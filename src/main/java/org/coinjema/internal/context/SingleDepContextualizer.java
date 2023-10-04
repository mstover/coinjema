package org.coinjema.internal.context;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.DependencyInjectionException;
import org.coinjema.internal.context.names.ResourceNameResolver;
import org.coinjema.cjm.source.SimpleResource;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SingleDepContextualizer extends AbstractContextualizer {
    private final Class<?> clzz;
    private final CjmContext base;
    private final ResourceNameResolver resolver;

    private final CjmContext subContext;
    private final Object obj;

    public SingleDepContextualizer(Object obj, ResourceNameResolver resolver, CjmContext peek) {
        this.clzz = obj.getClass();
        this.obj = obj;
        this.base = peek;
        this.resolver = resolver;
        this.subContext = null;
    }

    public SingleDepContextualizer(Object obj, ResourceNameResolver resolver, CjmContext peek, CjmContext sub) {
        this.clzz = obj.getClass();
        this.obj = obj;
        this.base = peek;
        this.resolver = resolver;
        this.subContext = sub;
    }

    public Object getDepOf() {
        SpiceRack baseContext = InternalCjm.findBaseContext(base, subContext);
        Object dep = findPreviouslyResolvedDep(baseContext);
        if (dep != null) return dep;
        try {
            InternalCjm.globalSync.lock();
            Object depAgain = findPreviouslyResolvedDep(baseContext);
            if (depAgain != null) return depAgain;
            final LinkedList<SpiceRack> racks = new LinkedList<SpiceRack>();
            final Map<String, Object> values = new HashMap<>();
            values.put("obj", obj);
            values.put("resolver", resolver);
            values.put("objClass", clzz);
            DiscoveredResource discoveredDep = RackLoop.loop(baseContext, rack -> {
                DiscoveredResource objDep = captureDepInContextStack(values, resolver, rack);
                racks.addFirst(rack);
                return objDep;
            });
            if (discoveredDep == null || discoveredDep.dep == null) {
                throw new DependencyInjectionException(
                        "Failed to find dependency for "
                                + resolver.getName() + " for class "
                                + clzz.getName() + " in context " + baseContext.getContext());
            }
            if (discoveredDep.res == null && resolver.getName() != null) {
                discoveredDep.addRes(new SimpleResource(resolver.getName(), racks.getFirst()
                        .getScope(resolver.getName(), clzz, obj)));
            }
            for (SpiceRack rack : racks) {
                if (resolver.getName() == null) {
                    break;
                } else {
                    discoveredDep.dep = discoveredDep.rackAllResources(rack, clzz, obj, discoveredDep.dep);
                }
            }
            return discoveredDep.dep;
        } finally {
            InternalCjm.globalSync.unlock();
        }
    }

    private Object findPreviouslyResolvedDep(SpiceRack baseContext) {
        Object dep = resolver.findDependency(resourceName -> baseContext.lookupContext(resourceName, clzz, obj));
        return dep;
    }
}
