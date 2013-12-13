package org.openhab.designerfx.server.businesslogic.domainrepository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.openhab.designerfx.server.businesslogic.domainmodel.ItemResource;
import org.openhab.designerfx.server.businesslogic.domainrepository.ItemResourceRepository;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.persistence.ItemResourcePersistence;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

//@Component
public class ItemResourceRepositoryImpl implements ItemResourceRepository {

//	@Resource
	private Context context;
//	@Resource
	private ItemResourcePersistence persist;
	
	private List<ItemResource> list = Lists.newArrayList();
	
	public ItemResourceRepositoryImpl() {
		List<String> names = persist.listNames();
		for (String name : names) {
			ItemResource ir = new ItemResource();
			ir.setName(name);
			list.add(ir);
		}
	}

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

}
