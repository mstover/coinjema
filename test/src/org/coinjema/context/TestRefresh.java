package org.coinjema.context;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;

import org.coinjema.nontest.BasicContextOriented;
import org.coinjema.nontest.MockSingleton;

public class TestRefresh extends AbstractContextTester {

	public TestRefresh() {
		super();
	}

	public TestRefresh(String arg0) {
		super(arg0);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		PrintWriter file = new PrintWriter(new FileWriter(
				"test/config1/homeURL.groovy"));
		file.write("new java.net.URL(\"http://coinjema.sourceforge.net/\")");
		file.close();
		file = new PrintWriter(new FileWriter("test/config1/mockName.txt"));
		file.write("Hello");
		file.close();
	}

	public void testBasicRefresh() throws Exception {
		System.out.println("Current weak size = "
				+ SpiceRack.contextObjects.map.size());
		BasicContextOriented co = new BasicContextOriented();
		assertEquals(new URL("http://coinjema.sourceforge.net/"), co.getHome());
		PrintWriter file = new PrintWriter(new FileWriter(
				"test/config1/homeURL.groovy"));
		file
				.write("new java.net.URL(\"http://coinjema.sourceforge.net/overview.html\")");
		file.close();
		ContextFactory.refresh(new CoinjemaContext());
		co = new BasicContextOriented();
		assertEquals(new URL("http://coinjema.sourceforge.net/overview.html"),
				co.getHome());
	}

	public void testSharedRefresh() throws Exception {
		BasicContextOriented co = new BasicContextOriented();
		System.out.println(co);
		assertEquals("Hello", co.getMyService().getMockName());
		MockSingleton ms = co.getMyService();
		assertEquals("Hello", ms.getMockName());
		System.out.println(ms);
		PrintWriter file = new PrintWriter(new FileWriter(
				"test/config1/mockName.txt"));
		file.write("Goodbye");
		file.close();
		ContextFactory.refresh(new CoinjemaContext());
		assertEquals("Goodbye", co.getMyService().getMockName());
		assertEquals("Goodbye", ms.getMockName());
		file = new PrintWriter(new FileWriter("test/config1/mockName.txt"));
		file.write("Au Revoir");
		file.close();
		ContextFactory.refresh(new CoinjemaContext());
		assertEquals("Au Revoir", co.getMyService().getMockName());
		assertEquals("Au Revoir", ms.getMockName());
	}

}
