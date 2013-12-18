package org.openhab.designerfx.server.util;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.ChartPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.ColorpickerPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.FramePropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.GroupPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.ImagePropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.SelectionPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.SetpointPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.SliderPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.SwitchPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.TextPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.VideoPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.WebviewPropertiesParser;

import com.google.common.collect.Lists;

public class UtilTest {

	@Test
	public void testCount() {
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Chart() {
		String string = "Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]{";
		List<String> expected = Lists.newArrayList(
				"Chart", 
				"Weather_Chart", 
				"h", 
				"600",
				"[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]"
		);
		Map<String, String> map = Util.toMap(string, ChartPropertiesParser.keysCopy());
		Set<Entry<String, String>> set = map.entrySet();
		for (Entry<String, String> entry : set) {
			System.out.println("\"" + entry.getKey() + "\" "  + entry.getValue());
		}
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			assertThat(true, Matchers.equalTo(values.contains(e)));
//		}
	}
	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Colorpicker() {
//		String string = "Colorpicker item=RGBLight icon=\"slider\"";
//		List<String> expected = Lists.newArrayList(
//				"Colorpicker", 
//				"RGBLight", 
//				"\"slider\""
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, ColorpickerPropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Frame() {
//		String string = "Frame label=\"Weather\"";
//		List<String> expected = Lists.newArrayList(
//				"Frame", 
//				"\"Weather\""
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, FramePropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Group() {
//		String string = "Group item=gFF label=\"First Floor\" icon=\"firstfloor\"";
//		List<String> expected = Lists.newArrayList(
//				"Group", 
//				"gFF", 
//				"\"First Floor\"", 
//				"\"firstfloor\""
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, GroupPropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Image() {
//		String string = "Image url=\"http://localhost:8080/images/splash-ipad-h.png\"";
//		List<String> expected = Lists.newArrayList(
//				"Image", 
//				"\"http://localhost:8080/images/splash-ipad-h.png\""
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, ImagePropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_List() {
//		String string = "List item=itemname label=\"labelname\" icon=\"iconname\"";
//		List<String> expected = Lists.newArrayList(
//				"List", 
//				"itemname",
//				"\"labelname\"",
//				"\"iconname\""
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, ImagePropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Selection() {
//		String string = "Selection item=Scene_General label=\"Scene Selection\" mappings=[0=off, 1=TV, 2=Dinner, 3=Reading]";
//		List<String> expected = Lists.newArrayList(
//				"Selection", 
//				"Scene_General",
//				"\"Scene Selection\"",
//				"[0=off, 1=TV, 2=Dinner, 3=Reading]"
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, SelectionPropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Setpoint() {
//		String string = "Setpoint item=Temperature_Setpoint minValue=16 maxValue=28 step=0.5";
//		List<String> expected = Lists.newArrayList(
//				"Setpoint", 
//				"Temperature_Setpoint",
//				"16",
//				"28",
//				"0.5"
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, SetpointPropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Slider() {
//		String string = "Slider item=DimmedLight switchSupport";
//		List<String> expected = Lists.newArrayList(
//				"Slider", 
//				"DimmedLight"
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, SliderPropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Switch() {
//		String string = "Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\", 1=\"Day\", 2=\"Week\"]";
//		List<String> expected = Lists.newArrayList(
//				"Switch", 
//				"Weather_Chart_Period",
//				"\"Chart Period\"",
//				"[0=\"Hour\", 1=\"Day\", 2=\"Week\"]"
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, SwitchPropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Text() {
//		String string = "Text label=\"http://www.openHAB.org\" icon=\"icon\"";
//		List<String> expected = Lists.newArrayList(
//				"Text", 
//				"\"http://www.openHAB.org\"",
//				"\"icon\""
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, TextPropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Video() {
//		String string = "Video url=\"http://demo.openhab.org/Hue.m4v\"";
//		List<String> expected = Lists.newArrayList(
//				"Video", 
//				"\"http://demo.openhab.org/Hue.m4v\""
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, VideoPropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}
//	
//	@Test
//	public void testTrimAndSeparateIngoreCase_Webview() {
//		String string = "Webview url=\"http://heise-online.mobi/\" height=8";
//		List<String> expected = Lists.newArrayList(
//				"Webview", 
//				"\"http://heise-online.mobi/\"",
//				"8"
//		);
//		List<String> actual = Util.separateTrimmingSpace(string, WebviewPropertiesParser.SEPARATORS);
//		final int size = expected.size();
//		for (int i = 0; i < size; ++i) {
//			String e = expected.get(i);
//			String a = actual.get(i);
//			assertThat(a, Matchers.equalTo(e));
//		}
//	}

}
