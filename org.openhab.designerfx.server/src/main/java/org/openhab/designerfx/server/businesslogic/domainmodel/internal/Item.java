package org.openhab.designerfx.server.businesslogic.domainmodel.internal;

import java.util.List;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.DesignerFXException;

public class Item {

	public class ItemNameInUseException extends DesignerFXException {
		private static final long serialVersionUID = -6306477045323118068L;

		public ItemNameInUseException(String itemName) {
			super("Item name '" + itemName + "' has already been used.");
		}
	}

	private String type;
	private String name;
	private String labelText;
	private String iconName;
	private List<String> groups;
	private String bindingConfig;

	public static Item parse(String line) {
		// parse the type
		int typeEndIndex = line.indexOf(Constants.STRING_SPACE);
		final String type = line.substring(0, typeEndIndex);
		// parse the name
		line = line.substring(typeEndIndex).trim();
		int nameEndIndex = line.indexOf(Constants.STRING_SPACE);
		final String name = line.substring(0, nameEndIndex);
		// parse the label text
		// parse the icon name
		// parse the groups
		// parse the binding config
		Item item = new Item();
		item.setType(type);
		item.setName(name);
		return item;
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

	@Override
	public String toString() {
		return type + " " + name;
	}

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

}
