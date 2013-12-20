package org.openhab.designerfx.server.persistence.xtext.sitemap;

import java.util.Collection;
import java.util.List;

public interface Node {
	
	/**
	 * 
	 * @return "Chart", "Colorpicker", ...
	 */
	public String getType();

	public Properties getProperties();

	public boolean addProperty(Property property);

	public boolean addProperties(Collection<? extends Property> properties);
	
	public List<Node> getChildren();
	
	public boolean addChild(Node child);
	
	public boolean addChildren(Collection<? extends Node> children);
	
	public String toXtext(String indentation);
	
}
