package org.coinjema.nontest;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject
public class SimpleContextOriented {

	public SimpleContextOriented() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SimpleContextOriented(CoinjemaContext cc)
	{}
	
	@CoinjemaDependency(method="circular")
	public void setCircularDependency(SimpleContextOrientedB g)
	{
		circular = g;
	}
	
	SimpleContextOrientedB circular;
	
	public SimpleContextOrientedB getCircular()
	{
		return circular;
	}
	
	@CoinjemaDependency(method="test")
	public void setTest(String t)
	{
		test = t;
	}
	
	String test;
	
	public String getTest()
	{
		return test;
	}
}
