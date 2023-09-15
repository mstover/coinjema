package org.coinjema.nontest;

import java.util.List;

import org.coinjema.context.CoinjemaDynamic;

public class DataBaseObject {
	
	String context;
	
	public DataBaseObject(String c)
	{
		context = c;
	}
	
	public DataBaseObject()
	{
		
	}
	
	public String getContextString()
	{
		return context;
	}
	
	@CoinjemaDynamic(method="data",contextMethod="getContextString")
	public String getData()
	{
		return null;
	}
	
	@CoinjemaDynamic(method="allData")
	public List<String> getAllData()
	{
		return null;
	}

}
