package org.coinjema.constructor;

import org.coinjema.context.ContextFactory;
import org.coinjema.context.source.FileContextSource;
import org.coinjema.nontest.SimpleConstructorOriented;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructorContextTests {
    @BeforeEach
    public void setUp() throws Exception {
        ContextFactory.createRootContext(new FileContextSource("src/test/resources/config1"));
    }
    @Test
    public void simpleConstructor() {
        SimpleConstructorOriented obj  = new SimpleConstructorOriented(null,null);
        assertEquals("GaryOldman",obj.getUsername());
    }
}
