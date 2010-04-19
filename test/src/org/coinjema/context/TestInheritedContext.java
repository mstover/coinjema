package org.coinjema.context;

import java.net.URL;

import org.coinjema.nontest.SubContextOriented;

public class TestInheritedContext extends AbstractContextTester {

    public TestInheritedContext() {
        super();
    }

    public TestInheritedContext(String arg0) {
        super(arg0);
    }

    public void testInjectionCount() throws Exception
    {
        SubContextOriented counter = new SubContextOriented();
        
		assertEquals(new URL("http://coinjema.sourceforge.net/"),counter.getHome());
		assertEquals("path1",counter.getPaths()[0]);
    }
}
