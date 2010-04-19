package org.coinjema.context;

import org.coinjema.nontest.UnAnnotated;

public class TestUnAnnotated extends AbstractContextTester {

	public TestUnAnnotated() {
		super();
	}

	public TestUnAnnotated(String arg0) {
		super(arg0);
	}
	
	public void testUnAnnotated() throws Exception
	{
		UnAnnotated ua = new UnAnnotated();
		assertEquals("I'm UnAnnotated",ua.getName());
		assertEquals("Has Default",ua.getValue());
	}

}
