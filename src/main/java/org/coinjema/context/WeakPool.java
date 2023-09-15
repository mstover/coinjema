package org.coinjema.context;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Keeps weak track of all Context Oriented objects that pass through
 * @author mikes
 *
 */
class WeakPool implements Iterable<ContextOriented> {
	
	Map<ContextOriented,Object> map = new WeakHashMap<ContextOriented,Object>();

	public WeakPool() {
		super();
	}
	
	public synchronized void addObject(ContextOriented o)
	{		
		map.put(o,null);
	}
	
	public synchronized Iterator<ContextOriented> iterator()
	{
		return map.keySet().iterator();
	}

}
