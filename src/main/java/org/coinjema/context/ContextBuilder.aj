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

import org.coinjema.logging.CoinjemaLogger;

public aspect ContextBuilder {	

	pointcut objectInit(ContextOriented called): 
      execution(ContextOriented+.new(..)) && this(called);

	pointcut objectInitWithContext(CoinjemaContext context,
			ContextOriented called):
        execution(ContextOriented+.new(..,CoinjemaContext)) && this(called) && args(..,context);


	after(ContextOriented called) returning: 
      objectInit(called) && !objectInitWithContext(CoinjemaContext,ContextOriented)
    {
			LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
			//called.setGiven(false);
			if (stack.isEmpty())
			{
				if(log.isLoggable(Level.FINE)) log.fine("Contextualizing " + called + " in context ''");
				Recipe.contextualize(called, null, null);
			}
			else
			{
				if(log.isLoggable(Level.FINE)) log.fine("Contextualizing " + called + " in context '" + stack.getFirst() + "'");
				Recipe.contextualize(called, null, stack.getFirst());
			}

	}

	after(CoinjemaContext context, ContextOriented called) returning :
          objectInitWithContext(context,called) {
			LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
			called.setGiven(true);
			if (stack.isEmpty())
			{
				if(log.isLoggable(Level.FINE)) CoinjemaLogger.log.fine("Contextualizing " + called + " in context ''/" + context);
				Recipe.contextualize(called, context, null);
			}
			else
			{
				if(log.isLoggable(Level.FINE)) CoinjemaLogger.log.fine("Contextualizing " + called + " in context '" + stack.getFirst() + "'/" + context);
				Recipe.contextualize(called, context, stack.getFirst());
			}
	}

}
