package org.coinjema.context;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.coinjema.context.CoinjemaDependency.Order;
import org.coinjema.util.DependencyFunctor;
import org.coinjema.util.Functor;

public class FunctorSet implements Iterable<DependencyFunctor<Object>> {

	LinkedList<DependencyFunctor<Object>> functors;
	Map<CoinjemaContext,Set<DependencyFunctor<Object>>> marked;
	Set<CoinjemaContext> perContext = new HashSet<CoinjemaContext>();

	public FunctorSet(ContextOriented obj) {
		retrieveFunctors(obj);
	}

	public Iterator<DependencyFunctor<Object>> iterator() {
		return functors.iterator();
	}

	final void retrieveFunctors(final ContextOriented obj) {
		functors = new LinkedList<DependencyFunctor<Object>>();
		for (Method method : obj.getClass().getMethods()) {
			if (method.getAnnotation(CoinjemaDependency.class) != null) {
				CoinjemaDependency ann = method
						.getAnnotation(CoinjemaDependency.class);
				if (ann.order() == Order.LAST) {
					functors.addLast(new DependencyFunctor<Object>(obj.getClass(),method, ann));
				} else {
					functors.addFirst(new DependencyFunctor<Object>(obj.getClass(),method,	ann));
				}
			}
			else if(method.getName().startsWith("set") && method.getParameterTypes().length == 1){
				functors.addFirst(new DependencyFunctor<Object>(obj.getClass(),method));
				
			}
		}
	}
	
	synchronized void markForRemoval(DependencyFunctor<Object> inj,CoinjemaContext cc)
	{
		if(marked == null) marked = new HashMap<CoinjemaContext,Set<DependencyFunctor<Object>>>();
		Set<DependencyFunctor<Object>> marks = marked.get(cc);
		if(marks == null)
		{
			marks = new HashSet<DependencyFunctor<Object>>();
			marked.put(cc,marks);
		}
		marks.add(inj);
	}
	
	public boolean isMarked(Functor inj,CoinjemaContext cc)
	{
		return marked != null && marked.containsKey(cc) && marked.get(cc).contains(inj);
	}
	
	synchronized void setContextDone(CoinjemaContext cc)
	{
		perContext.add(cc);
	}
	
	synchronized boolean isContextDone(CoinjemaContext cc)
	{
		return perContext.contains(cc);
	}
}
