package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import org.junit.Test;

public class ChartTest {

	@Test
	public void testParse() {
		Chart chart = Chart.parse("Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]");
		System.out.println(chart.toXtext());
	}

}
