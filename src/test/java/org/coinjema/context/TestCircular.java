package org.coinjema.context;

import org.coinjema.nontest.CyclicBasic;
import org.coinjema.nontest.CyclicSingleton;
import org.coinjema.nontest.CyclicalDynamic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCircular extends AbstractContextTester {


	@Test
	public void testCyclicalDynamic() throws Exception
	{
		CyclicalDynamic dyn = new CyclicalDynamic();
		CyclicBasic base = dyn.getBasicObject();
		assertEquals(base.getSingle(),base.getSingle().getCB().getSingle());
	}

	@Test
	public void testCyclicalDynamic2() throws Exception
	{
		CyclicBasic base = new CyclicBasic();
		assertEquals(base.getSingle(),base.getSingle().getCB().getSingle());		
	}

	@Test
	public void testCyclicalDynamic3() throws Exception
	{
		CyclicSingleton cs = new CyclicSingleton();
		assertNotNull(cs.getDyn().getBasicObject().getSingle());
	}
	
	

}
