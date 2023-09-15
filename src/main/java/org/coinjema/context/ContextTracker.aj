package org.coinjema.context;

import java.util.LinkedList;

public privileged aspect ContextTracker {

	public pointcut contextTrack(ContextOriented obj):
		this(obj) && ((execution(!@CoinjemaDependency * ContextOriented+.*(..)) &&
				@within(CoinjemaContextTrack)) || (execution(@CoinjemaContextTrack * *.*(..))));

	public pointcut autoTrack(ContextOriented obj):
		this(obj) && execution(* ContextOriented+.*(..)) && !execution(protected * ContextOriented+.*(..))
		&& !execution(private * ContextOriented+.*(..))
		 && !execution(@CoinjemaDependency * ContextOriented+.*(..)) && !execution( * ContextOriented+.isGiven()) 
		 && !execution( * ContextOriented+.getCoinjemaContext()) && !execution( * ContextOriented+.setCoinjemaContext(..));

	Object around(ContextOriented obj): contextTrack(obj)
	{
		LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
		stack.addFirst(obj.getCoinjemaContext());
		try {
			Object o = proceed(obj);
			return o;
		} finally {
			stack.removeFirst();
		}
	}

	Object around(ContextOriented obj): autoTrack(obj)
	{
		if (obj.isGiven()) {
			LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
			stack.addFirst(obj.getCoinjemaContext());
			try {
				Object o = proceed(obj);
				return o;
			} finally {
				stack.removeFirst();
			}
		} else return proceed(obj);
	}

}
