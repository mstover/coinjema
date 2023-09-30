package org.coinjema.context;

import org.coinjema.util.DependencyFunctor;

public abstract class AbstractNameResolver implements ResourceNameResolver {


	protected static String getSimpleName(final Class<?> clazz) {
		return ReflectionCache.getInfo(clazz).simpleName;
	}

	public Object findDependency(NameLoop evaluator) {
		reset();
		Object res = null;
		String name = nextName();
		while(res == null && name != null)
		{
			res = evaluator.getDependency(name);
			if(res == null) name = nextName();
		}
		return res;
	}
	
	abstract protected void reset();
	abstract protected String nextName();
	abstract public String getName();

	/**
	 * @param obj
	 * @param methodName
	 * @return
	 */
	protected static String getMethodBasedScriptName(
			final ContextOriented obj, final DependencyFunctor<Object> injector) {
		if (injector.isAliased())
			return injector.getAliasLabel();
		else
			return getSimpleName(obj.getClass()) + "."
					+ injector.getMethodLabel();
	}

}
