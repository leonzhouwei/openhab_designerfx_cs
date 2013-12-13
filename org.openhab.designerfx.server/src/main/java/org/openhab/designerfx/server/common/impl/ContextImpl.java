package org.openhab.designerfx.server.common.impl;

import java.io.File;

import org.openhab.designerfx.server.common.Context;
import org.springframework.stereotype.Component;

@Component
public class ContextImpl implements Context {

	private String openHABHome;

	public String getOpenHABHome() {
		synchronized (this) {
			return openHABHome;
		}
	}

	public void setOpenHABHome(String path) throws Exception {
		synchronized (this) {
			File file = new File(path);
			if (!file.exists() || !file.isDirectory()) {
				throw new Exception("The file does not exist or is not a directory");
			}
			openHABHome = path;
		}
	}

}
