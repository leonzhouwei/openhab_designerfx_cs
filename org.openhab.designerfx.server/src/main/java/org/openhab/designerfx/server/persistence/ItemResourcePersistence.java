package org.openhab.designerfx.server.persistence;

import java.util.List;

public interface ItemResourcePersistence {

	public List<String> listNames();
	
	public List<String> getContent(String name);
	
}
