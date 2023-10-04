package org.coinjema.testing.context;

import org.coinjema.cjm.Cjm;
import org.coinjema.testing.nontest.UnAnnotated;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnAnnotated extends AbstractContextTester {


    @Test
    public void testUnAnnotated() throws Exception {
        UnAnnotated ua = new UnAnnotated((String) Cjm.getDep("UnAnnotated.setName"));
        assertEquals("I'm UnAnnotated", ua.getName());
        assertEquals("Has Default", ua.getValue());
    }

}
