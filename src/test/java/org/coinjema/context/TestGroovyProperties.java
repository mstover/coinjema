package org.coinjema.context;

import org.coinjema.nontest.HasGroovyProperties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGroovyProperties extends AbstractContextTester {


    @Test
    public void testGroovyProperties() throws Exception {
        HasGroovyProperties obj = new HasGroovyProperties();
        assertEquals("org.coinjema.nontest.HasGroovyProperties", obj.getProperty("this.class"));
    }

}
