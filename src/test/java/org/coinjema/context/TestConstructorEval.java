package org.coinjema.context;

import org.coinjema.context.source.FileContextSource;
import org.coinjema.nontest.ServiceOne;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConstructorEval {

    @BeforeEach
    public void setUp() throws Exception {
        ContextFactory.createRootContext(new FileContextSource("src/test/resources/config1"));
    }

    @AfterEach
    protected void tearDown() throws Exception {
        ContextFactory.destroyContext(null);
    }

    @Test
    public void simpleConstruction() throws MalformedURLException {
        ServiceOne service = (ServiceOne) Cjm.getDep("ServiceOne");
        assertEquals("config1-abcd", service.getConfigName());
        assertEquals(URI.create("https://www.google.com").toURL(), service.getHost());
        assertEquals("gPepper", service.getConfiguration().getProperty("username"));
    }
}
