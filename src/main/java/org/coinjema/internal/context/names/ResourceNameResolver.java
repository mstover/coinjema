package org.coinjema.internal.context.names;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.ContextOriented;
import org.coinjema.internal.context.NameLoop;

import java.util.Collection;

public interface ResourceNameResolver {
	public String getLocalName();
	public String getName();
	
	public <T> T findDependency(NameLoop<T> evaluator);
	public Object findMatchingUnfinishedObject(Collection<ContextOriented> unfinishedObjects, CjmContext cc);

}
