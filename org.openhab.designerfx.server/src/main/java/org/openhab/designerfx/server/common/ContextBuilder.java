package org.openhab.designerfx.server.common;

import org.openhab.designerfx.server.common.impl.ContextImpl;

public class ContextBuilder {
	
	private static Context target = new ContextImpl();

	public static Context build() {
		return target;
	}
	
}
