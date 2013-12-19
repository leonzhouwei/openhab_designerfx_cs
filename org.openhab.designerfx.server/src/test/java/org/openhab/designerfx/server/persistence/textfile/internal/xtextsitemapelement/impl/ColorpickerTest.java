package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import org.junit.Test;

public class ColorpickerTest {

	@Test
	public void testParse() {
		String string = "Colorpicker item=RGBLight icon=\"slider\"";
		Colorpicker colorpicker = Colorpicker.parse(string);
		System.out.println(colorpicker.toXtext());
	}

}
