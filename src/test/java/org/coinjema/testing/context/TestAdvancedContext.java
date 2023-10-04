package org.coinjema.testing.context;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.ContextFactory;
import org.coinjema.cjm.ContextOriented;
import org.coinjema.testing.nontest.AdvancedContextObject;
import org.coinjema.testing.nontest.BasicContextOriented;
import org.coinjema.testing.nontest.DataBaseObject;
import org.junit.jupiter.api.Assertions;
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
    	BasicContextOriented co2 = new BasicContextOriented(new CjmContext("custom"));
    	assertEquals(co.getPaths(),co2.getPaths());
    }

    @Test
    public void testDuplicateShared() throws Exception
    {
    	BasicContextOriented bo = new BasicContextOriented(new CjmContext("dup_shared"));
    	assertEquals("Hello",bo.getMyService().getMockName());
    }

    @Test
    public void testExcludedContexts() throws Exception
    {
    	BasicContextOriented bo = new BasicContextOriented(new CjmContext("_excluded"));
    	assertEquals("path1",bo.getPaths()[0]);
    	bo = new BasicContextOriented(new CjmContext("custom/not_included"));
    	assertEquals("path1",bo.getPaths()[0]);
    }

    @Test
    public void testContextSharing() throws Exception
    {
    	BasicContextOriented bo = new BasicContextOriented();
    	assertSame(bo.getMyService(), ContextFactory.getRegistry("").getSharedDep("MockSingleton"));
    }

    @Test
    public void testDynamicContextualization() throws Exception
    {
    	AdvancedContextObject aco = new AdvancedContextObject("config1/override");
    	Assertions.assertEquals("",((ContextOriented)aco).getCoinjemaContext().getName());
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
