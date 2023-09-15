package org.coinjema.context;

import org.coinjema.nontest.AdvancedContextObject;
import org.coinjema.nontest.BasicContextOriented;
import org.coinjema.nontest.DataBaseObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TestAdvancedContext extends AbstractContextTester {

    @Test
    public void testObjectNaming() throws Exception
    {
        AdvancedContextObject service = new AdvancedContextObject();
        assertEquals("coinjema",service.getProperty("projectName"));
    }

    @Test
    public void testDependencyReuse() throws Exception
    {
    	BasicContextOriented co = new BasicContextOriented();
    	BasicContextOriented co2 = new BasicContextOriented(new CoinjemaContext("custom"));
    	assertEquals(co.getPaths(),co2.getPaths());
    }

    @Test
    public void testDuplicateShared() throws Exception
    {
    	BasicContextOriented bo = new BasicContextOriented(new CoinjemaContext("dup_shared"));
    	assertEquals("Hello",bo.getMyService().getMockName());
    }

    @Test
    public void testExcludedContexts() throws Exception
    {
    	BasicContextOriented bo = new BasicContextOriented(new CoinjemaContext("_excluded"));
    	assertEquals("path1",bo.getPaths()[0]);
    	bo = new BasicContextOriented(new CoinjemaContext("custom/not_included"));
    	assertEquals("path1",bo.getPaths()[0]);
    }

    @Test
    public void testContextSharing() throws Exception
    {
    	BasicContextOriented bo = new BasicContextOriented();
    	assertSame(bo.getMyService(),ContextFactory.getRegistry("").getSharedDep("MockSingleton"));
    }

    @Test
    public void testDynamicContextualization() throws Exception
    {
    	AdvancedContextObject aco = new AdvancedContextObject("config1/override");
    	assertEquals("",((ContextOriented)aco).getCoinjemaContext().getName());
    }

    @Test
    @Disabled
    public void testDynamicDatabaseRetrieval() throws Exception
    {
    	DataBaseObject dbo = new DataBaseObject("database");
    	assertEquals("[\"db3\",\"db4\"] as String[]",dbo.getData());
    	
    	assertEquals("[[\"db3\",\"db4\"] as String[], [\"cust3\",\"cust4\"] as String[]]",dbo.getAllData().toString());
    }

    @Test
    @Disabled
    public void testDynamicDatabaseRetrieval2() throws Exception
    {
    	DataBaseObject dbo = new DataBaseObject("custom");
    	assertEquals("[\"cust3\",\"cust4\"] as String[]",dbo.getData());
    	
    	assertEquals("[[\"db3\",\"db4\"] as String[], [\"cust3\",\"cust4\"] as String[]]",dbo.getAllData().toString());
    }

}
