package org.coinjema.context;

import org.coinjema.nontest.HasGroovyProperties;

public class TestGroovyProperties extends AbstractContextTester {

	public TestGroovyProperties() {
		super();
	}

	public TestGroovyProperties(String arg0) {
		super(arg0);
	}
	
	public void testGroovyProperties() throws Exception
	{
		HasGroovyProperties obj = new HasGroovyProperties();
		assertEquals("org.coinjema.nontest.HasGroovyProperties",obj.getProperty("this.class"));
	}

}
