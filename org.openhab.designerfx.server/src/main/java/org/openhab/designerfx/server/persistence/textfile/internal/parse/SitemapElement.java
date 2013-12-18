package org.openhab.designerfx.server.persistence.textfile.internal.parse;

import java.util.List;

import com.google.common.collect.Lists;

public class SitemapElement {

	private List<SitemapElementProperty> props = Lists.newArrayList();
	private List<SitemapElement> children = Lists.newArrayList();

	public List<SitemapElement> getChildren() {
		return children;
	}

	public void addChild(SitemapElement child) {
		children.add(child);
	}
	
	public void addProperty(SitemapElementProperty prop) {
		props.add(prop);
	}

}
