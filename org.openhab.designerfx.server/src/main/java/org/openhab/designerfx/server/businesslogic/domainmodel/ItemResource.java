package org.openhab.designerfx.server.businesslogic.domainmodel;

import java.util.List;
import java.util.Map;

import org.openhab.designerfx.server.businesslogic.domainmodel.internal.Item;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Loadable;
import org.openhab.designerfx.server.persistence.xtext.items.ItemResourcePersister;
import org.openhab.designerfx.server.persistence.xtext.items.ItemResourcePersisterBuilder;

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
		for (Item item : items) {
			sb.append(item.toString());
			sb.append(Constants.LINE_SEPARATOR);
		}
		return sb.toString();
	
	}
	
	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(Constants.LINE_SEPARATOR);
		sb.append(Constants.LINE_SEPARATOR);
		sb.append("id: ");
		sb.append(id);
		sb.append(Constants.LINE_SEPARATOR);
		sb.append("name: ");
		sb.append(name);
		sb.append(Constants.LINE_SEPARATOR);
		sb.append("items:");
		sb.append(Constants.LINE_SEPARATOR);
		sb.append("{");
		sb.append(Constants.LINE_SEPARATOR);
		for (Item item : items) {
			sb.append(item.toString());
			sb.append(Constants.LINE_SEPARATOR);
		}
		sb.append("}");
		return sb.toString();
	}

}
