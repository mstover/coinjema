package org.coinjema.nontest;

import org.coinjema.context.*;

@CoinjemaObject(type="cyclic")
public class CyclicBasic extends AbstractContextOriented {

	public CyclicBasic() {
		Recipe.contextualize(this);
	}
	
	public CyclicBasic(CoinjemaContext cc)
	{
		Recipe.contextualize(this,cc);
	}
	
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
