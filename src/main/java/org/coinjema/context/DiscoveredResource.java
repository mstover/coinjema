package org.coinjema.context;

import org.coinjema.context.source.Resource;

class DiscoveredResource {
	Resource res;
	Object dep;
	
	public DiscoveredResource(Resource r,Object d)
	{
		res = r;
		dep = d;
	}
	
	public String toString()
	{
		return "Discovered Resource(depOf:" + dep + "; res:" + res + ")";
	}

}
