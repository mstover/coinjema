/*
 * Created on Feb 8, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.coinjema.collections;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Properties;

import junit.framework.TestCase;

/**
 * @author mike
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class TestConfigurationTree extends TestCase {
    ConfigurationTree config;

    /**
     * @param name
     */
    public TestConfigurationTree(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        config = new ConfigurationTree("coinjemaConfig");
        config.add("param1/value1");
        config.add("param2/value2");
        config.add("param3/value3");
        config.add("group1/param6/value6");
        config.add("group1/param7/value7");
        config.add("group1/param8/value8");
        config.add("param4/value4");
        config.add("group2/param9/value9");
        config.add("group2/param10/value10");
        config.add("school/announcement",
                "This is a special announcement.\nToday is Thursday.");
        config.add("school/announcement/date", "Thursday");
        config.setProperty("school/announcement/title", "Way\n\tto\n\t\tgo");
        config.add("school/subjects/", new String[] { "art", "science", "math",
                "english" });
        config.setValue("group1", "Coinjema Developers");
    }

    public void testToString() throws Exception {
        assertEquals("Coinjema Developers", config.getValue("group1"));
        config.setProperty("website/url", "http://mydomain.com/homepage.jsp");
        String props = config.toString();
        PrintWriter tf = new PrintWriter(new FileWriter("test/testfiles/configurationTest.xml"));
        tf.write(config.toString());
        tf.close();
        ConfigurationTree newTree = new ConfigurationTree(new FileReader(
                "test/testfiles/configurationTest.xml"));
        assertEquals("Coinjema Developers", newTree.getValue("group1"));
        assertEquals(props, newTree.toString());
        assertEquals("math", config.getPropertyNames("school/subjects")[2]);
        assertEquals("math", newTree.getPropertyNames("school/subjects")[2]);
        assertEquals("http://mydomain.com/homepage.jsp", config
                .remove("website/url"));
    }

    public void testManipulation1() throws Exception {
        config.put("db/driver", "oracle.jdbc.driver.OracleDriver");
        assertEquals("oracle.jdbc.driver.OracleDriver", config
                .getProperty("db/driver"));
        config.add("db/url/my db's url");
        assertEquals("my db's url", config.getProperty("db/url"));
        config.setProperty("website/url", "http://mydomain.com/homepage.jsp");
        assertEquals("http://mydomain.com/homepage.jsp", config
                .getProperty("website/url"));
        config.replace("db/driver", "resin_db/resin_driver");
        assertEquals("oracle.jdbc.driver.OracleDriver", config
                .getProperty("resin_db/resin_driver"));
        assertEquals("my db's url", config.getProperty("resin_db/url"));
        config.remove("resin_db/resin_driver");
        assertNull(config.getProperty("resin_db/resin_driver"));
    }
    
    public void testMultipleTopLevelLoad() throws Exception
    {
        ConfigurationTree tree = new ConfigurationTree(new FileReader("test/testfiles/multiTopLevel.cfg"));
        assertEquals("true",tree.getProperty("firstKey"));
        assertEquals("false",tree.getProperty("secondKey"));
    }
    
    public void testAsProperties() throws Exception
    {
        Properties props = config.getAsProperties();
        assertEquals("value4",props.getProperty("param4"));
    }
    
    public void testAddProps() throws Exception
    {
        Properties props = new Properties();
        props.setProperty("name","Mike");
        props.setProperty("pets","dog");
        config.add(props);
        assertEquals("dog",config.getProperty("pets"));
    }
    
    public void testDefault() throws Exception
    {
        assertEquals("default",config.getProperty("notThere","default"));
    }
}
