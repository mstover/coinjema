/*
 * Created on Aug 31, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.coinjema.testing.util;

import org.coinjema.testing.nontest.BasicObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author mstover
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class NormalConstructionTest
{

    @Test
    public void testNormalConstruction() throws Exception
   {
      for(int i = 0;i < 1000;i++)
      {
	      assertEquals(BasicObject.class, new BasicObject().getClass());
	      BasicObject period = new BasicObject();
	      period.setPaths(new String[]{"path1","path2"});
	      assertEquals(BasicObject.class,period.getClass());
	      assertEquals("path2",period.getPaths()[1]);
	      period = new BasicObject();
	      period.setPaths(new String[]{"path1","path2"});
	      assertEquals(BasicObject.class,period.getClass());
	      assertEquals("path1",period.getPaths()[0]);
      }
   }
}
