package org.openhab.designerfx.server.persistence.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.persistence.ItemResourcePersistence;
import org.openhab.designerfx.server.util.Util;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ItemResourcePersistenceImpl implements ItemResourcePersistence {
	
	@Resource
	private Context context;
	
	@Override
	public List<String> listNames() {
		String path = context.getOpenHABHome() + Constants.FILE_SEPARATOR + Constants.OPENHAB_ITEMS_DIR_RELATIVE_PATH;
		List<File> files = Util.listRegularFileNames(new File(path), Constants.ITEMS_FILE_EXTENSION);
		List<String> names = Util.baseNames(files, Constants.ITEMS_FILE_EXTENSION);
		return names;
	}

	@Override
	public List<String> getContent(String name) {
		List<String> content = null;
		try {
			File file = new File(context.getOpenHABHome() + Constants.FILE_SEPARATOR + Constants.OPENHAB_ITEMS_DIR_RELATIVE_PATH + Constants.FILE_SEPARATOR + name + Constants.ITEMS_FILE_EXTENSION);
			if (file.exists()) {
				content = Util.readAllTrimEmptyLines(file);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return content;
	}

}
