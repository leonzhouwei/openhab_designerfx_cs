package org.openhab.designerfx.server.persistence.xtext.internal.sitemap;

import java.util.List;
import java.util.Set;


public interface NodeProperties {
	
	public String type();
	
	public List<SitemapElementProperty> properties();
	
	public Set<String> propertyNameSet();
	
	public String getValue(String name);
	
	public String getProperty(String name);
	
	public List<NodeProperties> children();
	
	public String toXtext();
	
	public void addProperty(SitemapElementProperty prop);
	
	public void addProperties(List<SitemapElementProperty> prop);
	
	public void addChild(NodeProperties child);
	
	public void deleteProperty(String name);
	
	public void deleteChild(int index);
	
}
