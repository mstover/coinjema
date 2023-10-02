package org.coinjema.context;

import static org.coinjema.logging.CoinjemaLogger.log;

import java.util.Collection;
import java.util.Objects;
import java.util.logging.Level;

public class SimpleStringResolver implements ResourceNameResolver {
	private final String name;
	
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SimpleStringResolver that = (SimpleStringResolver) o;

        return Objects.equals(name, that.name);
    }

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	public Object findMatchingUnfinishedObject(Collection<ContextOriented> unfinishedObjects,
											   CjmContext cc)
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
