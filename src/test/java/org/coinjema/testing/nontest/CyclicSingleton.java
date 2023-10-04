package org.coinjema.testing.nontest;

import org.coinjema.cjm.AbstractContextOriented;
import org.coinjema.cjm.CjmDependency;
import org.coinjema.cjm.CjmObject;
import org.coinjema.cjm.Cjm;

@CjmObject(type="cyclic.static")
public class CyclicSingleton extends AbstractContextOriented {
	
	CyclicBasic cb;

	public CyclicSingleton() {
		super();
		Cjm.contextualize(this);
	}
	
	CyclicalDynamic dyn;
	
	@CjmDependency(method="dynamic")
	public void setDynamic(CyclicalDynamic d)
	{
		dyn = d;
		cb = dyn.getBasicObject();
	}
	
	public CyclicalDynamic getDyn()
	{
		return dyn;
	}
	
	public CyclicBasic getCB()
	{
		return cb;
	}

}
