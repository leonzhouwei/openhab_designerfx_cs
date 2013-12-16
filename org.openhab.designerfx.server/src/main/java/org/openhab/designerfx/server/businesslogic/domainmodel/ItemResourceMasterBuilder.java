package org.openhab.designerfx.server.businesslogic.domainmodel;

import org.openhab.designerfx.server.persistence.ItemResourcePersisterBuilder;

public class ItemResourceMasterBuilder {
	
	private static ItemResourceMaster target = new ItemResourceMaster();
	static {
		target.setItemResourcePersistence(new ItemResourcePersisterBuilder().build());
	}
	
	public static ItemResourceMaster build() {
		return target;
	}

}
