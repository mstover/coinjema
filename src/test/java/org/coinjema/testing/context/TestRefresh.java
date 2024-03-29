package org.coinjema.testing.context;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.ContextFactory;
import org.coinjema.testing.nontest.BasicContextOriented;
import org.coinjema.testing.nontest.MockSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRefresh extends AbstractContextTester {


    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        PrintWriter file = new PrintWriter(new FileWriter(
                "src/test/resources/config1/homeURL.groovy"));
        file.write("new java.net.URL(\"http://coinjema.sourceforge.net/\")");
        file.close();
        file = new PrintWriter(new FileWriter("src/test/resources/config1/mockName.txt"));
        file.write("Hello");
        file.close();
    }

    @Test
    public void testBasicRefresh() throws Exception {
        System.out.println("Current weak size = "
                + ContextFactory.getContextObjectCount());
        BasicContextOriented co = new BasicContextOriented();
        assertEquals(new URL("http://coinjema.sourceforge.net/"), co.getHome());
        PrintWriter file = new PrintWriter(new FileWriter(
                "src/test/resources/config1/homeURL.groovy"));
        file
                .write("new java.net.URL(\"http://coinjema.sourceforge.net/overview.html\")");
        file.close();
        ContextFactory.refresh(new CjmContext());
        co = new BasicContextOriented();
        assertEquals(new URL("http://coinjema.sourceforge.net/overview.html"),
                co.getHome());
    }

    @Test
    public void testSharedRefresh() throws Exception {
        BasicContextOriented co = new BasicContextOriented();
        System.out.println(co);
        assertEquals("Hello", co.getMyService().getMockName());
        MockSingleton ms = co.getMyService();
        assertEquals("Hello", ms.getMockName());
        System.out.println(ms);
        PrintWriter file = new PrintWriter(new FileWriter(
                "src/test/resources/config1/mockName.txt"));
        file.write("Goodbye");
        file.close();
        ContextFactory.refresh(new CjmContext());
        assertEquals("Goodbye", co.getMyService().getMockName());
        assertEquals("Goodbye", ms.getMockName());
        file = new PrintWriter(new FileWriter("src/test/resources/config1/mockName.txt"));
        file.write("Au Revoir");
        file.close();
        ContextFactory.refresh(new CjmContext());
        assertEquals("Au Revoir", co.getMyService().getMockName());
        assertEquals("Au Revoir", ms.getMockName());
    }

}
