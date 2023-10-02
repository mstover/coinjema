package org.coinjema.context;

import java.net.URL;

import org.coinjema.nontest.BareBones;
import org.coinjema.nontest.BasicContextOriented;
import org.coinjema.nontest.MeatyBones;
import org.coinjema.nontest.PerformanceTestObject;
import org.coinjema.nontest.SimpleContextOrientedB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author mstover
 * 
 */
public class TestContextualize extends AbstractContextTester {
	String[] paths = new String[] { "path1", "path2" };

	@Test
	public void testBasicCO() throws Exception {
		BasicContextOriented co = new BasicContextOriented();
		assertNotNull(co);
		assertEquals("path1", co.getPaths()[0]);
		assertEquals("path2", co.getPaths()[1]);
		assertEquals(new URL("http://coinjema.sourceforge.net/"),co.getHome());
		BasicContextOriented co2 = new BasicContextOriented();
		assertNotNull(co2);
		assertEquals("path1", co2.getPaths()[0]);
		assertEquals("path2", co2.getPaths()[1]);
		assertEquals(new URL("http://coinjema.sourceforge.net/"),co2.getHome());
	}

	@Test
	public void testBareBones() throws Exception
	{
		BareBones bb = new BareBones();
		assertNotNull(bb.getHome());
		assertEquals("test string",bb.getSco().getTest());
		MeatyBones mb = new MeatyBones();
		assertNotNull(mb.getHome());
		assertEquals("test string",mb.getSco().getTest());
		mb = new MeatyBones();
		assertNotNull(mb.getHome());
		assertEquals("test string",mb.getSco().getTest());
	}

	@Test
	public void testContextBasics() throws Exception
	{
		CjmContext cc1 = new CjmContext("base/sub");
		CjmContext cc2 = new CjmContext(new CjmContext("base"),new CjmContext("sub"));
		assertEquals(cc1,cc2);
		assertEquals(cc1.hashCode(),cc2.hashCode());
		CjmContext cc3 = new CjmContext("base");
		assertEquals(cc3,cc2.getParentContext());
		assertEquals(cc3,cc1.getParentContext());
		assertEquals(cc3.hashCode(),cc1.getParentContext().hashCode());
		CjmContext base = new CjmContext(new CjmContext(""),new CjmContext(""));
		assertEquals(base,new CjmContext());
		assertEquals(base.hashCode(),new CjmContext().hashCode());
		System.out.println("base = " + base + " parent = " + base.getParentContext() + " reverseIndex = " + base.reverseIndex);
		assertNull(base.getParentContext());
	}

	@Test
	public void testSubContext() throws Exception {
		BasicContextOriented co2 = new BasicContextOriented(
				new CjmContext("config2"));
		BasicContextOriented co1 = new BasicContextOriented();
		assertEquals("Root Value",co1.getRedirectedService().getMainValue());
		assertEquals("config2 Value",co2.getRedirectedService().getMainValue());	
		assertEquals("path1", co2.getPaths()[0]);
		BasicContextOriented co3 = new BasicContextOriented(
				new CjmContext("override"));
		assertEquals("path3", co3.getPaths()[0]);
		assertEquals("path4", co3.getPaths()[1]);
		BasicContextOriented co4 = co3.getSubObject();
		assertEquals("path3", co4.getPaths()[0]);
		assertEquals("path4", co4.getPaths()[1]);
		co4 = co3.getSubObject(co1);
		assertEquals("path1", co4.getPaths()[0]);
	}

	@Test
	public void testSmartSubContext() throws Exception {
		BasicContextOriented co1 = new BasicContextOriented(
				new CjmContext("units/elf"));
		assertEquals("elf_path1", co1.getPaths()[0]);
		BasicContextOriented co2 = new BasicContextOriented(
				new CjmContext("custom"));
		BasicContextOriented co3 = co2.getSubObject("units/elf");
		assertEquals("custom/units/elf", co3.getPaths()[0]);
	}

	@Test
	public void testSingletonContextualize() throws Exception
	{
		BasicContextOriented co = new BasicContextOriented();
		BasicContextOriented co2 = new BasicContextOriented(new CjmContext("units/elf"));
		SimpleContextOrientedB b = new SimpleContextOrientedB(new CjmContext("units/orc"));
		assertEquals(co.getMyService(),co2.getMyService());
		assertEquals(co.getMyService(),b.getService());
		assertEquals(new CjmContext(""),((ContextOriented)co2.getMyService()).getCoinjemaContext());
	}

