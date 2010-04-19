package org.coinjema.context;

import java.io.File;

public interface Registry {
	
	File getContextRoot();
	
	Object getSharedDep(String contextPath);
	
	Object getSharedDep(String contextPath,String depName);

}
