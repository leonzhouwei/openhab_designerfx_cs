package org.openhab.designerfx.server.businesslogic.domainmodel;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openhab.designerfx.server.common.Loadable;
import org.openhab.designerfx.server.persistence.ItemResourcePersistence;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ItemResourceMaster implements Loadable {

	private ItemResourcePersistence itemResourcePersistence;
	private Long nextId;
	// name-id mapping
	private Map<String, Long> map = Maps.newHashMap();

	public ItemResourcePersistence getItemResourcePersistence() {
		return itemResourcePersistence;
	}

	public void setItemResourcePersistence(
			ItemResourcePersistence itemResourcePersistence) {
		this.itemResourcePersistence = itemResourcePersistence;
	}

	public Long getItemResourceId(String name) {
		return map.get(name);
	}

	@Override
	public void load() {
		nextId = 1L;
		map.clear();
		List<String> names = itemResourcePersistence.listNames();
		for (String name : names) {
			map.put(name, nextId);
			nextId += 1;
		}
	}
	
	public List<String> listItemResourceNames() {
		List<String> names = Lists.newArrayList();
		Set<Entry<String, Long>> set = map.entrySet();
		for (Entry<String, Long> entry : set) {
			names.add(entry.getKey());
		}
		return names;
	}

}
