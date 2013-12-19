package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class TextTest {

	@Test
	public void testParse() {
		final String expected = "Text item=Weather_Temp_Max valuecolor=[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]";
		Text sitemapElement = Text.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
