package org.openhab.designerfx.server.queryservice;

import java.util.List;

import org.openhab.designerfx.server.querymodel.Item;

public interface ItemQueryService {
	
	public List<String> listResourcesNames();
	
	public List<Item> getItems(String resourceName) ;
	
}
