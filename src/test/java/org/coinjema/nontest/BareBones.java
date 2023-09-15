package org.coinjema.nontest;

import java.net.URL;

import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject
public class BareBones {
	
	public BareBones() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected SimpleContextOriented sco = new SimpleContextOriented();
	
	URL home;

	public URL getHome() {
		return home;
	}

	@CoinjemaDependency(alias="homeURL")
	public void setHome(URL home) {
		this.home = home;
	}

	public SimpleContextOriented getSco() {
		return sco;
	}

}
