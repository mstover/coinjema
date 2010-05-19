package configuration;

import org.coinjema.context.source.Resource;

/**
 * @author michaelstover
 * 
 */
public abstract class Config {

	private Resource resource;

	public void setSource(Resource res) {
		this.resource = res;
	}

	protected abstract void load();
}
