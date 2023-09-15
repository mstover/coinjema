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
		CoinjemaContext cc1 = new CoinjemaContext("base/sub");
		CoinjemaContext cc2 = new CoinjemaContext(new CoinjemaContext("base"),new CoinjemaContext("sub"));
		assertEquals(cc1,cc2);
		assertEquals(cc1.hashCode(),cc2.hashCode());
		CoinjemaContext cc3 = new CoinjemaContext("base");
		assertEquals(cc3,cc2.getParentContext());
		assertEquals(cc3,cc1.getParentContext());
		assertEquals(cc3.hashCode(),cc1.getParentContext().hashCode());
		CoinjemaContext base = new CoinjemaContext(new CoinjemaContext(""),new CoinjemaContext(""));
		assertEquals(base,new CoinjemaContext());
		assertEquals(base.hashCode(),new CoinjemaContext().hashCode());
		System.out.println("base = " + base + " parent = " + base.getParentContext() + " reverseIndex = " + base.reverseIndex);
		assertNull(base.getParentContext());
	}

	@Test
	public void testSubContext() throws Exception {
		BasicContextOriented co2 = new BasicContextOriented(
				new CoinjemaContext("config2"));
		BasicContextOriented co1 = new BasicContextOriented();
		assertEquals("Root Value",co1.getRedirectedService().getMainValue());
		assertEquals("config2 Value",co2.getRedirectedService().getMainValue());	
		assertEquals("path1", co2.getPaths()[0]);
		BasicContextOriented co3 = new BasicContextOriented(
				new CoinjemaContext("override"));
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
				new CoinjemaContext("units/elf"));
		assertEquals("elf_path1", co1.getPaths()[0]);
		BasicContextOriented co2 = new BasicContextOriented(
				new CoinjemaContext("custom"));
		BasicContextOriented co3 = co2.getSubObject("units/elf");
		assertEquals("custom/units/elf", co3.getPaths()[0]);
	}

	@Test
	public void testSingletonContextualize() throws Exception
	{
		BasicContextOriented co = new BasicContextOriented();
		BasicContextOriented co2 = new BasicContextOriented(new CoinjemaContext("units/elf"));
		SimpleContextOrientedB b = new SimpleContextOrientedB(new CoinjemaContext("units/orc"));
		assertEquals(co.getMyService(),co2.getMyService());
		assertEquals(co.getMyService(),b.getService());
		assertEquals(new CoinjemaContext(""),((ContextOriented)co2.getMyService()).getCoinjemaContext());
	}

	@Test
	public void testParallelSingletonContextualize() throws Exception
	{
		BasicContextOriented co2 = new BasicContextOriented(new CoinjemaContext("units/elf"));
		BasicContextOriented b = new BasicContextOriented(new CoinjemaContext("units/orc"));
		assertEquals(co2.getMyService(),b.getMyService());
		assertEquals(new CoinjemaContext(""),((ContextOriented)co2.getMyService()).getCoinjemaContext());
	}

	@Test
	public void testSubContextFind() throws Exception {
		BasicContextOriented elf = new BasicContextOriented(
				new CoinjemaContext("units/elf"));
		BasicContextOriented orc = elf.getSubObject("orc");
		assertEquals("orc_path2", orc.getPaths()[1]);
	}

	@Test
	public void testTooDeepContextFind() throws Exception
	{
		BasicContextOriented elf = new BasicContextOriented(
				new CoinjemaContext("units/elf/empty.txt"));
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
		co1 = new BasicContextOriented(new CoinjemaContext("config2"));
		co1.testLogging();
		pto.getLog().info("My Other Logger works great too!");
	}

	@Test
	public void testHashCodePerformance() throws Exception {
		CoinjemaContext context = new CoinjemaContext("config2/units/elf");
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
		CoinjemaContext context = null;
		int i = 0;
		long hashSum = 0;
		long time = 0;
		while (i++ < 1000) {
			context = new CoinjemaContext();
			hashSum += context.hashCode();
			context = new CoinjemaContext("config2/units/elf");
			hashSum += context.hashCode();
			context = new CoinjemaContext("custom");
			hashSum += context.hashCode();
		}
		i = 0;
		time = System.nanoTime();
		while (i++ < 1000000) {
			context = new CoinjemaContext();
			hashSum += context.hashCode();
			context = new CoinjemaContext("config2/units/elf");
			hashSum += context.hashCode();
			context = new CoinjemaContext("custom");
			hashSum += context.hashCode();
		}
		System.out.println("Making 3 million contexts and hashing took: "
				+ ((System.nanoTime() - time)/1000000) + " milliseconds");
		System.out.println("Total hashcode = " + hashSum);
	}

	@Test
	public void testContextCreation() throws Exception
	{
		CoinjemaContext c = new CoinjemaContext("/test");
		assertEquals("test/",c.getName());
	}

	@Test
	public void testProperty() throws Exception {
		BasicContextOriented co = new BasicContextOriented(new CoinjemaContext(
				"units"));
		assertEquals("doobie", co.getProp("mysmoke"));
	}

	@Test
	public void testContextConstructors() throws Exception
	{
		BasicContextOriented co = new BasicContextOriented("newTest",new CoinjemaContext("units"));
		assertEquals("newTest",co.getInit());
		assertEquals("doobie",co.getProp("mysmoke"));
	}

	@Test
	public void testNested() throws Exception
	{
		BasicContextOriented co = new BasicContextOriented(new CoinjemaContext("custom"));
		assertEquals("A Test String",co.getSimple().getCircular().getTest());
		assertEquals("test string",co.getSimple().getTest());
		assertEquals(co.getMyService(),co.getSimple().getCircular().getCircular().getCircular().getService());
	}
}
