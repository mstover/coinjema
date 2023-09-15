package org.coinjema.context.source;

import java.util.HashSet;
import java.util.Set;

public enum MetaType {
	inherit,perClass,perObj,global;
	
	public static String stripMetaTypes(String name)
	{
		String result = name;
		for(MetaType type : MetaType.values())
		{
			result = result.replaceAll("\\."+type.toString(), "");
		}
		return result;
	}
	
	public static Set<MetaType> getIncludedTypes(String name)
	{
		Set<MetaType> types = new HashSet<MetaType>();
		for(MetaType type : MetaType.values())
		{
			if(name.indexOf("."+type.toString()) > -1)
				types.add(type);
		}
		if(!types.contains(perClass) && !types.contains(perObj)) types.add(global);
		return types;
	}
	

}
