package org.coinjema.nontest;

import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject(type="cyclic.static")
public class CyclicSingleton {
	
	CyclicBasic cb;

	public CyclicSingleton() {
		super();
	}
	
	CyclicalDynamic dyn;
	
	@CoinjemaDependency(method="dynamic")
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
