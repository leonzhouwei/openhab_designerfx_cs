package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.properties;

import org.openhab.designerfx.server.persistence.xtext.sitemap.Property;

public class PropertyImpl implements Property {

	private String name; // should not be null or empty
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
