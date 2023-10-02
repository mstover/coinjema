package org.coinjema.context;



class DependencyGroup {
		public CjmContext context;
		public String resourceName;
		
		public DependencyGroup(String rn, CjmContext cc)
		{
			context = cc;
			resourceName = rn;
		}

		@Override
		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result + ((context == null) ? 0 : context.hashCode());
			result = PRIME * result + ((resourceName == null) ? 0 : resourceName.hashCode());
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
			final DependencyGroup other = (DependencyGroup) obj;
			if (context == null) {
				if (other.context != null)
					return false;
			} else if (!context.equals(other.context))
				return false;
			if (resourceName == null) {
				if (other.resourceName != null)
					return false;
			} else if (!resourceName.equals(other.resourceName))
				return false;
			return true;
		}
		
		
}
