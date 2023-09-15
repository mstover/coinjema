package org.coinjema.context;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedList;

public privileged aspect DeserializationInterceptor {


	public pointcut readObject(ContextOriented called):
        execution(private void ContextOriented+.readObject(ObjectInputStream))
        && this(called) && within(ContextOriented+) && within(Serializable+);

	after(ContextOriented called) returning :
      readObject(called)
    {
		if (called.getCoinjemaContext() == null) {
			LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
			if (stack.isEmpty())
				Recipe.contextualize(called, null, null);
			else
				Recipe.contextualize(called, null, stack.getFirst());
		}

		else {
			LinkedList<CoinjemaContext> stack = ContextFactory.tracker.get();
			if (stack.isEmpty())
				Recipe.contextualize(called, called.getCoinjemaContext(), null);
			else
				Recipe.contextualize(called, called.getCoinjemaContext(), stack
						.getFirst());
		}
	}
}
