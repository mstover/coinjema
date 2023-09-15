package org.coinjema.nontest;

import org.coinjema.context.CoinjemaDynamic;

public class StaticDynamic {
	
	static String name = getDynName();

	public StaticDynamic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@CoinjemaDynamic(alias="static_dynamic.name")
	public static String getDynName()
	{
		return null;
	}
	
	public String getName()
	{
		return name;
	}

}
