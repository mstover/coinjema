/*
 * Created on Mar 13, 2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.coinjema.context;

import static org.coinjema.logging.CoinjemaLogger.log;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.reflect.Constructor;
import org.aspectj.lang.reflect.ConstructorSignature;

import org.coinjema.logging.CoinjemaLogger;

public aspect ConstructorContextBuilder {

	pointcut objectInit():
      call(ConstructorContextOriented+.new(..));

	pointcut objectInitWithContext(CoinjemaContext context):
        call(ConstructorContextOriented+.new(..,CoinjemaContext)) && args(..,context);


	Object around():
      objectInit() && !objectInitWithContext(CoinjemaContext)
    {
        LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
        Object[] givenArgs = thisJoinPoint.getArgs();
        Class called = ((ConstructorSignature)thisJoinPoint.getStaticPart().getSignature()).getConstructor().getDeclaringClass();
        //called.setGiven(false);
        if (stack.isEmpty())
        {
            if(log.isLoggable(Level.FINE)) log.fine("Contextualizing " + called + " in context ''");
            return Recipe.constructContextualized(called,givenArgs, null, null);
        }
        else
        {
            if(log.isLoggable(Level.FINE)) log.fine("Contextualizing " + called + " in context '" + stack.getFirst() + "'");
            return Recipe.constructContextualized(called, givenArgs, null, stack.getFirst());
        }
	}

	Object around(CoinjemaContext context):
          objectInitWithContext(context) {
			LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
        Object[] givenArgs = thisJoinPoint.getArgs();
        Class called = ((ConstructorSignature)thisJoinPoint.getStaticPart().getSignature()).getConstructor().getDeclaringClass();
			if (stack.isEmpty())
			{
				if(log.isLoggable(Level.FINE)) CoinjemaLogger.log.fine("Contextualizing " + called + " in context ''/" + context);
				return Recipe.constructContextualized(called,givenArgs, context, null);
			}
			else
			{
				if(log.isLoggable(Level.FINE)) CoinjemaLogger.log.fine("Contextualizing " + called + " in context '" + stack.getFirst() + "'/" + context);
				return Recipe.constructContextualized(called,givenArgs, context, stack.getFirst());
			}
	}

}
