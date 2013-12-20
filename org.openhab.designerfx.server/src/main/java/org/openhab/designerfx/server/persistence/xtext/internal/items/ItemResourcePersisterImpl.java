package org.openhab.designerfx.server.persistence.xtext.internal.items;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.persistence.xtext.items.ItemResourcePersister;
import org.openhab.designerfx.server.util.Util;

public class ItemResourcePersisterImpl implements ItemResourcePersister {
	
	private Context context;
	
	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public List<String> listNames() {
		String path = context.getOpenHABHome() + Constants.OPENHAB_ITEMS_DIR_RELATIVE_PATH;
		List<File> files = Util.listRegularFileNames(new File(path), Constants.ITEMS_FILE_EXTENSION);
		List<String> names = Util.baseNames(files, Constants.ITEMS_FILE_EXTENSION);
		return names;
	}

	@Override
	public List<String> getContent(String name) {
		List<String> content = null;
		try {
			File file = new File(context.getOpenHABHome() + Constants.OPENHAB_ITEMS_DIR_RELATIVE_PATH + Constants.FILE_SEPARATOR + name + Constants.ITEMS_FILE_EXTENSION);
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
