package org.coinjema.context;

import org.coinjema.nontest.AdvancedContextObject;
import org.coinjema.nontest.BasicContextOriented;
import org.coinjema.nontest.DefaultDynamic;
import org.coinjema.nontest.StaticDynamic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDynamic extends AbstractContextTester {


	@Test
	public void testDynamicProperties() throws Exception
	{
		assertEquals("red",new AdvancedContextObject().getDynamicProperties().getProperty("color"));
		assertEquals("purple",new AdvancedContextObject(new CoinjemaContext("custom")).getDynamicProperties().getProperty("color"));
		assertEquals("red",new AdvancedContextObject(new CoinjemaContext("config")).getDynamicProperties().getProperty("color"));
		assertEquals("orange",new AdvancedContextObject(new CoinjemaContext("override")).getDynamicProperties().getProperty("color"));
	}

	@Test
	public void testThroughSingleton() throws Exception
	{
		BasicContextOriented co = new BasicContextOriented(new CoinjemaContext("custom"));
		assertEquals("purple",co.getDynamicProperty("color"));
	}

	@Test
	public void testStaticDynamic() throws Exception
	{
		StaticDynamic s = new StaticDynamic();
		assertEquals("earl",s.getName());
	}

	@Test
	public void testDefaultDynamic() throws Exception
	{
		DefaultDynamic dd = new DefaultDynamic();
		assertEquals("Howdy",dd.getDefaultDynamic());
	}

}
