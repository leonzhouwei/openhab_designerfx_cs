package org.openhab.designerfx.server.businesslogic.domainmodel.internal;

import java.util.List;

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

	public static Item parse(String line) throws InvalidParserStringException {
		line = line.trim();
		Item item = new Item();

		if (line.startsWith("Group:")) {
			String[] temp = line.split("\\s");
			String type = null;
			if (!temp[0].contains("(")) {
				type = temp[0];
			} else {
				final int endIndex = line.indexOf(")");
				type = line.substring(0, endIndex + 1);
			}
			item.setType(type);
			line = line.substring(type.length(), line.length()).trim();
		} else {
			// parse the type
			String[] forType = line.split("\\s");
			if (forType.length > 0) {
				for (String s : forType) {
					if (!s.trim().isEmpty()) {
						item.setType(s);
						final int index = line.indexOf(s);
						line = line
								.substring(index + s.length(), line.length())
								.trim();
						break;
					}
				}
			}
		}
		// parse the name
		//System.out.println("will parse name from " + line);
		if (!line.isEmpty()) {
			String[] array = line.split("\\b");
			if (array.length > 0) {
				for (String s : array) {
					if (!s.trim().isEmpty()) {
						item.setName(s);
						final int index = line.indexOf(s);
						line = line
								.substring(index + s.length(), line.length())
								.trim();
						break;
					}
				}
			}
		}
		// parse the label text
		//System.out.println("will parse label text from " + line);
		if (line.startsWith("\"")) {
			final int start = line.indexOf("\"");
			final int end = line.indexOf("\"", start + 1);
			item.setLabelText(line.substring(start + 1, end));
			line = line.substring(end + 1, line.length()).trim();
		}
		// parse the icon name
		//System.out.println("will parse icon name from " + line);
		if (line.startsWith("<")) {
			final int start = line.indexOf("<");
			final int end = line.indexOf(">");
			item.setIconName(line.substring(start + 1, end));
			line = line.substring(end + 1, line.length()).trim();
		}
		// parse the group(s)
		//System.out.println("will parse group(s) from " + line);
		if (line.startsWith("(")) {
			final int start = line.indexOf("(");
			final int end = line.indexOf(")");
			String s = line.substring(start + 1, end);
			String[] groups = { s };
			if (s.contains(",")) {
				groups = s.split(",");
			}
			item.addGroups(groups);
			line = line.substring(end + 1, line.length()).trim();
		}
		// parse the binding config
		if (line.startsWith("{")) {
			final int start = line.indexOf("{");
			final int end = line.indexOf("}");
			item.setBindingConfig(line.substring(start + 1, end));
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
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append(super.toString());
		sb.append("\n");
		sb.append("type: ");
		sb.append(type);
		sb.append("\n");
		sb.append("name: ");
		sb.append(name);
		sb.append("\n");
		if (labelText != null) {
			sb.append("labeltext: ");
			sb.append(labelText);
			sb.append("\n");
		}
		if (iconName != null) {
			sb.append("iconname: ");
			sb.append(iconName);
			sb.append("\n");
		}
		if (!groups.isEmpty()) {
			sb.append("groups: ");
			for (String group : groups) {
				sb.append(group);
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("\n");
		}
		if (bindingConfig != null) {
			sb.append("bindingconfig: ");
			sb.append(bindingConfig);
			sb.append("\n");
		}
		sb.append("}");
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
			addGroup(group);
		}
	}

	public void addGroup(String group) {
		groups.add(group.trim());
	}

	public void setBindingConfig(String bindingConfig) {
		this.bindingConfig = bindingConfig.trim();
	}

}
