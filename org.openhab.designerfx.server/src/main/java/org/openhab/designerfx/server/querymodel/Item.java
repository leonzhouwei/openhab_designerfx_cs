package org.openhab.designerfx.server.querymodel;

import java.util.List;

public class Item {

	private String type;
	private String name;
	private String labelText;
	private String iconName;
	private List<String> groups;
	private String bindingConfig;

	public static class Builder {
		private String type;
		private String name;
		private String labelText;
		private String iconName;
		private List<String> groups;
		private String bindingConfig;

		public Builder type(String type) {
			this.type = type;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder labelText(String labelText) {
			this.labelText = labelText;
			return this;
		}
		
		public Builder groups(List<String> groups) {
			this.groups = groups;
			return this;
		}
		
		public Builder bindingConfig(String bindingConfig) {
			this.bindingConfig = bindingConfig;
			return this;
		}

		public Item build() {
			return new Item(this);
		}
		
	}

	private Item(Builder builder) {
		this.type = builder.type;
		this.name = builder.name;
		this.labelText = builder.labelText;
		this.iconName = builder.iconName;
		this.groups = builder.groups;
		this.bindingConfig = builder.bindingConfig;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getLabelText() {
		return labelText;
	}

	public String getIconName() {
		return iconName;
	}

	public List<String> getGroups() {
		return groups;
	}

	public String getBindingConfig() {
		return bindingConfig;
	}

}
