package org.coinjema.testing.constructor;

import org.coinjema.cjm.ContextFactory;
import org.coinjema.cjm.source.FileContextSource;
import org.coinjema.testing.nontest.SimpleConstructorOriented;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructorContextTests {
    @BeforeEach
    public void setUp() throws Exception {
        ContextFactory.createRootContext(new FileContextSource("src/test/resources/config1"));
    }

    @AfterEach
    protected void tearDown() throws Exception {
        ContextFactory.destroyContext(null);
    }

    @Test
    public void simpleConstructor() {
        SimpleConstructorOriented obj = new SimpleConstructorOriented();
        assertEquals("gary Oldman", obj.getUsername());
        assertEquals("Root Value", obj.getService().getMainValue());
        assertEquals("Hello", obj.getService().getMockName());
    }
}
