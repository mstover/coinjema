package org.coinjema.nontest;

import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject
public class CyclicBranch {
	
	CyclicSingleton single;

	public CyclicBranch() {
		super();
	}
	
	@CoinjemaDependency(type="cyclic.static")
	public void setSingle(CyclicSingleton cs)
	{
		single = cs;
	}

	public CyclicSingleton getSingle() {
		return single;
	}

}
