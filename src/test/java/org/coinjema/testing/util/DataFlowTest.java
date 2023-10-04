/*
 * Created on Jan 16, 2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.coinjema.testing.util;

import org.coinjema.cjm.util.DataFlowCell;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.Enumeration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author mstover
 * <p>
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class DataFlowTest {

    @Test
    public void testDataFlow() throws Exception {
        try {
            final DataFlowCell cell1 = new DataFlowCell();
            final StringBuffer buf = new StringBuffer("1");
            Thread thread1 = new Thread() {
                public void run() {
                    buf.append(cell1.get());
                }
            };
            thread1.start();
            try {
                Thread.sleep((long) (new Random().nextFloat() * 2000));
            } catch (Exception e) {
            }
            buf.append("2");
            cell1.set("3");
            Thread.sleep(500);
            assertEquals("123", buf.toString());
        } catch (Exception e) {
            System.out.println("hey, error " + e);
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test public void testClassLoader() throws Exception {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("org/aspectj"));
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("");
        while (urls.hasMoreElements()) {
            URL u = urls.nextElement();
            System.out.println(u);
        }
    }
}
