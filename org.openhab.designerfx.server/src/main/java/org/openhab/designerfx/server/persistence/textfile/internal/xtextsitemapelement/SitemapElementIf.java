package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement;

import java.util.List;
import java.util.Set;

import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;

public interface SitemapElementIf {
	
	public String type();
	
	public List<SitemapElementProperty> properties();
	
	public Set<String> propertyNameSet();
	
	public String getValue(String name);
	
	public String getProperty(String name);
	
	public List<SitemapElementIf> children();
	
	public String toXtext();
	
	public void addProperty(SitemapElementProperty prop);
	
	public void addProperties(List<SitemapElementProperty> prop);
	
	public void addChild(SitemapElementIf child);
	
	public void deleteProperty(String name);
	
	public void deleteChild(int index);
	
}
