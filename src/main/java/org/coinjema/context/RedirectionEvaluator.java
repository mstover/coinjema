package org.coinjema.context;

import org.coinjema.context.source.Resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.coinjema.logging.CoinjemaLogger.log;

class RedirectionEvaluator {

    public static String findRedirectName(final String scriptName, final SpiceRack base) {
        return RackLoop.loop(base, rack -> findRedirectLoopLogic(scriptName, rack));
    }

    private static String findRedirectLoopLogic(String scriptName, SpiceRack rack) {
        Resource redirect = rack.getDirectory().getResource(scriptName, "redirect");
        log.fine("Redirect resource found( " + rack.getContext().getName() + ") " + redirect + " scriptname = " + scriptName);
        if (redirect == null || !redirect.getFormat().equals("redirect")) return null;
        try (InputStream stream = redirect.getInputStream();
             BufferedReader redirectContents = new BufferedReader(new InputStreamReader(stream))) {
            String redirectName = redirectContents.readLine();
            log.fine("Redirected to " + redirectName);
            return redirectName;
        } catch (Exception e) {
            throw new RuntimeException("Unable to read redirection script: " + scriptName + ".redirect", e);
        }
    }
}
