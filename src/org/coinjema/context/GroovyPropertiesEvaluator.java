package org.coinjema.context;



import static org.coinjema.logging.CoinjemaLogger.log;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.logging.Level;

class GroovyPropertiesEvaluator extends PropertiesEvaluator {

	protected Properties processProps(Properties props,Map params) {
		Properties evaledProps = new Properties();
		Binding vars = new Binding(params);
		GroovyShell shell = new GroovyShell(vars);
		
		for(Entry<Object,Object> entry : props.entrySet())
		{
			String key = null;
			String val = null;
			try {
				key = entry.getKey().toString().length() > 0 ?
						(String)shell.evaluate(entry.getKey().toString()) : "";
			} catch(Exception e)
			{
				if(log.isLoggable(Level.INFO)) log.info("key '" + entry.getKey() + "' not a groovy expression");
				key = entry.getKey().toString();
			}
			try
			{
				val = entry.getValue().toString().length() > 0 ?
						(String)shell.evaluate(entry.getValue().toString()) : "";
			} catch(Exception e)
			{
				if(log.isLoggable(Level.INFO)) log.info("value '" + entry.getValue() + "' not a groovy expression");
				val = entry.getValue().toString();
			}
			if(key != null && val != null)
				evaledProps.setProperty(key,val);
		}
		return evaledProps;
	}

}
