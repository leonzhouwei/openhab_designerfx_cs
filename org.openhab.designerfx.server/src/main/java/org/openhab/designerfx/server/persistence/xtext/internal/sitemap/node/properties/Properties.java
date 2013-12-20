package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties;

import java.util.List;
import java.util.Set;

public interface Properties {

	public String type();

	public List<Property> properties();

	public Set<String> propertyNameSet();

	public String getValue(String name);

	public String getProperty(String name);

	public List<Properties> children();

	public String toXtext();

	public void addProperty(Property prop);

	public void addProperties(List<Property> prop);

	public void addChild(Properties child);

	public void deleteProperty(String name);

	public void deleteChild(int index);

}
