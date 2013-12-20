package org.openhab.designerfx.server.persistence.xtext.internal.sitemap;

import org.openhab.designerfx.server.persistence.xtext.sitemap.NodeProperty;

public class NodePropertyImpl implements NodeProperty {

	private String name;
	private String value;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return value;
	}
	
	public void setName(String name) {
		this.name = name.trim();
	}
	
	public void setValue(String value) {
		if (value != null) {
			value = value.trim();
		}
		this.value = value;
	}

	@Override
	public String toXtext() {
		StringBuilder sb = new StringBuilder();
		if (name != null) {
			sb.append(name);
			if (value != null && !value.trim().isEmpty()) {
				sb.append("=");
				sb.append(value);
			}
		}
		return sb.toString();
	}

}
