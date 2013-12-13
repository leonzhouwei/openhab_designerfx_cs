package org.openhab.designerfx.server.businesslogic.domainrepository;

import java.util.List;

import org.openhab.designerfx.server.businesslogic.domainmodel.ItemResource;
import org.openhab.designerfx.server.common.Loadable;

public interface ItemResourceRepository extends Loadable  {
	
	public List<ItemResource> listAll();
	
	public List<String> listAllNames();

}
