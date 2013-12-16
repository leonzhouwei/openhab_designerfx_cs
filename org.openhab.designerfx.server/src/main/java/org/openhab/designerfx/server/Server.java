package org.openhab.designerfx.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.openhab.designerfx.server.businesslogic.domainmodel.ItemResourceMaster;
import org.openhab.designerfx.server.businesslogic.domainmodel.ItemResourceMasterBuilder;
import org.openhab.designerfx.server.common.Config;
import org.openhab.designerfx.server.common.ConfigBuilder;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.common.ContextBuilder;
import org.openhab.designerfx.server.common.PromptMessage;
import org.openhab.designerfx.server.util.Util;

/**
 * 主Acotr监听socket连接请求，然后将请求转发给新建Acotr处理
 * 
 * @author Leon Zhou
 * 
 */
public class Server {

	public static void main(String[] args) throws Exception {
		init();
	}
	
	public static void getContext() throws Exception {
		// 获取环境参数
		File file = new File(Constants.CURRENT_WORKING_DIR).getParentFile();
		final String openHABHome = findOpenHABHome(file);
		if (openHABHome == null) {
			System.err.println(PromptMessage.OPENHAB_HOME_NOT_FOUND + " in \""
					+ file.getPath() + "\"");
			System.exit(-1);
		}
		Context context = ContextBuilder.build();
		context.setOpenHABHome(openHABHome);
	}

	public static void loadConfig() throws IOException {
		// 加载配置文件
		InputStreamReader isr = new InputStreamReader(new FileInputStream(
				"server.properties"), "utf-8");
		Config config = ConfigBuilder.build();
		config.load(isr);
		isr.close();
	}

	/**
	 * 
	 * @param directory
	 *            the upper direcotry of the home of this programme
	 * @return
	 */
	private static String findOpenHABHome(File directory) {
		String path = null;
		File[] files = directory.listFiles();
		for (File f : files) {
			String name = f.getName();
			if (name.startsWith("openhab-runtime")) {
				path = f.getPath();
				break;
			}
		}
		return path;
	}
	
	private static void init() throws Exception {
		getContext();
		loadConfig();
		//
		Util.printSeparateLine();
		ItemResourceMaster irm = ItemResourceMasterBuilder.build();
		irm.load();
		List<String> names = irm.listItemResourceNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

}
