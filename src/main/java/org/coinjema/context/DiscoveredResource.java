package org.coinjema.context;

import org.coinjema.context.source.Resource;
import org.coinjema.context.source.SimpleResource;

import java.util.ArrayList;
import java.util.List;

class DiscoveredResource {
    List<Resource> res;
    Object dep;

    public DiscoveredResource(Resource r, Object d) {
        res = new ArrayList<>();
        if (r != null)
            res.add(r);
        dep = d;
    }

    public String toString() {
        return "Discovered Resource(depOf:" + dep + "; res:" + res + ")";
    }

    public boolean hasNoResource() {
        return res == null || res.isEmpty();
    }

    public Object rackAllResources(SpiceRack rack, Class<?> aClass, Object obj, Object dep) {
        Object ret = dep;
        if (res != null) {
            for (Resource re : res) {
                ret = rack.addContext(re, aClass, obj, dep);
            }
        }
        return ret;
    }

    public void addRes(Resource newRes) {
        if (res == null) {
            res = new ArrayList<>();
        }
        res.add(newRes);
    }
}
