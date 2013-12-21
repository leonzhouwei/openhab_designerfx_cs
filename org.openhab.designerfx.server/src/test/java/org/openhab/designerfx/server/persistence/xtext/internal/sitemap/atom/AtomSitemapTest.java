package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.atom;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.AtomSitemap;

public class AtomSitemapTest {

	@Test
	public void testParse() {
		final String expected = "sitemap demo label=\"Main Menu\"";
		AtomSitemap sitemap = AtomSitemap.parse(expected);
		String actual = sitemap.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
