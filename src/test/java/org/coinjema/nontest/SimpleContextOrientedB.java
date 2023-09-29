package org.coinjema.nontest;

import org.coinjema.context.*;

@CoinjemaObject(type="B")
public class SimpleContextOrientedB extends AbstractContextOriented {

	public SimpleContextOrientedB() {
		super();
		Recipe.contextualize(this);
	}

	public SimpleContextOrientedB(CoinjemaContext c)
	{
		Recipe.contextualize(this,c);
	}



	@CoinjemaDependency(method="circular")
	public void setCircularDependency(SimpleContextOriented g)
	{
		circular = g;
	}

	SimpleContextOriented circular;

	public SimpleContextOriented getCircular()
	{
		return circular;
	}

	@CoinjemaDependency(method="test")
	public void setTestString(String t)
	{
		test = t;
	}

	@CoinjemaDependency(type="MockSingleton")
	public void setService(MockSingleton m)
	{
		service = m;
	}

	MockSingleton service;

	public MockSingleton getService()
	{
		return service;
	}

	String test;

	public String getTest() {
		return test;
	}
}
