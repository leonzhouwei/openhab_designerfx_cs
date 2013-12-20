package org.openhab.designerfx.server.persistence.xtext.items;

import java.util.List;

public interface ItemResourcePersister {

	public List<String> listNames();
	
	public List<String> getContent(String name);
	
}
