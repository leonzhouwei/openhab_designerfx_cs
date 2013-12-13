package org.openhab.designerfx.server.persistence;

import java.util.List;

import org.openhab.designerfx.server.common.Loadable;

public interface ItemResourcePersistence {

	public List<String> listNames();
	
	public List<String> getContent(String name);
	
}
