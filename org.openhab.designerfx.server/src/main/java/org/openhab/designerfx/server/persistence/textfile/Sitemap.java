package org.openhab.designerfx.server.persistence.textfile;

import java.util.List;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElement;

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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Constants.LINE_SEPARATOR);
		sb.append("name: " + name);
		sb.append(Constants.LINE_SEPARATOR);
		sb.append("label: " + label);
		return sb.toString();
	}

}
