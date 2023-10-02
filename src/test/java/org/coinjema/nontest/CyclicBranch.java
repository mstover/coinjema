package org.coinjema.nontest;

import org.coinjema.context.CjmDependency;
import org.coinjema.context.CjmObject;

@CjmObject
public class CyclicBranch {
	
	CyclicSingleton single;

	public CyclicBranch() {
		super();
	}
	
	@CjmDependency(type="cyclic.static")
	public void setSingle(CyclicSingleton cs)
	{
		single = cs;
	}

	public CyclicSingleton getSingle() {
		return single;
	}

}
