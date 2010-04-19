package org.coinjema.context;

import junit.framework.TestCase;

import org.coinjema.context.source.FileContextSource;

public class AbstractContextTester extends TestCase {

	public AbstractContextTester() {
		super();
	}

	public AbstractContextTester(String arg0) {
		super(arg0);
	}

	@Override
	public void setUp() throws Exception {
		ContextFactory.createRootContext(new FileContextSource("test/config1"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		ContextFactory.destroyContext(null);
	}

	public void testNothing() {

	}

}
