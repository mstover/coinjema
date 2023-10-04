package org.coinjema.testing.nontest;

import org.coinjema.cjm.AbstractContextOriented;
import org.coinjema.cjm.Cjm;
import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.CjmDependency;

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
