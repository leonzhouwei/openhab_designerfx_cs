package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.atom.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.atom.impl.Webview;

public class WebviewTest {

	@Test
	public void testParse() {
		final String expected = "Webview url=\"http://heise-online.mobi/\" height=8";
		Webview sitemapElement = Webview.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
