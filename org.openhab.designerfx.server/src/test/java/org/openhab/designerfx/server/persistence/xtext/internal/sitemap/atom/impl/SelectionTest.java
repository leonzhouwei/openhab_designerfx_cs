package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.atom.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.atom.impl.Selection;

public class SelectionTest {

	@Test
	public void testParse() {
		final String expected = "Selection item=Scene_General label=\"Scene Selection\" mappings=[0=off, 1=TV, 2=Dinner, 3=Reading]";
		Selection sitemapElement = Selection.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
