package org.coinjema.context;

import static org.coinjema.logging.CoinjemaLogger.log;

import java.util.HashMap;
import java.util.Map;

import org.coinjema.context.eval.Evaluator;
import org.coinjema.context.source.ContextSource;
import org.coinjema.context.source.Resource;

/**
 * Register your plug-in evaluator here.
 * 
 * @author mikes
 * 
 */
public class ScriptEvaluator {

	private static Map<String, Evaluator> evaluators;

	static {
		evaluators = new HashMap<String, Evaluator>();
		addEvaluator("txt", new TextEvaluator());
		addEvaluator("groovy", new GroovyScriptEvaluator());
		addEvaluator("gproperties", new GroovyPropertiesEvaluator());
		addEvaluator("properties", new PropertiesEvaluator());
		addEvaluator("groovyClass", new GroovyClassEvaluator());
		addEvaluator("compmap", new ComponentMapEvaluator());
		addEvaluator("jser", new JavaEvaluator());
		addEvaluator("groovySql", new GroovySqlEvaluator());
	}

	static synchronized DiscoveredResource evaluate(String scriptName,
			ContextSource source, Map scriptParameters) {
		Resource res = source.getResource(scriptName);
		try {
			if (res != null) {
				Object dep = evaluators.get(res.getFormat()).evaluate(res,
						scriptParameters);
				if (dep != null) {
					return new DiscoveredResource(res, dep);
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			log.warning("Failed to interpret " + res.getFormat() + " file");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Register your plug-in evaluator here..
	 * 
	 * @param e
	 */
	public static void addEvaluator(String extension, Evaluator e) {
		evaluators.put(extension, e);
	}
}
