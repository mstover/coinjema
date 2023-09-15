package org.coinjema.context;

import static org.coinjema.logging.CoinjemaLogger.log;

import java.util.Collection;
import java.util.logging.Level;

import org.coinjema.util.DependencyFunctor;

public class InjectorNameResolver extends AbstractNameResolver {
	
	DependencyFunctor<?> injector;
	Class objClass;
	ThreadLocal<String> fixedName = new ThreadLocal<String>() {
		public String initialValue()
		{
			return null;
		}
	};
	String localName,typeName,globalName;
	int count = -1;
	
	public InjectorNameResolver(Class objClass,DependencyFunctor<?> injector)
	{
		this.objClass = objClass;
		this.injector = injector;
	}
	
	protected void reset()
	{
		count = -1;
	}

	public synchronized String getLocalName() {
		return localName != null ? localName : (localName = (injector.isAliased() ? injector.getAliasLabel() : getSimpleName(objClass) + "." + injector.getMethodLabel()));
	}

	public String getName() {
		return fixedName.get();
	}

	public String nextName() {
		count++;
		switch(count)
		{
		case 0 : fixedName.set(getLocalName()); return fixedName.get();
		case 1 : fixedName.set(getTypeName()); return fixedName.get();
		case 2 : fixedName.set(getGlobalName()); return fixedName.get();
		default : return null;
		}
	}

	private synchronized String getGlobalName() {
		return globalName != null ? globalName : (globalName = injector.isAliased() ?  injector.getInjectedLabel() : null);
	}
	
	private synchronized String getTypeName()
	{
		return typeName != null ? typeName : (typeName = injector.isAliased() ? getSimpleName(objClass) + "." + injector.getMethodLabel() : injector.getInjectedLabel());
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((injector == null) ? 0 : injector.hashCode());
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
		final InjectorNameResolver other = (InjectorNameResolver) obj;
		if (injector == null) {
			if (other.injector != null)
				return false;
		} else if (!injector.equals(other.injector))
			return false;
		return true;
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
			if(co.getCoinjemaContext().equals(cc) && injector.getInjectedClass().isAssignableFrom(co.getClass()))
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
