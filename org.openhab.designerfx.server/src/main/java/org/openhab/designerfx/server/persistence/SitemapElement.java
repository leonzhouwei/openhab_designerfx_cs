package org.openhab.designerfx.server.persistence;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SitemapElement {
	// Syntax:
	// Colorpicker [item="<itemname>"] [label="<labelname>"] [icon="<iconname>"] [sendFrequency=""]
	private String type;
	private List<String> propNames = Lists.newArrayList();
	private Map<String, String> propValues = Maps.newHashMap();
	private List<SitemapElement> children = Lists.newArrayList();
	
	public String getType() {
		return type;
	}
	
	public List<String> getPropNames() {
		return propNames;
	}
	
	public String getPropValue(String propName) {
		return propValues.get(propName);
	}
	
	public List<SitemapElement> getChildren() {
		return children;
	}
	
	public String addProperty(String name, String value) {
		if (!propNames.contains(name)) {
			propNames.add(name);
		}
		return propValues.put(name, value);
	}
	
	public void addChild(SitemapElement child) {
		children.add(child);
	}
	
}
