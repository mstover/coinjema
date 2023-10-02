package org.coinjema.context;

import org.coinjema.nontest.UnAnnotated;
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
