package org.openhab.designerfx.server.businesslogic.domainrepository.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.openhab.designerfx.server.businesslogic.domainmodel.ItemResource;
import org.openhab.designerfx.server.businesslogic.domainrepository.ItemResourceRepository;
import org.openhab.designerfx.server.common.Context;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Component
public class ItemResourceRepositoryImpl implements ItemResourceRepository {

	@Resource
	private Context context;
	private Map<String, ItemResource> map = Maps.newHashMap();
	private List<ItemResource> list = Lists.newArrayList();

	public ItemResourceRepositoryImpl() {
		final String name = "demo";
		ItemResource ir = new ItemResource(name);
		map.put(name, ir);
		list.add(ir);
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
