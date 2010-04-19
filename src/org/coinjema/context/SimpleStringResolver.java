package org.coinjema.context;

import static org.coinjema.logging.CoinjemaLogger.log;

import java.util.Collection;
import java.util.logging.Level;

public class SimpleStringResolver extends AbstractNameResolver {
	String name;
	
	public SimpleStringResolver(String name)
	{
		this.name = name;
	}

	public Object findDependency(NameLoop evaluator) {
		return evaluator.getDependency(name);
	}

	public String getLocalName() {
		return name;
	}

	public String getName() {
		return name;
	}

	@Override
	protected String nextName() {
		return null;
	}

	@Override
	protected void reset() {		
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
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
		final SimpleStringResolver other = (SimpleStringResolver) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	public Object findMatchingUnfinishedObject(Collection<ContextOriented> unfinishedObjects,
			CoinjemaContext cc)
	{
		if(log.isLoggable(Level.FINEST))
		{
			log.finest("SimpleStringResolver: looking for match with resource: " + name + " in context: " + cc + " amongst objects: ");
			for(ContextOriented co : unfinishedObjects)
			{
				log.finest("Object " + co + " in context " + co.getCoinjemaContext());
			}
		}
		return null;
	}

}
