/*
 * Created on Aug 29, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.coinjema.testing.util;

import java.util.HashMap;
import java.util.Map;

import org.coinjema.testing.nontest.BasicObject;
import org.coinjema.cjm.util.ConstructorFunctor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author mstover
 * 
 * To change the template for this generated type comment go to Window - Preferences - Java - Code Generation - Code and
 * Comments
 */
public class ConstructorFunctorTest
{

    @Test
    public void testConstruction1() throws Exception
   {
      for(int i = 0;i < 1000;i++)
      {
	      ConstructorFunctor<BasicObject> f = new ConstructorFunctor<BasicObject>(BasicObject.class);
	      assertEquals(BasicObject.class, f.invoke().getClass());
	      ConstructorFunctor<BasicObject> tp = new ConstructorFunctor<BasicObject>(BasicObject.class, String[].class);
	      BasicObject period = tp.invokeWith((Object)new String[]{"path1","path2"});
	      assertEquals(BasicObject.class,period.getClass());
	      assertEquals("path1",period.getPaths()[0]);
	      ConstructorFunctor<BasicObject> tp2 = new ConstructorFunctor<BasicObject>(BasicObject.class);
	      period = tp2.invokeWith((Object)new String[]{"path1","path2"});
	      assertEquals(BasicObject.class,period.getClass());
	      assertEquals("path1",period.getPaths()[0]);
	      period = tp2.invokeWith((Object)new String[]{"path1","path2"});
	      assertEquals(BasicObject.class,period.getClass());
	      assertEquals("path2",period.getPaths()[1]);
      }
   }
   
   public void testConstruction2() throws Exception
   {
      ConstructorFunctor<Map> f = new ConstructorFunctor<Map>(HashMap.class);
      assertEquals(HashMap.class,f.invoke().getClass());
      Map m = f.invoke();
      assertNotNull(m);
   }
}