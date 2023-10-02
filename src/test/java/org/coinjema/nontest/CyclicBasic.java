package org.coinjema.nontest;

import org.coinjema.context.*;

@CjmObject(type="cyclic")
public class CyclicBasic extends AbstractContextOriented {

	public CyclicBasic() {
		Cjm.contextualize(this);
	}
	
	public CyclicBasic(CjmContext cc)
	{
		Cjm.contextualize(this,cc);
	}
	
	private CyclicSingleton single;
	
	@CjmDependency(type="cyclic.static")
	public void setSingle(CyclicSingleton cs)
	{
		single = cs;
	}

	public CyclicSingleton getSingle() {
		return single;
	}

}
