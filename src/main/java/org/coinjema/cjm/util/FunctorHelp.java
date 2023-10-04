/*
 * Created on Aug 29, 2004
 *
 * This file is from the Coinjema project on sourceforge.net (http://coinjema.sourceforge.net)
 * This file is Public Domain software.
 */
package org.coinjema.cjm.util;

import java.lang.reflect.Method;



/**
 * @author mstover
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
class FunctorHelp
{

   public static Class[] setupTypes(Class[] types,Object[] args)
   {
      if(types == null) // do only once per functor instance. Could
      // cause errors if functor used for multiple
      // same-named-different-parametered methods.
      {
         if(args != null)
         {
            types = new Class[args.length];
            for(int i = 0;i < args.length;i++)
            {
               types[i] = args[i].getClass();
            }
         }
         else
         {
            types = new Class[0];
         }
      }
      return types;
   }
   
   /**
    * Given a functor that can generate the correct kind of reflection object given a defined
    * set of classes
    * @param types
    * @param f
    * @return
    */
   public static <R> Method getInvokable(Object invokee,Class[] types, Functor<Method> f)
   {
      Method invokable;
      for(int i = 0;i < types.length;i++)
      {
         Class[] interfaces = types[i].getInterfaces();
         for(int j = 0;j < interfaces.length;j++)
         {
            invokable = f.invokeWith(new Object[]{invokee,getNewArray(i, interfaces[j], types)});
            if(invokable != null)
            {
               return invokable;
            }
         }
         Class primitive = getPrimitive(types[i]);
         if (primitive != null) {
             invokable = f.invokeWith(new Object[]{invokee,getNewArray(i, primitive,
                     types)});
             if (invokable != null) {
                 return invokable;
             }
         }
         Class parent = types[i].getSuperclass();
         if(parent != null)
         {
	         invokable = f.invokeWith(new Object[]{invokee,getNewArray(i, parent, types)});
	         if(invokable != null)
	         {
	            return invokable;
	         }
         }
      }
      return null;
   }
   
   static public Class getPrimitive(Class clazz) {
      if (clazz.equals(Boolean.class))
          return boolean.class;
      else if (clazz.equals(Integer.class))
          return int.class;
      else if (clazz.equals(Long.class))
          return long.class;
      else if (clazz.equals(Character.class))
          return char.class;
      else if (clazz.equals(Short.class))
          return short.class;
      else if (clazz.equals(Byte.class))
          return byte.class;
      else if (clazz.equals(Float.class))
          return float.class;
      else if (clazz.equals(Double.class))
          return double.class;
      else
          return null;
  }
   
   protected static Class[] getNewArray(int i, Class replacement, Class[] orig)
   {
      Class[] newArray = new Class[orig.length];
      for(int j = 0;j < newArray.length;j++)
      {
         newArray[j] = orig[j];
         if(j == i)
         {
            newArray[j] = replacement;
         }
      }
      return newArray;
   }
}
