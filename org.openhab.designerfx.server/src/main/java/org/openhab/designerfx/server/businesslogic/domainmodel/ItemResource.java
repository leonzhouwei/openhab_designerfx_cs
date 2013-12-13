package org.openhab.designerfx.server.businesslogic.domainmodel;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ItemResource {
	
	public class ItemNameInUseException extends RuntimeException {
		private static final long serialVersionUID = -470568796749401836L;
		
		public ItemNameInUseException(String itemName) {
			super("Item name '" + itemName + "' has already been used.");
		}
	}
	
	public static class Item {
		private String type;
		private String name;
		private String labelText;
		private String iconName;
		private List<String> groups;
		private String bindingConfig;

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

	private String name;
	private List<Item> items = Lists.newArrayList();
	private Map<String, Item> map = Maps.newHashMap();
	
	public ItemResource(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) throws ItemNameInUseException {
		if (map.get(item.name) != null) {
			throw new ItemNameInUseException(item.name);
		}
		map.put(item.name, item);
		items.add(item);
	}

}
