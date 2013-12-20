package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse;

import java.util.List;

import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.Property;

import com.google.common.collect.Lists;

public class SitemapElement {

	private List<Property> properties = Lists.newArrayList();
	private List<SitemapElement> children = Lists.newArrayList();

	public List<SitemapElement> getChildren() {
		return children;
	}

	public void addChild(SitemapElement child) {
		children.add(child);
	}
	
	public void clearProperties() {
		properties.clear();
	}
	
	public void addProperty(Property prop) {
		properties.add(prop);
	}
	
	public void addPropertys(List<Property> props) {
		properties.addAll(props);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		
		return sb.toString();
	}
	
}
