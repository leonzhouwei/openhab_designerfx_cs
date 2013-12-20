package org.openhab.designerfx.server.persistence.xtext.sitemap;

import java.util.Collection;

public interface Atom {

	/**
	 * 
	 * @return "Chart", "Colorpicker", ...
	 */
	public String getType();

	public Properties getProperties();

	public boolean addProperty(Property property);

	public boolean addProperties(Collection<? extends Property> properties);
	
	public String toXtext();

}
