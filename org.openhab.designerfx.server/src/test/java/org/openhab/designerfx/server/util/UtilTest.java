package org.openhab.designerfx.server.util;

import org.junit.Test;

public class UtilTest {

	@Test
	public void testCount() {
		System.out.println(Util.count("{{", "{{"));
	}

}
