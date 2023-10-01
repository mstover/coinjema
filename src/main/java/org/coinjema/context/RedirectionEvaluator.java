package org.coinjema.context;

import org.coinjema.context.source.MetaType;
import org.coinjema.context.source.Resource;
import org.coinjema.context.source.SimpleResource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import static org.coinjema.logging.CoinjemaLogger.log;

class RedirectionEvaluator {

    public static SimpleResource findRedirectName(final String scriptName, final SpiceRack base) {
        return RackLoop.loop(base, rack -> findRedirectLoopLogic(scriptName, rack));
    }

    private static SimpleResource findRedirectLoopLogic(String scriptName, SpiceRack rack) {
        Resource redirect = rack.getDirectory().getResource(scriptName, "redirect");
        log.fine("Redirect resource found( " + rack.getContext().getName() + ") " + redirect + " scriptname = " + scriptName);
        if (redirect == null || !redirect.getFormat().equals("redirect")) return null;
        try (InputStream stream = redirect.getInputStream();
             BufferedReader redirectContents = new BufferedReader(new InputStreamReader(stream))) {
            String redirectName = redirectContents.readLine();
            log.fine("Redirected to " + redirectName);
            return new SimpleResource(redirectName, getScope(redirect.getMetaTypes()));
        } catch (Exception e) {
            throw new RuntimeException("Unable to read redirection script: " + scriptName + ".redirect", e);
        }
    }

    private static MetaType getScope(Collection<MetaType> metaTypes) {
        for (MetaType metaType : metaTypes) {
            if (metaType == MetaType.global || metaType == MetaType.perClass || metaType == MetaType.perObj)
                return metaType;
        }
        return null;
    }
}
