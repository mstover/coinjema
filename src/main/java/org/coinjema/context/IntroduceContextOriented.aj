package org.coinjema.context;

public aspect IntroduceContextOriented {


	declare parents : @CoinjemaObject * implements ContextOriented;
	declare parents : @CoinjemaConstructorObject * implements ConstructorContextOriented;

	private CoinjemaContext ContextOriented.context;

	private boolean ContextOriented.isGiven = false;

	public void ContextOriented.setCoinjemaContext(CoinjemaContext c) {
		this.context = c;
	}

	public CoinjemaContext ContextOriented.getCoinjemaContext() {
		return this.context;
	}

	public boolean ContextOriented.isGiven() {
		return this.isGiven;
	}

	public void ContextOriented.setGiven(boolean g) {
		this.isGiven = g;
	}
}
