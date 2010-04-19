package org.coinjema.context;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DynamicDepTracker {
	
	Map<Method,DynamicDependencyNameResolver> resolvers =new HashMap<Method,DynamicDependencyNameResolver>(); 
	
	synchronized ResourceNameResolver getNameResolver(Method m,Class objClass,CoinjemaDynamic ann)
	{
		DynamicDependencyNameResolver resolver = resolvers.get(m);
		if(resolver == null)
		{
			resolver = new DynamicDependencyNameResolver(objClass,ann,m);
			resolvers.put(m, resolver);
		}
		return resolver;
		
	}

}
