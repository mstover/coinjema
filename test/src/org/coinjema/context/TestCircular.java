package org.coinjema.context;

import org.coinjema.nontest.CyclicBasic;
import org.coinjema.nontest.CyclicSingleton;
import org.coinjema.nontest.CyclicalDynamic;

public class TestCircular extends AbstractContextTester {

	public TestCircular() {
		super();
	}

	public TestCircular(String arg0) {
		super(arg0);
	}
	
	public void testCyclicalDynamic() throws Exception
	{
		CyclicalDynamic dyn = new CyclicalDynamic();
		CyclicBasic base = dyn.getBasicObject();
		assertEquals(base.getSingle(),base.getSingle().getCB().getSingle());
	}
	
	public void testCyclicalDynamic2() throws Exception
	{
		CyclicBasic base = new CyclicBasic();
		assertEquals(base.getSingle(),base.getSingle().getCB().getSingle());		
	}
	
	public void testCyclicalDynamic3() throws Exception
	{
		CyclicSingleton cs = new CyclicSingleton();
		assertNotNull(cs.getDyn().getBasicObject().getSingle());
	}
	
	

}
