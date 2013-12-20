package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.impl.Video;

public class VideoTest {

	@Test
	public void testParse() {
		final String expected = "Video url=\"http://demo.openhab.org/Hue.m4v\"";
		Video sitemapElement = Video.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
