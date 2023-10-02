package org.coinjema.context;

import org.coinjema.context.source.SimpleResource;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ResourceNameContextualizer extends AbstractContextualizer {
    private final CjmContext base;
    private final ResourceNameResolver resolver;

    private final CjmContext subContext;


    public ResourceNameContextualizer(ResourceNameResolver resolver, CjmContext base) {
        this.resolver = resolver;
        this.base = base;
        this.subContext = null;
    }

    public ResourceNameContextualizer(ResourceNameResolver resolver, CjmContext base, CjmContext sub) {
        this.resolver = resolver;
        this.base = base;
        this.subContext = sub;
    }

    public Object getDepOf() {
        SpiceRack baseContext = Cjm.findBaseContext(base, subContext);
        Object dep = findPreviouslyResolvedDep(baseContext);
        if (dep != null) return dep;
        try {
            Cjm.globalSync.lock();
            Object depAgain = findPreviouslyResolvedDep(baseContext);
            if (depAgain != null) return depAgain;
            final LinkedList<SpiceRack> racks = new LinkedList<SpiceRack>();
            final Map<String, Object> values = new HashMap<>();
            values.put("obj", "");
            values.put("resolver", resolver);
            values.put("objClass", Object.class);
            DiscoveredResource discoveredDep = RackLoop.loop(baseContext, rack -> {
                DiscoveredResource objDep = captureDepInContextStack(values, resolver, rack);
                racks.addFirst(rack);
                return objDep;
            });
            if (discoveredDep == null || discoveredDep.dep == null) {
                throw new DependencyInjectionException(
                        "Failed to find dependency for "
                                + resolver.getName() + " in context " + baseContext.getContext());
            }
            if (discoveredDep.res == null && resolver.getName() != null) {
                discoveredDep.addRes(new SimpleResource(resolver.getName(), racks.getFirst()
                        .getScope(resolver.getName(), Object.class, null)));
            }
            for (SpiceRack rack : racks) {
                if (resolver.getName() == null) {
                    break;
                } else {
                    discoveredDep.dep = discoveredDep.rackAllResources(rack, Object.class, null, discoveredDep.dep);
                }
            }
            return discoveredDep.dep;
        } finally {
            Cjm.globalSync.unlock();
        }
    }

    private Object findPreviouslyResolvedDep(SpiceRack baseContext) {
        Object dep = resolver.findDependency(resourceName -> baseContext.lookupContext(resourceName, Object.class, null));
        if (dep != null) return dep;
        return null;
    }
}
