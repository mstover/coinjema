package org.coinjema.testing.context;

import org.coinjema.testing.nontest.HasGroovyProperties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGroovyProperties extends AbstractContextTester {


    @Test
    public void testGroovyProperties() throws Exception {
        HasGroovyProperties obj = new HasGroovyProperties();
        assertEquals("org.coinjema.testing.nontest.HasGroovyProperties", obj.getProperty("this.class"));
    }

}
