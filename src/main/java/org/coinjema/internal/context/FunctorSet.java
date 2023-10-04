package org.coinjema.internal.context;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.CjmDependency;
import org.coinjema.cjm.CjmDependency.Order;
import org.coinjema.cjm.util.DependencyFunctor;
import org.coinjema.cjm.util.Functor;

import java.lang.reflect.Method;
import java.util.*;

public class FunctorSet implements Iterable<DependencyFunctor<Object>> {

    LinkedList<DependencyFunctor<Object>> functors;
    Map<CjmContext, Set<DependencyFunctor<Object>>> marked;
    Set<CjmContext> perContext = new HashSet<CjmContext>();

    public FunctorSet(Object obj) {
        retrieveFunctors(obj);
    }

    public Iterator<DependencyFunctor<Object>> iterator() {
        return functors.iterator();
    }

    final void retrieveFunctors(final Object obj) {
        functors = new LinkedList<DependencyFunctor<Object>>();
        for (Method method : obj.getClass().getMethods()) {
            if (method.getAnnotation(CjmDependency.class) != null) {
                CjmDependency ann = method
                        .getAnnotation(CjmDependency.class);
                if (ann.order() == Order.LAST) {
                    functors.addLast(new DependencyFunctor<Object>(obj.getClass(), method, ann));
                } else {
                    functors.addFirst(new DependencyFunctor<Object>(obj.getClass(), method, ann));
                }
            } else if (method.getName().startsWith("set") && method.getParameterTypes().length == 1) {
                functors.addFirst(new DependencyFunctor<Object>(obj.getClass(), method));

            }
        }
    }

    synchronized void markForRemoval(DependencyFunctor<Object> inj, CjmContext cc) {
        if (marked == null) marked = new HashMap<>();
        Set<DependencyFunctor<Object>> marks = marked.computeIfAbsent(cc, k -> new HashSet<>());
        marks.add(inj);
    }

    public boolean isMarked(Functor<Object> inj, CjmContext cc) {
        return marked != null && marked.containsKey(cc) && marked.get(cc).contains(inj);
    }

    synchronized void setContextDone(CjmContext cc) {
        perContext.add(cc);
    }

    synchronized boolean isContextDone(CjmContext cc) {
        return perContext.contains(cc);
    }
}
