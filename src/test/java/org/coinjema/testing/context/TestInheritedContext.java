package org.coinjema.testing.context;

import org.coinjema.testing.nontest.SubContextOriented;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInheritedContext extends AbstractContextTester {


    @Test
    public void testInjectionCount() throws Exception {
        SubContextOriented counter = new SubContextOriented();

        assertEquals(new URL("http://coinjema.sourceforge.net/"), counter.getHome());
        assertEquals("wrong_path1", counter.getPaths()[0]);
    }
}
