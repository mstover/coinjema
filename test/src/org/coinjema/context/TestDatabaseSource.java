package org.coinjema.context;

import org.coinjema.context.source.JdbcContextSource;
import org.coinjema.nontest.BasicContextOriented;
import org.coinjema.nontest.TestDataSource;

public class TestDatabaseSource extends AbstractContextTester {

	public TestDatabaseSource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestDatabaseSource(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public void setUp() throws Exception
	{
		super.setUp();
		ContextFactory.createContext("database",new JdbcContextSource(new TestDataSource(),"coinjema","database"));
	}
	
	public void testDatabaseContext() throws Exception
	{
		BasicContextOriented obj = new BasicContextOriented(new CoinjemaContext("database"));
		assertEquals("db3",obj.getPaths()[0]);
	}
	
	public void testChildDatabaseContext() throws Exception
	{
		BasicContextOriented obj = new BasicContextOriented(new CoinjemaContext("database/customer"));
		assertEquals("cust3",obj.getPaths()[0]);
	}

}
