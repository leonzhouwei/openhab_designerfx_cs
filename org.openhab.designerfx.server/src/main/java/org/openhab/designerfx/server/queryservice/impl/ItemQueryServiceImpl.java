package org.openhab.designerfx.server.queryservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.openhab.designerfx.server.context.Context;
import org.openhab.designerfx.server.querymodel.Item;
import org.openhab.designerfx.server.queryservice.ItemQueryService;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class ItemQueryServiceImpl implements ItemQueryService {
	
	@Resource
	private Context context;
	
	@Override
	public List<String> listResourcesNames() {
//		File dir = new File(context.getOpenHABHome() + Constants.FILE_SEPARATOR + Constants.OPENHAB_CONFIG_DIR_BASE_NAME + Constants.FILE_SEPARATOR + Constants.OPENHAB_ITEMS_DIR_BASE_NAME);
//		if (!dir.exists() || !dir.isDirectory()) {
//			return Lists.newArrayList();
//		}
//		List<File> files = Util.listRegularFileNames(dir, Constants.ITEMS_FILE_EXTENSION);
//		List<String> names = Util.baseNames(files, Constants.ITEMS_FILE_EXTENSION);
//		return names;
		return Lists.newArrayList("demo");
	}

	@Override
	public List<Item> getItems(String resourceName) {
//		File file = new File(context.getOpenHABHome() + Constants.FILE_SEPARATOR + Constants.OPENHAB_CONFIG_DIR_BASE_NAME + Constants.FILE_SEPARATOR + Constants.OPENHAB_ITEMS_DIR_BASE_NAME + Constants.FILE_SEPARATOR + resourceName);
//		if (!file.exists() || !file.isFile()) {
//			return null;
//		}
//		try {
//			Util.readAll(file);
//		} catch (IOException e) {
//		}
//		return null;
		List<String> groups = Lists.newArrayList("demo");
		List<Item> items = Lists.newArrayList();
		Item item = new Item.Builder().type("demo-text-item").name("demo").labelText("Demo Text Item").groups(groups).bindingConfig("").build();
		items.add(item);
		return items;
	}

}