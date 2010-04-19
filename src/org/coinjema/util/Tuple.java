package org.coinjema.util;

public class Tuple<A,B> {
	
	public A first;
	public B second;

	public Tuple() {
	}
	
	public Tuple(A one,B two)
	{
		first = one;
		second = two;
	}

}
