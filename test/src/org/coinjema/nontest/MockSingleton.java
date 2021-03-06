package org.coinjema.nontest;

import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject
public class MockSingleton {
    String mainValue;
    SimpleDynamic dyn = new SimpleDynamic();
    String mockName;
    MockSingleton selfService;

    public MockSingleton() {
        super();
    }
    
    public String getMainValue()
    {
        return mainValue;
    }
    
    public void setMainValue(String mv)
    {
        mainValue = mv;
    }
    
    @CoinjemaDependency(alias="mockName")
    public void setMockName(String mockName)
    {
    	this.mockName = mockName;
    }
    
    @CoinjemaDependency(alias="simple")
    public void setCircularDependency(SimpleContextOriented bco)
    {
    	
    }
    
    public String getProperty(String key)
    {
    	return dyn.getProperties().getProperty(key);
    }

	public String getMockName() {
		return mockName;
	}
	
	@CoinjemaDependency(type="MockSingleton")
	public void setSelf(MockSingleton ms)
	{
		selfService = ms;
	}

}
