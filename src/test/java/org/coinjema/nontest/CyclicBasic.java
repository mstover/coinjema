package org.coinjema.nontest;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject(type="cyclic")
public class CyclicBasic {

	public CyclicBasic() {
	}
	
	public CyclicBasic(CoinjemaContext cc)
	{}
	
	private CyclicSingleton single;
	
	@CoinjemaDependency(type="cyclic.static")
	public void setSingle(CyclicSingleton cs)
	{
		single = cs;
	}

	public CyclicSingleton getSingle() {
		return single;
	}

}
