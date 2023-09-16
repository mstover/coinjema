package org.coinjema.context;

import static org.coinjema.logging.CoinjemaLogger.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.coinjema.context.source.Resource;

class RedirectionEvaluator {

    public static String findRedirectName(final String scriptName, final SpiceRack base) {
    	return RackLoop.loop(base,rack ->     		{
			return findRedirectLoopLogic(scriptName, rack);
		});
    }

	private static String findRedirectLoopLogic(String scriptName, SpiceRack rack) {
		Resource redirect = rack.getDirectory().getResource(scriptName,"redirect");
		log.fine("Redirect resource found( " + rack.getContext().getName() + ") "+ redirect + " scriptname = " + scriptName);
		if(redirect == null || !redirect.getFormat().equals("redirect")) return null;
		InputStream stream = redirect.getInputStream();
		BufferedReader redirectContents = new BufferedReader(new InputStreamReader(stream));
		try {
			String redirectName = redirectContents.readLine();
			log.fine("Redirected to " + redirectName);
			return redirectName;
		}
		catch (Exception e) {
			throw new RuntimeException("Unable to read redirection script: " + scriptName + ".redirect",e);
		} finally
		{
			try {
				stream.close();
			} catch (IOException e) {
				throw new RuntimeException("Failed to close config file: " + scriptName,e);
			}
		}
	}
}
