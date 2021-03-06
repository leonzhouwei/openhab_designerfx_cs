package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.atom;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Slider;

public class SliderTest {

	@Test
	public void testParse() {
		final String expected = "Slider item=DimmedLight switchSupport";
		Slider sitemapElement = Slider.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
