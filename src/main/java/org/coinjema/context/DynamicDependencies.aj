package org.coinjema.context;

import static org.coinjema.logging.CoinjemaLogger.log;

import java.util.LinkedList;
import java.util.logging.Level;

import org.aspectj.lang.reflect.MethodSignature;

public privileged aspect DynamicDependencies {

	public pointcut dynamicDependency():
    	execution(@CoinjemaDynamic * *.*());

	Object around(): 
    	dynamicDependency()
    {
		if (log.isLoggable(Level.FINER)) {
			log.finer("Getting dynamic dependency: "
							+ thisJoinPointStaticPart.getSignature()
									.getDeclaringType().getName()
							+ "("
							+ ((MethodSignature) thisJoinPointStaticPart
									.getSignature()).getMethod().getName()
							+ ")");
		}
		LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
		if (stack.isEmpty()) {
			try {
				return Recipe.findDynamicDependency(thisJoinPoint.getThis(),
						thisJoinPointStaticPart.getSignature().getDeclaringType(),
						((MethodSignature) thisJoinPointStaticPart
								.getSignature()).getMethod().getAnnotation(
								CoinjemaDynamic.class),
						((MethodSignature) thisJoinPointStaticPart
								.getSignature()).getMethod(), null);
			} catch (DependencyInjectionException e) {
				Object o = proceed();
				return o;
			}
		} else {
			CoinjemaContext thisContext = stack.getFirst();
			/*
			 * for (CoinjemaContext con : stack) { if (con != null) { if
			 * (con.getDepth() > thisContext.getDepth()) { thisContext = con; } } }
			 */
			try {
				return Recipe.findDynamicDependency(thisJoinPoint.getThis(),
						thisJoinPointStaticPart.getSignature().getDeclaringType(),
						((MethodSignature) thisJoinPoint.getSignature())
								.getMethod().getAnnotation(
										CoinjemaDynamic.class),
						((MethodSignature) thisJoinPointStaticPart
								.getSignature()).getMethod(), thisContext);
			} catch (DependencyInjectionException e) {
				Object o = proceed();
				return o;
			}
		}
	}

}
