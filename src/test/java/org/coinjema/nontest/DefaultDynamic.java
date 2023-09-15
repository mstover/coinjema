package org.coinjema.nontest;

import org.coinjema.context.CoinjemaDynamic;

public class DefaultDynamic {
	
	@CoinjemaDynamic
	public String getDefaultDynamic()
	{
		return "Howdy";
	}

}
