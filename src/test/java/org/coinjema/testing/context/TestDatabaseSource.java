package org.coinjema.testing.context;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.ContextFactory;
import org.coinjema.cjm.source.JdbcContextSource;
import org.coinjema.testing.nontest.BasicContextOriented;
import org.coinjema.testing.nontest.TestDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
public class TestDatabaseSource extends AbstractContextTester {

	
	@BeforeEach public void setUp() throws Exception
	{
		super.setUp();
		ContextFactory.createContext("database",new JdbcContextSource(new TestDataSource(),"coinjema","database"));
	}

	@Test
	public void testDatabaseContext() throws Exception
	{
		BasicContextOriented obj = new BasicContextOriented(new CjmContext("database"));
		assertEquals("db3",obj.getPaths()[0]);
	}

	@Test
	public void testChildDatabaseContext() throws Exception
	{
		BasicContextOriented obj = new BasicContextOriented(new CjmContext("database/customer"));
		assertEquals("cust3",obj.getPaths()[0]);
	}

}
