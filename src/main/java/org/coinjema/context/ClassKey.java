package org.coinjema.context;

class ClassKey {
	private final Class<?> objClass;
	private final String resourceName;
	private final int hash;

	public ClassKey(Class<?> oc,String name) {
		objClass = oc;
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
		result = PRIME * result + objClass.hashCode();
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
		final ClassKey other = (ClassKey) obj;
		if (!objClass.equals(other.objClass))
			return false;
		if (!resourceName.equals(other.resourceName))
			return false;
		return true;
	}

}
