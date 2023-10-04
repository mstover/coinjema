package org.coinjema.cjm;

import java.io.File;

public interface Registry {

	void refresh();

	File getContextRoot();
	
	Object getSharedDep(String contextPath);
	
	Object getSharedDep(String contextPath,String depName);

}
