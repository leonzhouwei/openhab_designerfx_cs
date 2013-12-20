package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.impl.List;

public class ListTest {

	@Test
	public void testParse() {
		final String expected = "List item=itemname label=\"labelname\" icon=\"iconname\" separator=\"separatorname\"";
		List sitemapElement = List.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
