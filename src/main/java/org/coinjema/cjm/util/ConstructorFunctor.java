/*
 * Created on Aug 29, 2004
 *
 * This file is from the Coinjema project on sourceforge.net (http://coinjema.sourceforge.net)
 * This file is Public Domain software.
 */
package org.coinjema.cjm.util;

import java.lang.reflect.Constructor;


/**
 * A functor that represents a constructor.
 * @author mstover
 * 
 */
public class ConstructorFunctor<T> implements InvokableWith<T>,Invokable<T>
{
   Class<? extends T> clazz;
   Class<?>[] types;
   Object[] args;
   Constructor constructorToInvoke;
   
   /**
    * 
    * @param clazz
    */
   public ConstructorFunctor(Class<? extends T> clazz)
   {
      this.clazz = clazz;
   }

   /**
    * 
    * @param clazz
    * @param types
    */
   public ConstructorFunctor(Class<? extends T> clazz, Class<?> ... types)
   {
      this.clazz = clazz;
      this.types = types;
   }
   
   /**
    * 
    * @param clazz
    * @param types
    * @param args
    */
   public ConstructorFunctor(Class<? extends T> clazz,Class<?>[] types,Object[] args)
   {
      this.clazz = clazz;
      this.types = types;
      this.args = args;
   }
   
   /**
    * 
    * @return
    */
   public T invoke()
   {
      if(args == null)
      {
         args = new Object[0];
      }
      types = FunctorHelp.setupTypes(types,args);
      try
      {
         Constructor<? extends T> c = createConstructor(types);
         types = c.getParameterTypes();
         return c.newInstance(args);
      }
      catch(Exception e)
      {
         throw new RuntimeException(e);
      }
   }
   
   /**
    * 
    * @param args
    * @return
    */
   public T invokeWith(Object ... args)
   {
      this.args = args;
      return invoke();
   }
   
   /**
    * 
    * @param types
    * @return
    * @throws Exception
    */
   public Constructor<? extends T> createConstructor(Class<?>[] types) throws Exception
   {
      for(Constructor c : clazz.getConstructors())
      {
         boolean isRight = false;
         Class<?>[] params = c.getParameterTypes();
         if(params.length == types.length)
         {
            isRight = true;
            for(int i = 0; i < params.length; i++)
            {
               Class primitive = FunctorHelp.getPrimitive(types[i]);
               if(!params[i].isAssignableFrom(types[i]) && 
                     (primitive == null || !params[i].isAssignableFrom(primitive)))
               {
                  isRight = false;
                  break;
               }
            }
         }
         if(isRight)
         {
            return c;
         }
      }
      throw new Exception("No Such Constructor");
	}   
}
