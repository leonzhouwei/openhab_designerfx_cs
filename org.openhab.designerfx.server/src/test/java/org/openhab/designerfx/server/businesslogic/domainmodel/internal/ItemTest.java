package org.openhab.designerfx.server.businesslogic.domainmodel.internal;

import org.junit.Test;
import org.openhab.designerfx.server.util.Util;

public class ItemTest {

	@Test
	public void test() {
		String line = "Switch Light_Room_Table \"Table Light\" <iconname> (Room,Lights)";
		Item item = Item.parse(line);
		Util.printSeparateLine();
		System.out.println(item);
	}

}
