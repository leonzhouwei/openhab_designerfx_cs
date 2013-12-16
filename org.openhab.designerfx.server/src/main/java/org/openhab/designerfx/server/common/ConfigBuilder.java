package org.openhab.designerfx.server.common;

import org.openhab.designerfx.server.common.impl.ConfigImpl;

public class ConfigBuilder {
	
	private static Config target = new ConfigImpl();
	
	public static Config build() {
		return target;
	}

}
