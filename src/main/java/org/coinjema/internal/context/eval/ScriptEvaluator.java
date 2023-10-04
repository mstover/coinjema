package org.coinjema.internal.context.eval;

import org.coinjema.internal.context.DiscoveredResource;
import org.coinjema.cjm.source.ContextSource;
import org.coinjema.cjm.source.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.coinjema.logging.CoinjemaLogger.log;

/**
 * Register your plug-in evaluator here.
 *
 * @author mikes
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
        addEvaluator("construct", new ConstructEvaluator());
    }

    public static DiscoveredResource evaluate(String scriptName,
                                              ContextSource source, Map scriptParameters) {
        Resource res = source.getResource(scriptName);
        try {
            if (res != null) {
                Evaluator evaluator = evaluators.get(res.getFormat());
                if (evaluator == null)
                    throw new RuntimeException("Not Coinjema evaluator found for format '" + res.getFormat() + "'");
                Object dep = evaluator.evaluate(res,
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
