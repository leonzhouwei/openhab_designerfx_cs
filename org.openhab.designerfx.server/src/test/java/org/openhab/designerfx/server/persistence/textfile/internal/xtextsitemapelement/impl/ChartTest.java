package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class ChartTest {

	@Test
	public void testParse() {
		final String expected = "Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]";
		Chart chart = Chart.parse(expected);
		String actual = chart.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
