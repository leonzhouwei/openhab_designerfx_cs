package org.openhab.designerfx.server.businesslogic.domainmodel;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerfx.server.common.Loadable;
import org.openhab.designerfx.server.persistence.ItemResourcePersister;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ItemResourceMaster implements Loadable {

	private static Long nextId;
	// name-id mapping
	private Map<String, Long> map = Maps.newHashMap();
	private List<ItemResource> list = Lists.newArrayList();
	
	private ItemResourcePersister itemResourcePersistence;

	public void setItemResourcePersistence(
			ItemResourcePersister itemResourcePersistence) {
		this.itemResourcePersistence = itemResourcePersistence;
	}

	@Override
	public void load() {
		nextId = 1L;
		map.clear();
		list.clear();
		List<String> names = itemResourcePersistence.listNames();
		for (String name : names) {
			ItemResource ir = new ItemResource(nextId, name);
			ir.load();
			list.add(ir);
			map.put(name, nextId);
			System.out.println(ir.toString());
			nextId += 1;
		}
	}
	
	public List<String> listItemResourceNames() {
		List<String> names = Lists.newArrayList();
		Set<String> set = map.keySet();
		for (String name : set) {
			names.add(name);
		}
		Collections.sort(names);
		return names;
	}
	
}
