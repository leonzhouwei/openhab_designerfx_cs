package org.openhab.designerfx.server.util;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.ChartPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.ColorpickerPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.FramePropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.GroupPropertiesParser;

import com.google.common.collect.Lists;

public class UtilTest {

	@Test
	public void testCount() {
	}

	@Test
	public void testTrimAndSeparateIngoreCase_1() {
		String string = "SitemapElemetType";
		String[] separators = { 
			"item=",
			"label="
		};
		List<String> expected = Lists.newArrayList("SitemapElemetType");
		List<String> actual = Util.separateTrimmingSpace(string, separators);
		final int size = expected.size();
		for (int i = 0; i < size; ++i) {
			String e = expected.get(i);
			String a = actual.get(i);
			assertThat(a, Matchers.equalTo(e));
		}
	}
	
	@Test
	public void testTrimAndSeparateIngoreCase_2() {
		String string = "Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]";
		List<String> expected = Lists.newArrayList(
				"Chart", 
				"Weather_Chart", 
				"h", 
				"600",
				"[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]"
		);
		List<String> actual = Util.separateTrimmingSpace(string, ChartPropertiesParser.SEPARATORS);
		final int size = expected.size();
		for (int i = 0; i < size; ++i) {
			String e = expected.get(i);
			String a = actual.get(i);
			assertThat(a, Matchers.equalTo(e));
		}
	}
	
	@Test
	public void testTrimAndSeparateIngoreCase_3() {
		String string = "Colorpicker item=RGBLight icon=\"slider\"";
		List<String> expected = Lists.newArrayList(
				"Colorpicker", 
				"RGBLight", 
				"\"slider\""
		);
		List<String> actual = Util.separateTrimmingSpace(string, ColorpickerPropertiesParser.SEPARATORS);
		final int size = expected.size();
		for (int i = 0; i < size; ++i) {
			String e = expected.get(i);
			String a = actual.get(i);
			assertThat(a, Matchers.equalTo(e));
		}
	}
	
	@Test
	public void testTrimAndSeparateIngoreCase_4() {
		String string = "Frame label=\"Weather\"";
		List<String> expected = Lists.newArrayList(
				"Frame", 
				"\"Weather\""
		);
		List<String> actual = Util.separateTrimmingSpace(string, FramePropertiesParser.SEPARATORS);
		final int size = expected.size();
		for (int i = 0; i < size; ++i) {
			String e = expected.get(i);
			String a = actual.get(i);
			assertThat(a, Matchers.equalTo(e));
		}
	}
	
	@Test
	public void testTrimAndSeparateIngoreCase_5() {
		String string = "Group item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		List<String> expected = Lists.newArrayList(
				"Group", 
				"gFF", 
				"\"First Floor\"", 
				"\"firstfloor\""
		);
		List<String> actual = Util.separateTrimmingSpace(string, GroupPropertiesParser.SEPARATORS);
		final int size = expected.size();
		for (int i = 0; i < size; ++i) {
			String e = expected.get(i);
			String a = actual.get(i);
			assertThat(a, Matchers.equalTo(e));
		}
	}

}
