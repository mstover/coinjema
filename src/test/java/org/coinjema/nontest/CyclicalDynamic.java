package org.coinjema.nontest;

import org.coinjema.context.CjmDynamic;
import org.coinjema.context.Cjm;

public class CyclicalDynamic {

	public CyclicalDynamic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@CjmDynamic(alias="cyclic.basic")
	public static CyclicBasic getBasicObject()
	{
		return (CyclicBasic) Cjm.dynamicGetter(null,CyclicalDynamic.class,"getBasicObject");
	}

}
