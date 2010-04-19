package org.coinjema.context;

import java.io.File;

import org.coinjema.nontest.AdvancedContextObject;
import org.coinjema.nontest.PersistentConfig;

public class TestSerializedObject extends AbstractContextTester {

    public TestSerializedObject() {
        super();
    }

    public TestSerializedObject(String arg0) {
        super(arg0);
    }

    /* (non-Javadoc)
     * @see org.coinjema.context.AbstractContextTester#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        File per = new File("test/config1/sessionStore.jser");
        if(!per.exists())
        {
            PersistentConfig.create();
        }
    }
    
    public void testFileExists() throws Exception
    {
        File per = new File("test/config1/sessionStore.jser");
        assertTrue(per.exists());
    }
    
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
