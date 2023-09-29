package org.coinjema.constructor;

import org.coinjema.context.ContextFactory;
import org.coinjema.context.ContextOriented;
import org.coinjema.context.source.FileContextSource;
import org.coinjema.nontest.noaspect.AdvancedContextObject;
import org.coinjema.nontest.noaspect.AjdtFreeConstructorOriented;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AjdtFreeConstructorTests {


    @BeforeEach
    public void setUp() throws Exception {
        ContextFactory.createRootContext(new FileContextSource("src/test/resources/config1"));
    }

    @AfterEach
    protected void tearDown() throws Exception {
        ContextFactory.destroyContext(null);
    }

    @Test
    public void testSelfCreate() throws Exception {

        AjdtFreeConstructorOriented obj = new AjdtFreeConstructorOriented();
        assertEquals("Root Value", obj.getService().getMainValue());
        assertEquals("Hello", obj.getService().getMockName());
        assertEquals("gary Oldman", obj.getUsername());
        assertNotNull(obj.getLogger());
    }

    @Test
    public void testObjectNaming() {
        AdvancedContextObject service = new AdvancedContextObject();
        assertEquals("coinjema", service.getProperty("projectName"));
    }

    @Test
    public void testDynamicContextualization() throws Exception
    {
        AdvancedContextObject aco = new AdvancedContextObject("override");
        assertEquals("override/",((ContextOriented)aco).getCoinjemaContext().getName());
    }
}
