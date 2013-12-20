package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.impl.Switch;

public class SwitchTest {

	@Test
	public void testParse() {
		final String expected = "Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\", 1=\"Day\", 2=\"Week\"]";
		Switch sitemapElement = Switch.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
