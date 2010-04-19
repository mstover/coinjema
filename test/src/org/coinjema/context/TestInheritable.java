package org.coinjema.context;

import org.coinjema.nontest.InheritingObject;

public class TestInheritable extends AbstractContextTester {

	public TestInheritable() {
		super();
	}

	public TestInheritable(String arg0) {
		super(arg0);
	}

	public void testInheritableProperties() throws Exception {
		InheritingObject io = new InheritingObject();
		assertEquals("value_1", io.getProps().getProperty("prop_1"));
		assertEquals(System.getProperty("user.dir"), io.getProps().getProperty(
				"prop_2"));
		io = new InheritingObject(new CoinjemaContext("config2"));
		assertEquals("value_1", io.getProps().getProperty("prop_1"));
		assertEquals("value_2.1", io.getProps().getProperty("prop_2"));
		assertEquals("value_3", io.getProps().getProperty("prop_3"));
		io = new InheritingObject(new CoinjemaContext("config2/config3"));
		assertEquals("value_1", io.getProps().getProperty("prop_1"));
		assertEquals("value_2.1", io.getProps().getProperty("prop_2"));
		assertEquals("value_3.2", io.getProps().getProperty("prop_3"));
		assertEquals("value_4", io.getProps().getProperty("prop_4"));
		io = new InheritingObject(new CoinjemaContext("custom"));
		assertEquals("value_1", io.getProps().getProperty("prop_1"));
		assertEquals(System.getProperty("user.dir"), io.getProps().getProperty(
				"prop_2"));
		io = new InheritingObject(new CoinjemaContext(
				"config2/config3/config4/config5"));
		assertEquals("value_1", io.getProps().getProperty("prop_1"));
		assertEquals("value_2.1", io.getProps().getProperty("prop_2"));
		assertEquals("value_5", io.getProps().getProperty("prop_5"));

	}

	public void testInheritableProperties2() throws Exception {
		InheritingObject io = new InheritingObject(new CoinjemaContext(
				"config2/config3/config4/config5"));
		assertEquals("value_1", io.getProps().getProperty("prop_1"));
		assertEquals("value_2.1", io.getProps().getProperty("prop_2"));
		assertEquals("value_5", io.getProps().getProperty("prop_5"));

	}

}
