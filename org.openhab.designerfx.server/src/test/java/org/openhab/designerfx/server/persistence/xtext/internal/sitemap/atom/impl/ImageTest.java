package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.atom.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.atom.impl.Image;

public class ImageTest {

	@Test
	public void testParse() {
		final String expected = "Image url=\"http://localhost:8080/images/splash-ipad-h.png\"";
		Image sitemapElement = Image.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
