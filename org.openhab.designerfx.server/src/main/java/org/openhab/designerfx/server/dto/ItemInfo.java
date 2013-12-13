package org.openhab.designerfx.server.dto;

import java.util.List;

public class ItemInfo {

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
		
		public Builder(String type, String name) {
			this.type = type;
			this.name = name;
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

		public ItemInfo build() {
			return new ItemInfo(this);
		}
		
	}

	private ItemInfo(Builder builder) {
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
