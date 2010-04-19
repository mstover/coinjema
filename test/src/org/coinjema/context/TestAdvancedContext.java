package org.coinjema.context;

import org.coinjema.nontest.AdvancedContextObject;
import org.coinjema.nontest.BasicContextOriented;
import org.coinjema.nontest.DataBaseObject;

public class TestAdvancedContext extends AbstractContextTester {

    public TestAdvancedContext() {
        super();
    }

    public TestAdvancedContext(String arg0) {
        super(arg0);
    }
    
    public void testObjectNaming() throws Exception
    {
        AdvancedContextObject service = new AdvancedContextObject();
        assertEquals("coinjema",service.getProperty("projectName"));
    }
    
    public void testDependencyReuse() throws Exception
    {
    	BasicContextOriented co = new BasicContextOriented();
    	BasicContextOriented co2 = new BasicContextOriented(new CoinjemaContext("custom"));
    	assertEquals(co.getPaths(),co2.getPaths());
    }
    
    public void testDuplicateShared() throws Exception
    {
    	BasicContextOriented bo = new BasicContextOriented(new CoinjemaContext("dup_shared"));
    	assertEquals("Hello",bo.getMyService().getMockName());
    }
    
    public void testExcludedContexts() throws Exception
    {
    	BasicContextOriented bo = new BasicContextOriented(new CoinjemaContext("_excluded"));
    	assertEquals("path1",bo.getPaths()[0]);
    	bo = new BasicContextOriented(new CoinjemaContext("custom/not_included"));
    	assertEquals("path1",bo.getPaths()[0]);
    }
    
    public void testContextSharing() throws Exception
    {
    	BasicContextOriented bo = new BasicContextOriented();
    	assertSame(bo.getMyService(),ContextFactory.getRegistry("").getSharedDep("MockSingleton"));
    }
    
    public void testDynamicContextualization() throws Exception
    {
    	AdvancedContextObject aco = new AdvancedContextObject("config1/override");
    	assertEquals("",((ContextOriented)aco).getCoinjemaContext().getName());
    }
    
    public void testDynamicDatabaseRetrieval() throws Exception
    {
    	DataBaseObject dbo = new DataBaseObject("database");
    	assertEquals("[\"db3\",\"db4\"] as String[]",dbo.getData());
    	
    	assertEquals("[[\"db3\",\"db4\"] as String[], [\"cust3\",\"cust4\"] as String[]]",dbo.getAllData().toString());
    }
    
    public void testDynamicDatabaseRetrieval2() throws Exception
    {
    	DataBaseObject dbo = new DataBaseObject("custom");
    	assertEquals("[\"cust3\",\"cust4\"] as String[]",dbo.getData());
    	
    	assertEquals("[[\"db3\",\"db4\"] as String[], [\"cust3\",\"cust4\"] as String[]]",dbo.getAllData().toString());
    }

}
