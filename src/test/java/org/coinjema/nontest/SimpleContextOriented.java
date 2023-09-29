package org.coinjema.nontest;

import org.coinjema.context.*;

public class SimpleContextOriented extends AbstractContextOriented {

	public SimpleContextOriented() {
		super();
		Recipe.contextualize(this);
	}
	
	public SimpleContextOriented(CoinjemaContext cc)
	{
		Recipe.contextualize(this,cc);
	}
	
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
