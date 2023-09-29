package org.coinjema.nontest;

import org.coinjema.context.AbstractContextOriented;
import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;
import org.coinjema.context.Recipe;

@CoinjemaObject(type="cyclic.static")
public class CyclicSingleton extends AbstractContextOriented {
	
	CyclicBasic cb;

	public CyclicSingleton() {
		super();
		Recipe.contextualize(this);
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
