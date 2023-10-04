package org.coinjema.testing.nontest;

import org.coinjema.cjm.AbstractContextOriented;
import org.coinjema.cjm.CjmDependency;

public class MockSingleton extends AbstractContextOriented {
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
    
    @CjmDependency(alias="mockName")
    public void setMockName(String mockName)
    {
    	this.mockName = mockName;
    }
    
    @CjmDependency(alias="simple")
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
	
	@CjmDependency(type="MockSingleton")
	public void setSelf(MockSingleton ms)
	{
		selfService = ms;
	}

}
