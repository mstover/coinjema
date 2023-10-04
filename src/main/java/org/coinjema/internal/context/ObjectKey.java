package org.coinjema.internal.context;

class ObjectKey {
	private final Object obj;
	private final String resourceName;
	private final int hash;
	
	ObjectKey(Object o,String name)
	{
		obj = o;
		resourceName = name;
		hash = calcHash();
	}

	@Override
	public int hashCode()
	{
		return hash;
	}
	
	private int calcHash() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + obj.hashCode();
		result = PRIME * result + resourceName.hashCode();
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
		final ObjectKey other = (ObjectKey) obj;
		if (!this.obj.equals(other.obj))
			return false;
		if (!resourceName.equals(other.resourceName))
			return false;
		return true;
	}
	
	

}
