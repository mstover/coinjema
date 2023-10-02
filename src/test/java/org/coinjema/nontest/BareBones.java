package org.coinjema.nontest;

import java.net.URL;

import org.coinjema.context.*;

public class BareBones extends AbstractContextOriented {
	
	public BareBones() {
		super();
		Cjm.contextualize(this);
	}

	protected SimpleContextOriented sco = new SimpleContextOriented();
	
	URL home;

	public URL getHome() {
		return home;
	}

	@CjmDependency(alias="homeURL")
	public void setHome(URL home) {
		this.home = home;
	}

	public SimpleContextOriented getSco() {
		return sco;
	}

}
