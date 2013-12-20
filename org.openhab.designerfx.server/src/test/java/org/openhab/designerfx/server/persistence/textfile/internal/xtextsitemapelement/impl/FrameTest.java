package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.impl.Frame;

public class FrameTest {

	@Test
	public void testParse() {
		final String expected = "Frame label=\"Weather\"";
		Frame sitemapElement = Frame.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
