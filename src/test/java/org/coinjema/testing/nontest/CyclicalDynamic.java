package org.coinjema.testing.nontest;

import org.coinjema.cjm.CjmDynamic;
import org.coinjema.cjm.Cjm;

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
