package org.openhab.designerfx.server.businesslogic.domainrepository.impl;

import java.util.List;

import org.openhab.designerfx.server.businesslogic.domainmodel.ItemResource;
import org.openhab.designerfx.server.businesslogic.domainrepository.ItemResourceRepository;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.persistence.ItemResourcePersistence;

import com.google.common.collect.Lists;

public class ItemResourceRepositoryImpl implements ItemResourceRepository {

	private Context context;
	
	private List<ItemResource> list = Lists.newArrayList();
	
	@Override
	public List<ItemResource> listAll() {
		return list;
	}

	@Override
	public List<String> listAllNames() {
		List<String> names = Lists.newArrayList();
		for (ItemResource ir : list) {
			names.add(ir.getName());
		}
		return names;
	}

	@Override
	public void load() {
		ItemResourcePersistence persist = null;
		List<String> names = persist.listNames();
		for (String name : names) {
			ItemResource ir = null;
			ir.setName(name);
			list.add(ir);
		}
	}

}
