package org.coinjema.nontest;

import org.coinjema.context.*;

public class SimpleContextOriented extends AbstractContextOriented {

	public SimpleContextOriented() {
		super();
		Cjm.contextualize(this);
	}
	
	public SimpleContextOriented(CjmContext cc)
	{
		Cjm.contextualize(this,cc);
	}
	
	@CjmDependency(method="circular")
	public void setCircularDependency(SimpleContextOrientedB g)
	{
		circular = g;
	}
	
	SimpleContextOrientedB circular;
	
	public SimpleContextOrientedB getCircular()
	{
		return circular;
	}
	
	@CjmDependency(method="test")
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
