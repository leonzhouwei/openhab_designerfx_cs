package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.impl.Setpoint;

public class SetpointTest {

	@Test
	public void testParse() {
		final String expected = "Setpoint item=Temperature_Setpoint minValue=16 maxValue=28 step=0.5";
		Setpoint sitemapElement = Setpoint.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
