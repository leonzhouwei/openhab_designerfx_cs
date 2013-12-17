package org.openhab.designerfx.server.businesslogic.domainmodel;

import java.util.List;
import java.util.Map;

import org.openhab.designerfx.server.businesslogic.domainmodel.internal.Item;
import org.openhab.designerfx.server.common.Loadable;
import org.openhab.designerfx.server.persistence.ItemResourcePersister;
import org.openhab.designerfx.server.persistence.ItemResourcePersisterBuilder;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ItemResource implements Loadable {
	
	private final Long id;
	private String name;
	private List<Item> items = Lists.newArrayList();
	private Map<String, Item> map = Maps.newHashMap();
	private ItemResourcePersister persist = new ItemResourcePersisterBuilder().build();
	
	public ItemResource(Long id, String name) {
		this.id = id;
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
			s = s.trim();
			if (s.startsWith("/\\*") || s.startsWith("*") || s.endsWith("*/")) {
				continue;
			}
			Item item = Item.parse(s);
			items.add(item);
			map.put(name, item);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append(super.toString());
		sb.append("\n");
		sb.append("id: ");
		sb.append(id);
		sb.append("\n");
		sb.append("name: ");
		sb.append(name);
		sb.append("\n");
		sb.append("items:");
		sb.append("\n");
		sb.append("{\n");
		for (Item item : items) {
			sb.append(item.toString());
			sb.append("\n");
		}
		sb.append("}");
		return sb.toString();
	}

}
