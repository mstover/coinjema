package org.coinjema.context;

import java.io.File;

import org.coinjema.nontest.AdvancedContextObject;
import org.coinjema.nontest.PersistentConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSerializedObject extends AbstractContextTester {


    /* (non-Javadoc)
     * @see org.coinjema.context.AbstractContextTester#setUp()
     */
    @BeforeEach
    @Override
    public void setUp() throws Exception {
        super.setUp();
        File per = new File("test/config1/sessionStore.jser");
        if(!per.exists())
        {
            PersistentConfig.create();
        }
    }
    
    @Test
    public void testFileExists() throws Exception
    {
        File per = new File("src/test/resources/config1/sessionStore.jser");
        assertTrue(per.exists());
    }

    @Test
    public void testDeserializedDependency() throws Exception
    {
        AdvancedContextObject aco = new AdvancedContextObject();
        assertEquals("One",aco.getSession().getParamOne());
        assertNotNull(aco.getSession().getMok());
        aco.getSession().getMok().setMainValue("MainValue");
        aco = new AdvancedContextObject();
        assertEquals("MainValue",aco.getSession().getMok().getMainValue());
    }

}
