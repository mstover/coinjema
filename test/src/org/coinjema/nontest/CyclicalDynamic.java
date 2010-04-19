package org.coinjema.nontest;

import org.coinjema.context.CoinjemaDynamic;

public class CyclicalDynamic {

	public CyclicalDynamic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@CoinjemaDynamic(alias="cyclic.basic")
	public static CyclicBasic getBasicObject()
	{
		return null;
	}

}
