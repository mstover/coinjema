package org.coinjema.nontest;

import java.util.Properties;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaDynamic;

public class SimpleDynamic {

	public SimpleDynamic() {
		super();
	}
	
	public SimpleDynamic(CoinjemaContext cc)
	{
		
	}
	
	@CoinjemaDynamic(method="simpleProps",type="Properties")
	public Properties getProperties()
	{
		return null;
	}
	
	@CoinjemaDynamic(alias="static_dynamic.name")
	public static String getDynName()
	{
		return null;
	}

}
