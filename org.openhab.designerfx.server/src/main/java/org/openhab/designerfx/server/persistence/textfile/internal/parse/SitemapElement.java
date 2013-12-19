package org.openhab.designerfx.server.persistence.textfile.internal.parse;

import java.util.List;

import com.google.common.collect.Lists;

public class SitemapElement {

	private List<SitemapElementProperty> properties = Lists.newArrayList();
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
	
	public void addProperty(SitemapElementProperty prop) {
		properties.add(prop);
	}
	
	public void addPropertys(List<SitemapElementProperty> props) {
		properties.addAll(props);
	}
	
}
