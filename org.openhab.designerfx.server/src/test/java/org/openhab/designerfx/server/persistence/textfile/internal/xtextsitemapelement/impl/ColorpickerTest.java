package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.impl.Colorpicker;

public class ColorpickerTest {

	@Test
	public void testParse() {
		final String expected = "Colorpicker item=RGBLight icon=\"slider\"";
		Colorpicker sitemapElement = Colorpicker.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
