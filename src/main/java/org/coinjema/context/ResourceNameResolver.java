package org.coinjema.context;

import java.util.Collection;

public interface ResourceNameResolver {
	public String getLocalName();
	public String getName();
	
	public <T> T findDependency(NameLoop<T> evaluator);
	public Object findMatchingUnfinishedObject(Collection<ContextOriented> unfinishedObjects, CjmContext cc);

}
