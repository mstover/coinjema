package org.coinjema.context;

import org.coinjema.nontest.BasicContextOriented;

public class TestRedirection extends AbstractContextTester {

	public TestRedirection() {
		super();
	}

	public TestRedirection(String arg0) {
		super(arg0);
	}
    
    public void testRedirectScriptEvaluator() throws Exception
    {
        BasicContextOriented co1 = new BasicContextOriented();
        assertEquals(co1.getMyService(),co1.getRedirectedService());
    }
	
	public void testRedirection() throws Exception
	{
		BasicContextOriented co2 = new BasicContextOriented(
				new CoinjemaContext("config2"));
		assertEquals("config2 Value",co2.getRedirectedService().getMainValue());
		BasicContextOriented co1 = new BasicContextOriented();	
		assertEquals("Root Value",co1.getRedirectedService().getMainValue());
		BasicContextOriented co3 = new BasicContextOriented(new CoinjemaContext("config2/config3"));
		assertEquals("config3 Value",co3.getRedirectedService().getMainValue());
	}
	
	public void testRedirectToSubContext() throws Exception
	{
		BasicContextOriented co = new BasicContextOriented(new CoinjemaContext("redirect"));
		BasicContextOriented co2 = new BasicContextOriented(new CoinjemaContext("config2/config3"));
		assertTrue(co.getMyService() == co2.getMyService());
		BasicContextOriented co3 = new BasicContextOriented();
		assertTrue(co.getMyService() != co3.getMyService());
	}
	
	public void testRegistry() throws Exception
	{
		BasicContextOriented co = new BasicContextOriented(new CoinjemaContext("redirect"));
		assertEquals("overriden mock name",co.getPaths()[0]);
	}

}
