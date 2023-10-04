package org.coinjema.internal.context.names;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.ContextOriented;
import org.coinjema.internal.context.NameLoop;

import java.util.Collection;

public class RedirectNameResolver extends AbstractNameResolver {
	String name;
	ResourceNameResolver parent;
	
	public RedirectNameResolver(String name,ResourceNameResolver parent)
	{
		this.name = name;
		this.parent = parent;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	protected String nextName() {
		return null;
	}

	@Override
	protected void reset() {

	}

	public Object findMatchingUnfinishedObject(
			Collection<ContextOriented> unfinishedObjects,
			CjmContext cc) {
		return parent.findMatchingUnfinishedObject(unfinishedObjects,cc);
	}

	public String getLocalName() {
		return name;
	}

	public Object findDependency(NameLoop evaluator) {
		return evaluator.getDependency(name);
	}

}
