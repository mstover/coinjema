package org.coinjema.testing.nontest;

import java.util.List;

import org.coinjema.cjm.CjmDynamic;

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
	
	@CjmDynamic(method="data",contextMethod="getContextString")
	public String getData()
	{
		return null;
	}
	
	@CjmDynamic(method="allData")
	public List<String> getAllData()
	{
		return null;
	}

}
