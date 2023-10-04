package org.coinjema.testing.context;

import org.coinjema.cjm.CjmContext;
import org.coinjema.testing.nontest.AdvancedContextObject;
import org.coinjema.testing.nontest.BasicContextOriented;
import org.coinjema.testing.nontest.DefaultDynamic;
import org.coinjema.testing.nontest.StaticDynamic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDynamic extends AbstractContextTester {


	@Test
	public void testDynamicProperties() throws Exception
	{
		Assertions.assertEquals("red",new AdvancedContextObject().getDynamicProperties().getProperty("color"));
		assertEquals("purple",new AdvancedContextObject(new CjmContext("custom")).getDynamicProperties().getProperty("color"));
		assertEquals("red",new AdvancedContextObject(new CjmContext("config")).getDynamicProperties().getProperty("color"));
		assertEquals("orange",new AdvancedContextObject(new CjmContext("override")).getDynamicProperties().getProperty("color"));
	}

	@Test
	public void testThroughSingleton() throws Exception
	{
		BasicContextOriented co = new BasicContextOriented(new CjmContext("custom"));
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
