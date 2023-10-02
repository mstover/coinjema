package org.coinjema.context;

import org.coinjema.nontest.InheritingObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInheritable extends AbstractContextTester {


    @Test
    public void testInheritableProperties() throws Exception {
        InheritingObject io = new InheritingObject();
        assertEquals("value_1", io.getProps().getProperty("prop_1"));
        assertEquals(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test", io.getProps().getProperty(
                "prop_2"));
        io = new InheritingObject(new CjmContext("config2"));
        assertEquals("value_1", io.getProps().getProperty("prop_1"));
        assertEquals("value_2.1", io.getProps().getProperty("prop_2"));
        assertEquals("value_3", io.getProps().getProperty("prop_3"));
        io = new InheritingObject(new CjmContext("config2/config3"));
        assertEquals("value_1", io.getProps().getProperty("prop_1"));
        assertEquals("value_2.1", io.getProps().getProperty("prop_2"));
        assertEquals("value_3.2", io.getProps().getProperty("prop_3"));
        assertEquals("value_4", io.getProps().getProperty("prop_4"));
        io = new InheritingObject(new CjmContext("custom"));
        assertEquals("value_1", io.getProps().getProperty("prop_1"));
        assertEquals(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test", io.getProps().getProperty(
                "prop_2"));
        io = new InheritingObject(new CjmContext(
                "config2/config3/config4/config5"));
        assertEquals("value_1", io.getProps().getProperty("prop_1"));
        assertEquals("value_2.1", io.getProps().getProperty("prop_2"));
        assertEquals("value_5", io.getProps().getProperty("prop_5"));

    }

    @Test
    public void testInheritableProperties2() throws Exception {
        InheritingObject io = new InheritingObject(new CjmContext(
                "config2/config3/config4/config5"));
        assertEquals("value_1", io.getProps().getProperty("prop_1"));
        assertEquals("value_2.1", io.getProps().getProperty("prop_2"));
        assertEquals("value_5", io.getProps().getProperty("prop_5"));

    }

}
