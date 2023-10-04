package org.coinjema.internal.context.eval;

import org.coinjema.cjm.source.Resource;

import java.util.Map;

/**
 * Implement this interface to create a new type of script that can return a Java object
 * for Coinjema dependencies.  Register it in Coinjema via:
 * 
 * ScriptEvaluator.addEvaluator(&lt;your new evaluator&gt;);
 * @author Michael Stover (mstover1@apache.org)
 * @see ScriptEvaluator
 *
 */
public interface Evaluator {
	
	public Object evaluate(Resource source, Map<String,Object> params);

}
