package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.atom;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Colorpicker;

public class ColorpickerTest {

	@Test
	public void testParse() {
		final String expected = "Colorpicker item=RGBLight icon=\"slider\"";
		Colorpicker sitemapElement = Colorpicker.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
