package org.coinjema.nontest;

import org.coinjema.context.*;

@CjmObject(type="B")
public class SimpleContextOrientedB extends AbstractContextOriented {

	public SimpleContextOrientedB() {
		super();
		Cjm.contextualize(this);
	}

	public SimpleContextOrientedB(CjmContext c)
	{
		Cjm.contextualize(this,c);
	}



	@CjmDependency(method="circular")
	public void setCircularDependency(SimpleContextOriented g)
	{
		circular = g;
	}

	SimpleContextOriented circular;

	public SimpleContextOriented getCircular()
	{
		return circular;
	}

	@CjmDependency(method="test")
	public void setTestString(String t)
	{
		test = t;
	}

	@CjmDependency(type="MockSingleton")
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
