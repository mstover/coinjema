package org.coinjema.nontest;

import org.coinjema.context.AbstractContextOriented;
import org.coinjema.context.CjmDependency;
import org.coinjema.context.CjmObject;
import org.coinjema.context.Cjm;

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
