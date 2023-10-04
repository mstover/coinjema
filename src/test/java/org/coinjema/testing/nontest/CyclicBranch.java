package org.coinjema.testing.nontest;

import org.coinjema.cjm.CjmDependency;
import org.coinjema.cjm.CjmObject;

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
