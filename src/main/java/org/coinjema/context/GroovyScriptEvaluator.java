package org.coinjema.context;

import static org.coinjema.logging.CoinjemaLogger.log;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.logging.Level;

import org.coinjema.context.eval.Evaluator;
import org.coinjema.context.source.Resource;

public class GroovyScriptEvaluator implements Evaluator {

	public Object evaluate(final Resource source, final Map params) {
		Reader scriptBytes = source.getReader();
		if (scriptBytes != null) {
			Binding vars = new Binding(params);
			GroovyShell shell = new GroovyShell(vars);
			try {
				return shell.evaluate(scriptBytes);
			} catch (Exception e) {
				log.log(Level.SEVERE, "Couldn't evaluate script: " + source, e);
				throw new DependencyInjectionException(
						"Couldn't evaluate script: " + source, e);
			} finally {
				try {
					scriptBytes.close();
				} catch (IOException e) {
					throw new RuntimeException("Failed to close config file: "
							+ source, e);
				}
			}
		}
		return null;
	}

}
