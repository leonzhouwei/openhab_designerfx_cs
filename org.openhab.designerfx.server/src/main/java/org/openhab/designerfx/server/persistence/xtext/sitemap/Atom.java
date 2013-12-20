package org.openhab.designerfx.server.persistence.xtext.sitemap;

import java.util.Collection;

public interface Atom {

	/**
	 * 
	 * @return "Chart", "Colorpicker", ...
	 */
	public String getType();

	public NodeProperties getProperties();

	public boolean addProperty(NodeProperty property);

	public boolean addProperties(Collection<? extends NodeProperty> properties);
	
	public String toXtext();

}
