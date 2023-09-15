package org.coinjema.context;

import static org.coinjema.logging.CoinjemaLogger.log;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.logging.Level;

public class DynamicDependencyNameResolver extends AbstractNameResolver {
	int count = -1;
	CoinjemaDynamic ann;
	Class objClass;
	Method dynMethod;
	ThreadLocal<String> fixedName = new ThreadLocal<String>() {
		public String initialValue()
		{
			return null;
		}
	};
	String localName,typeName,globalName;
	
	public DynamicDependencyNameResolver(Class objClass,CoinjemaDynamic ann,Method dynMethod)
	{
		this.ann = ann;
		this.objClass = objClass;
		this.dynMethod = dynMethod;
	}
	
	public String getLocalName()
	{
		return localName != null ? localName : (localName = ann.alias().length() > 0 ? ann.alias() : getMethodLabel());
	}
	
	protected void reset()
	{
		count = -1;
	}
	
	protected String nextName()
	{
		count++;
		switch(count)
		{
		case 0 : fixedName.set(getLocalName()); return fixedName.get();
		case 1 : fixedName.set(getTypeName()); return fixedName.get();
		case 2 : fixedName.set(getGlobalName()); return fixedName.get();
		default : return null;
		}
	}

	private String getGlobalName() {
		return globalName != null ? globalName : (globalName = ann.alias().length() > 0 ? getTypeName(ann,dynMethod) : null);
	}

	private String getTypeName() {
		return typeName != null ? typeName : (typeName = ann.alias().length() > 0 ? getMethodLabel() : getTypeName(ann,dynMethod));
	}

	private String getMethodLabel() {
		return getSimpleName(objClass) + "." + getMethodName(ann,dynMethod);
	}
	
	public String getName()
	{
		return fixedName.get();
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((dynMethod == null) ? 0 : dynMethod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final DynamicDependencyNameResolver other = (DynamicDependencyNameResolver) obj;
		if (dynMethod == null) {
			if (other.dynMethod != null)
				return false;
		} else if (!dynMethod.equals(other.dynMethod))
			return false;
		return true;
	}
	
	private String getMethodName(CoinjemaDynamic ann,Method meth)
	{
		return ann.method().length() > 0 ? ann.method() : meth.getName();
	}
	
	private String getTypeName(CoinjemaDynamic ann,Method meth)
	{
		return ann.type().length() > 0 ? ann.type() : meth.getReturnType().getSimpleName();
	}
	
	public Method getDynMethod() {
		return dynMethod;
	}
	
	public Object findMatchingUnfinishedObject(Collection<ContextOriented> unfinishedObjects,
			CoinjemaContext cc)
	{
		if(log.isLoggable(Level.FINEST))
		{
			log.finest("DynamicDependencyResolver: looking for match with resource: " + getName() + " in context: " + cc );
		}
		for(ContextOriented co : unfinishedObjects)
		{
			if(log.isLoggable(Level.FINEST))
			{
				log.finest("DynamicDependencyResolver: Examining object: " + co + " against " + this);
			}
			if(co.getCoinjemaContext().equals(cc) && getDynMethod().getReturnType().isAssignableFrom(co.getClass()))
			{
				if(log.isLoggable(Level.FINEST))
				{
					log.finest("DynamicDependencyResolver: Examining object: " + co + " against " + this + " it matches");
				}
				return co;
			}
		}
		return null;
	}

}
