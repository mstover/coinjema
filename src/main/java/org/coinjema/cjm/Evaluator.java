package org.coinjema.cjm;

import org.coinjema.cjm.source.Resource;
import org.coinjema.internal.context.eval.ScriptEvaluator;

import java.util.Map;

/**
 * Implement this interface to create a new type of script that can return a Java object
 * for Coinjema dependencies.  Register it in Coinjema via:
 * <p>
 * ScriptEvaluator.addEvaluator(&lt;your new evaluator&gt;);
 *
 * @author Michael Stover (mstover1@apache.org)
 * @see ScriptEvaluator
 */
public interface Evaluator {

    static void addEvaluator(String extension, Evaluator eval) {
        ScriptEvaluator.addEvaluator(extension, eval);
    }

    public Object evaluate(Resource source, Map<String, Object> params);

}
