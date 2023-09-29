package org.coinjema.nontest;

import org.coinjema.context.CoinjemaDynamic;
import org.coinjema.context.Recipe;

public class CyclicalDynamic {

	public CyclicalDynamic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@CoinjemaDynamic(alias="cyclic.basic")
	public static CyclicBasic getBasicObject()
	{
		return (CyclicBasic) Recipe.dynamicGetter(null,CyclicalDynamic.class,"getBasicObject");
	}

}
