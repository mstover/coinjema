package org.coinjema.context.eval;

import java.util.Map;

import org.coinjema.context.source.Resource;

/**
 * Implement this interface to create a new type of script that can return a Java object
 * for Coinjema dependencies.  Register it in Coinjema via:
 * 
 * ScriptEvaluator.addEvaluator(&lt;your new evaluator&gt;);
 * @author Michael Stover (mstover1@apache.org)
 * @see org.coinjema.context.ScriptEvaluator
 *
 */
public interface Evaluator {
	
	public Object evaluate(Resource source,Map<String,Object> params);

}
