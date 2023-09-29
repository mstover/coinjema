package org.coinjema.context;

import java.util.*;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

public class AbstractContextualizer {
    protected final LinkedList<ContextOriented> unfinishedObjects = new LinkedList<>();
    private final Set<DependencyGroup> circleProtection = new HashSet<>();
    protected CoinjemaContext currentTopContext;

    DiscoveredResource captureDepInContextStack(final Map<String, Object> values,
                                                ResourceNameResolver resolver, SpiceRack base) {
        CoinjemaContext cc = currentTopContext;
        try {
            currentTopContext = base.getContext();
            return captureDep(values, resolver, base);
        } finally {
            currentTopContext = cc;
        }
    }

    DiscoveredResource captureDep(final Map<String, Object> values,
                                  ResourceNameResolver resolver, SpiceRack base) {
        values.put("registry", base);
        return resolveScript(values, resolver, base);
    }

    private DiscoveredResource resolveScript(final Map<String, Object> values,
                                             final ResourceNameResolver resolver, final SpiceRack base) {
        // since redirect preserves original context, have to look all the way
        // down for the redirect before
        // accepting any deps saved to the injector.
        DiscoveredResource dep = new DiscoveredResource(null, null);
        String redirect = resolver.findDependency(resourceName -> RedirectionEvaluator.findRedirectName(resourceName, base));
        if (redirect == null) {
            dep.dep = resolver.findDependency(resourceName -> base.lookupContext(resourceName, (Class<?>) values.get("objClass"), values.get("obj")));
            if (dep.dep != null) {
                return dep;
            }
            dep = resolver.findDependency(resourceName -> resolveScriptNameLoop(values, resolver, base, resourceName));
            if (dep != null && dep.dep != null) {
                dep.dep = base.addContext(dep.res, (Class<?>) values
                        .get("objClass"), values.get("obj"), dep.dep);
            }
        } else {
            dep = redirect(values, base, redirect, resolver);

        }
        return dep;
    }

    private DiscoveredResource resolveScriptNameLoop(Map<String, Object> values, ResourceNameResolver resolver, SpiceRack master, String resourceName) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("looking for resource: " + resourceName
                    + " in context '"
                    + master.getContext().getName() + "'");
        }
        DependencyGroup dp = new DependencyGroup(resourceName,
                master.getContext());
        if (circleProtection.contains(dp)) {
            if (log.isLoggable(Level.FINEST)) {
                log.finest("Retrieving unfinished Resource "
                        + resourceName + " in context "
                        + master.getContext().getName());
            }
            DiscoveredResource dr = new DiscoveredResource(null, resolver.findMatchingUnfinishedObject(unfinishedObjects, master.getContext()));
            if (dr.dep != null) {
                return dr;
            }
        }
        DiscoveredResource tempDep = null;
        try {
            circleProtection.add(dp);
            tempDep = ScriptEvaluator.evaluate(resourceName, master
                    .getDirectory(), values);
        } finally {
            circleProtection.remove(dp);
        }
        return tempDep;
    }

    private DiscoveredResource redirect(final Map<String, Object> values,
                                        final SpiceRack master, String redirect,
                                        ResourceNameResolver parentResolver) {
        DiscoveredResource dep;
        final Map<String, Object> newValues = new HashMap<String, Object>(values);
        SpiceRack sub = master;
        int x = -1;
        if ((x = redirect.lastIndexOf("/")) > -1) {
            sub = Recipe.findBaseContext(master.getContext(), new CoinjemaContext(
                    redirect.substring(0, x)));
            redirect = redirect.substring(x + 1);
        }
        final RedirectNameResolver redirectResolve = new RedirectNameResolver(
                redirect, parentResolver);
        dep = RackLoop.limitedLoop(sub, master, rack -> captureDepInContextStack(newValues, redirectResolve, rack));
        return dep;
    }
}
