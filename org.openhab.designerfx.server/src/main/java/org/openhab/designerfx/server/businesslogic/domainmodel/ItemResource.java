package org.openhab.designerfx.server.businesslogic.domainmodel;

import java.util.List;
import java.util.Map;

import org.openhab.designerfx.server.businesslogic.domainmodel.internal.Item;
import org.openhab.designerfx.server.common.Loadable;
import org.openhab.designerfx.server.persistence.ItemResourcePersister;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ItemResource implements Loadable {
	
	private ItemResourcePersister persist;
	
	private String name;
	private List<Item> items = Lists.newArrayList();
	private Map<String, Item> map = Maps.newHashMap();
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public List<Item> getItems() {
		return items;
	}
	
	@Override
	public void load() {
		items.clear();
		map.clear();
		List<String> content = persist.getContent(name);
		for (String s : content) {
			Item item = Item.parse(s);
			items.add(item);
			map.put(name, item);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("name:\"" + name + "\"");
		sb.append(",");
		sb.append("items:[");
		for (Item item : items) {
			sb.append("\"" + item.toString() + "\"");
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		sb.append("}");
		return sb.toString();
	}

}
