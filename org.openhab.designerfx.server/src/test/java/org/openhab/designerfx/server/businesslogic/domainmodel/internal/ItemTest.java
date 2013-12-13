package org.openhab.designerfx.server.businesslogic.domainmodel.internal;

import org.junit.Test;

public class ItemTest {

	@Test
	public void test() {
		String line = "Switch Light_Room_Table \"Table Light\" (Room, Lights) { knx = \"<0/1/10+0/1/30\"}";
		Item item = Item.parse(line);
		System.out.println(item);
	}

}
