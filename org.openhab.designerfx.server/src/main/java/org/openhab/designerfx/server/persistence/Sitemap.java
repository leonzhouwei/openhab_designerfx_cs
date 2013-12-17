package org.openhab.designerfx.server.persistence;

import java.util.List;

import com.google.common.collect.Lists;

public class Sitemap {

	private String name;
	private String label;
	private List<SitemapElement> elements = Lists.newArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public void addElement(SitemapElement e) {
		elements.add(e);
	}

}
