package org.coinjema.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

public class TestFunctor extends TestCase {

	public TestFunctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestFunctor(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public void testPostChain1() throws Exception
	{
		Functor<String> f = new Functor<String>("append",new String[]{"Hello"}).postChain("toString");
		System.out.println(f.invokeOn(new StringBuffer()));
		assertEquals(String.class,f.invokeOn(new StringBuffer()).getClass());
		assertEquals("Hello",f.invokeOn(new StringBuffer()));
	}
	
	public void testPostChain2() throws Exception
	{
		Functor<String> f = new Functor<String>("toString").postChain(new StringBuffer(),"append").postChain("toString");
		Set stuff = new HashSet();
		stuff.add("Hello");
		assertEquals("[Hello]",f.invoke(stuff));
		assertEquals("[Hello][Hello]",f.invoke(stuff));
		System.out.println(f.invoke(stuff));
	}
	
	public void testPreChain1() throws Exception
	{
		Map stuff = new HashMap();
		stuff.put("name",new StringBuffer("Mike"));
		stuff.put("dogs",new String("yep"));
		Functor<String> f = new Functor<String>("append"," Howdy").preChain(new Functor("get","name"));
		f.postChain("toString");
		assertEquals("Mike Howdy",f.invokeOn(stuff));
	}
	
	public void testPreChain2() throws Exception
	{
		Map stuff = new HashMap();
		stuff.put("name",new StringBuffer("Mike"));
		stuff.put("dogs",new String("yep"));
		Functor<String> f = new Functor<String>("append").preChain(new Functor(stuff,"get","dogs"));
		f.postChain("toString");
		assertEquals("yep",f.invokeOn(new StringBuffer()));
	}
	
	public void testPreChain3() throws Exception
	{
		Map stuff = new HashMap();
		stuff.put("name",new StringBuffer("Mike"));
		stuff.put("dogs",new String("yep"));
		Functor f = new Functor(stuff,"get").preChain("toString");
		assertEquals("yep",f.invokeOn(new StringBuffer("dogs")));
	}

}
