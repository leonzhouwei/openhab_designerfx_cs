package org.openhab.designerfx.server.common.impl;

import java.io.File;

import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.util.Util;

public class ContextImpl implements Context {

	private String openHABHome;

	public String getOpenHABHome() {
		synchronized (this) {
			return openHABHome;
		}
	}

	public void setOpenHABHome(String path) throws Exception {
		synchronized (this) {
			Util.printSeparateLine();
			System.out.println("Listing the openHAB home directory..." + " (" + path + ")");
			File file = new File(path);
			if (!file.exists() || !file.isDirectory()) {
				throw new Exception(path + " does not exist or is not a directory");
			}
			File[] files = file.listFiles();
			for (File child : files) {
				String string = child.getName();
				if (child.isDirectory()) {
					string += "/";
				}
				System.out.println(string);
			}
			openHABHome = path;
		}
	}

}
