package org.openhab.designerfx.server.businesslogic.domainmodel.internal;

import java.util.List;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.DesignerFXException;

import com.google.common.collect.Lists;

public class Item {
	
	public class InvalidParserStringException extends DesignerFXException {
		private static final long serialVersionUID = -6306477045323118068L;

		public InvalidParserStringException(String string) {
			super(string + " is not correct");
		}
	}

	public class ItemNameInUseException extends DesignerFXException {
		private static final long serialVersionUID = -6306477045323118068L;

		public ItemNameInUseException(String itemName) {
			super("Item name '" + itemName + "' has already been used.");
		}
	}

	private String type; // mandatory
	private String name; // mandatory
	private String labelText; // optional
	private String iconName; // optional
	private List<String> groups = Lists.newArrayList(); // optional
	private String bindingConfig; // optional

	public static Item parse(String line) {
		Item item = new Item();
		// parse the type
		int index = -1;
		line = line.trim();
		index = line.indexOf(Constants.STRING_SPACE);
		final String type = line.substring(0, index);
		item.setType(type);
		// parse the name
		if (index > line.length() - 1) {
			return item;
		}
		line = line.substring(index).trim();
		index = line.indexOf(Constants.STRING_SPACE);
		if (index == -1) {
			item.setName(line);
			return item;
		}
		final String name = line.substring(0, index);
		item.setName(name);
		// parse the label text if exists
		if (index > line.length() - 1) {
			return item;
		}
		line = line.substring(index).trim();
		if (line.startsWith("\"")) {
			index = line.indexOf("\"", 1);
			final String labelText = line.substring(1, index);
			item.setLabelText(labelText);
			index = index + 1;
		}
		// parse the icon name if exists
		if (index > line.length() - 1) {
			return item;
		}
		line = line.substring(index).trim();
		if (line.startsWith("<")) {
			index = line.indexOf(">", 1);
			final String iconName = line.substring(1, index);
			item.setIconName(iconName);
			index = index + 1;
		}
		// parse the groups if exists
		if (index > line.length() - 1) {
			return item;
		}
		line = line.substring(index).trim();
		if (line.startsWith("(")) {
			index = line.indexOf(")", index + 1);
			final String s = line.substring(1, index);
			String[] groups = s.split(",");
			item.addGroups(groups);
			index = index + 1;
		}
		// parse the binding config if exists
		if (index > line.length() - 1) {
			return item;
		}
		line = line.substring(index).trim();
		if (line.startsWith("{")) {
			index = line.indexOf("}", index + 1);
			final String bindingConfig = line.substring(1, index);
			item.setBindingConfig(bindingConfig);
		}
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
		// itemtype itemname ["labeltext"] [<iconname>] [(group1, group2, ...)] [{bindingconfig}]
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		sb.append(Constants.STRING_SPACE);
		sb.append(name);
		if (labelText != null) {
			sb.append(Constants.STRING_SPACE);
			sb.append("\"");
			sb.append(labelText);
			sb.append("\"");
		}
		if (iconName != null) {
			sb.append(Constants.STRING_SPACE);
			sb.append("<");
			sb.append(iconName);
			sb.append(">");
		}
		if (!groups.isEmpty()) {
			sb.append(Constants.STRING_SPACE);
			sb.append("(");
			for (String group : groups) {
				sb.append(group);
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append(")");
		}
		if (bindingConfig != null) {
			sb.append(Constants.STRING_SPACE);
			sb.append("{");
			sb.append(bindingConfig);
			sb.append("}");
		}
		return sb.toString();
	}

	public void setType(String type) {
		this.type = type.trim();
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText.trim();
	}

	public void setIconName(String iconName) {
		this.iconName = iconName.trim();
	}

	public void addGroups(String[] groups) {
		for (String group : groups) {
			this.groups.add(group.trim());
		}
	}

	public void setBindingConfig(String bindingConfig) {
		this.bindingConfig = bindingConfig.trim();
	}

}
