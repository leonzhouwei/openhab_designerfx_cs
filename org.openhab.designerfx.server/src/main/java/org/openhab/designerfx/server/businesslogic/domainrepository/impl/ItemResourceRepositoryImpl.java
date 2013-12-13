package org.openhab.designerfx.server.businesslogic.domainrepository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.openhab.designerfx.server.businesslogic.domainmodel.ItemResource;
import org.openhab.designerfx.server.businesslogic.domainrepository.ItemResourceRepository;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.persistence.ItemResourcePersistence;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class ItemResourceRepositoryImpl implements ItemResourceRepository {

	@Resource
	private ApplicationContext appContext;
	@Resource
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
		ItemResourcePersistence persist = appContext.getBean(ItemResourcePersistence.class);
		List<String> names = persist.listNames();
		System.out.println("oops: " + names.size());
		for (String name : names) {
			ItemResource ir = appContext.getBean(ItemResource.class);
			ir.setName(name);
			list.add(ir);
		}
	}

}