	@Test
	public void testParallelSingletonContextualize() throws Exception
	{
		BasicContextOriented co2 = new BasicContextOriented(new CjmContext("units/elf"));
		BasicContextOriented b = new BasicContextOriented(new CjmContext("units/orc"));
		assertEquals(co2.getMyService(),b.getMyService());
		assertEquals(new CjmContext(""),((ContextOriented)co2.getMyService()).getCoinjemaContext());
	}

	@Test
	public void testSubContextFind() throws Exception {
		BasicContextOriented elf = new BasicContextOriented(
				new CjmContext("units/elf"));
		BasicContextOriented orc = elf.getSubObject("orc");
		assertEquals("orc_path2", orc.getPaths()[1]);
	}

	@Test
	public void testTooDeepContextFind() throws Exception
	{
		BasicContextOriented elf = new BasicContextOriented(
				new CjmContext("units/elf/empty.txt"));
		BasicContextOriented orc = elf.getSubObject("orc");
		assertEquals("orc_path2", orc.getPaths()[1]);
	}

	@Test
	public void testAnnotatedSingleton() throws Exception {
		BasicContextOriented co1 = new BasicContextOriented();
		assertEquals("Root Value", co1.getMyMainValue());
		assertEquals("Other Root", co1.getMyOtherMainValue());
	}

	@Test
	public void testLastDependency() throws Exception {
		BasicContextOriented co1 = new BasicContextOriented();
	}

	@Test
	public void testLoggingSetup() throws Exception {
		BasicContextOriented co1 = new BasicContextOriented();
		PerformanceTestObject pto = new PerformanceTestObject();
		assertTrue(co1.getLog() != null);
		assertTrue(pto.getLog() != null);
		assertNotSame(co1.getLog(),pto.getLog());
		co1.testLogging();
		co1 = new BasicContextOriented(new CjmContext("config2"));
		co1.testLogging();
		pto.getLog().info("My Other Logger works great too!");
	}

	@Test
	public void testHashCodePerformance() throws Exception {
		CjmContext context = new CjmContext("config2/units/elf");
		int i = 0;
		int hash = 0;
		long time = System.nanoTime();
		while (i++ < 1000) {
			hash = context.hashCode();
		}
		System.out.println("hashcode for " + context
				+ " = hash, 1000 iterations took " + (System.nanoTime() - time)
				+ " nanoseconds");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		i = 0;
		time = System.nanoTime();
		while (i++ < 1000000) {
			hash = context.hashCode();
		}
		System.out.println("hashcode for " + context
				+ " = hash, 1,000,000 iterations took "
				+ (System.nanoTime() - time) + " nanoseconds");
	}

	@Test
	public void testContextCreationPerformance() throws Exception {
		CjmContext context = null;
		int i = 0;
		long hashSum = 0;
		long time = 0;
		while (i++ < 1000) {
			context = new CjmContext();
			hashSum += context.hashCode();
			context = new CjmContext("config2/units/elf");
			hashSum += context.hashCode();
			context = new CjmContext("custom");
			hashSum += context.hashCode();
		}
		i = 0;
		time = System.nanoTime();
		while (i++ < 1000000) {
			context = new CjmContext();
			hashSum += context.hashCode();
			context = new CjmContext("config2/units/elf");
			hashSum += context.hashCode();
			context = new CjmContext("custom");
			hashSum += context.hashCode();
		}
		System.out.println("Making 3 million contexts and hashing took: "
				+ ((System.nanoTime() - time)/1000000) + " milliseconds");
		System.out.println("Total hashcode = " + hashSum);
	}

	@Test
	public void testContextCreation() throws Exception
	{
		CjmContext c = new CjmContext("/test");
		assertEquals("test/",c.getName());
	}

	@Test
	public void testProperty() throws Exception {
		BasicContextOriented co = new BasicContextOriented(new CjmContext(
				"units"));
		assertEquals("doobie", co.getProp("mysmoke"));
	}

	@Test
	public void testContextConstructors() throws Exception
	{
		BasicContextOriented co = new BasicContextOriented("newTest",new CjmContext("units"));
		assertEquals("newTest",co.getInit());
		assertEquals("doobie",co.getProp("mysmoke"));
	}

	@Test
	public void testNested() throws Exception
	{
		BasicContextOriented co = new BasicContextOriented(new CjmContext("custom"));
		assertEquals("A Test String",co.getSimple().getCircular().getTest());
		assertEquals("test string",co.getSimple().getTest());
		assertEquals(co.getMyService(),co.getSimple().getCircular().getCircular().getCircular().getService());
	}
}
