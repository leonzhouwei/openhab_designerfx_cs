package org.openhab.designerfx.server.businesslogic.domainmodel;

import org.junit.Test;
import org.openhab.designerfx.server.BaseTest;
import org.openhab.designerfx.server.util.Util;

public class ItemResourceMasterTest extends BaseTest {
	
	@Test
	public void test() {
		Util.printSeparateLine();
		ItemResourceMaster irm = ItemResourceMasterBuilder.build();
		irm.load();
//		List<String> names = irm.listItemResourceNames();
//		for (String name : names) {
//			System.out.println(name);
//		}
	}

}
