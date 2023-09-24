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

import org.coinjema.logging.CoinjemaLogger;

public aspect ConstructorContextBuilder {

	pointcut objectInit(ConstructorContextOriented called):
      execution(ConstructorContextOriented+.new(..)) && this(called);

	pointcut objectInitWithContext(CoinjemaContext context,
			ConstructorContextOriented called):
        execution(ConstructorContextOriented+.new(..,CoinjemaContext)) && this(called) && args(..,context);


	Object around(ConstructorContextOriented called):
      objectInit(called) && !objectInitWithContext(CoinjemaContext,ContextOriented)
    {
        Object[] givenArgs = thisJoinPoint.getArgs();
        LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
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

	Object around(CoinjemaContext context, ConstructorContextOriented called):
          objectInitWithContext(context,called) {
			LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
			called.setGiven(true);
        Object[] givenArgs = thisJoinPoint.getArgs();
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
