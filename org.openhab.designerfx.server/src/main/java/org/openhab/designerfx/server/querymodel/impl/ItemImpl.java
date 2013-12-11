package org.openhab.designerfx.server.querymodel.impl;

import java.util.List;

import org.openhab.designerfx.server.querymodel.Item;


public class ItemImpl implements Item {
	
	private String type;
	private String name;
	private String labelText;
	private String iconName;
	private List<String> groups;
	private String bindingConfig;

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public void setBindingConfig(String bindingConfig) {
		this.bindingConfig = bindingConfig;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getLabelText() {
		return labelText;
	}

	@Override
	public String getIconName() {
		return iconName;
	}

	@Override
	public List<String> getGroups() {
		return groups;
	}

	@Override
	public String getBindingConfig() {
		return bindingConfig;
	}

}
