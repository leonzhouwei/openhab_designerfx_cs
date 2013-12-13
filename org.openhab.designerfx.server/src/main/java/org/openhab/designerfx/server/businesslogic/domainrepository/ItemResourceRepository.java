package org.openhab.designerfx.server.businesslogic.domainrepository;

import java.util.List;

import org.openhab.designerfx.server.businesslogic.domainmodel.ItemResource;

public interface ItemResourceRepository {
	
	public List<ItemResource> listAll();
	
	public List<String> listAllNames();

}
