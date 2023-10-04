package org.coinjema.internal.context;

public class RackLoop {
	
	public static <T> T loop(SpiceRack base,LoopLogic<T> logic)
	{
		return limitedLoop(base,null,logic);
	}
	
	public static <T> T limitedLoop(SpiceRack base,SpiceRack stop,LoopLogic<T> logic)
	{
		SpiceRack parent = base;
		T obj = null;
		if(base == null) return null;
		do
		{
			obj = logic.eval(parent);
		}while(obj == null && (parent = parent.getParent()) != stop);
		return obj;
	}

}
