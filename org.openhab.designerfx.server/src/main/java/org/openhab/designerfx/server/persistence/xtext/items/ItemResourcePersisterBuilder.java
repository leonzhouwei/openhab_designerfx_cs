package org.openhab.designerfx.server.persistence.xtext.items;

import org.openhab.designerfx.server.common.ContextBuilder;
import org.openhab.designerfx.server.persistence.xtext.internal.items.ItemResourcePersisterImpl;

public class ItemResourcePersisterBuilder {
	
	public ItemResourcePersister build() {
		ItemResourcePersisterImpl irp = new ItemResourcePersisterImpl();
		irp.setContext(ContextBuilder.build());
		return irp;
	}
	
}
