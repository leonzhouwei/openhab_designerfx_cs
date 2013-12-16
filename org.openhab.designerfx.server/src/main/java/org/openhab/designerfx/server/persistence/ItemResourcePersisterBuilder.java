package org.openhab.designerfx.server.persistence;

import org.openhab.designerfx.server.common.ContextBuilder;
import org.openhab.designerfx.server.persistence.impl.ItemResourcePersisterImpl;

public class ItemResourcePersisterBuilder {
	
	public ItemResourcePersister build() {
		ItemResourcePersisterImpl irp = new ItemResourcePersisterImpl();
		irp.setContext(ContextBuilder.build());
		return irp;
	}
	
}
