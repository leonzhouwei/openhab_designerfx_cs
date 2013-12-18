package org.openhab.designerfx.server.util;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Iterator;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.ChartPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.ColorpickerPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.FramePropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.GroupPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.ImagePropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.ListPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.SelectionPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.SetpointPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.SliderPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.SwitchPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.TextPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.VideoPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.props.WebviewPropertiesParser;

import com.google.common.collect.Maps;

public class UtilTest {

	@Test
	public void testCount() {
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Chart() {
		String string = "Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Chart", "");
		expected.put("item=", "Weather_Chart");
		expected.put("period=", "h");
		expected.put("refresh=", "600");
		expected.put("visibility=",
				"[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				ChartPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Colorpicker() {
		String string = "Colorpicker item=RGBLight icon=\"slider\"";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Colorpicker", "");
		expected.put("item=", "RGBLight");
		expected.put("icon=", "\"slider\"");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				ColorpickerPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Frame() {
		String string = "Frame label=\"Weather\"";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Frame", "");
		expected.put("label=", "\"Weather\"");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				FramePropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Group() {
		String string = "Group item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Group", "");
		expected.put("item=", "gFF");
		expected.put("label=", "\"First Floor\"");
		expected.put("icon=", "\"firstfloor\"");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				GroupPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Image() {
		String string = "Image url=\"http://localhost:8080/images/splash-ipad-h.png\"";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Image", "");
		expected.put("url=",
				"\"http://localhost:8080/images/splash-ipad-h.png\"");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				ImagePropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_List() {
		String string = "List item=itemname label=\"labelname\" icon=\"iconname\" separator=\"separatorname\"";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("List", "");
		expected.put("item=", "itemname");
		expected.put("label=", "\"labelname\"");
		expected.put("icon=", "\"iconname\"");
		expected.put("separator=", "\"separatorname\"");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				ListPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Selection() {
		String string = "Selection item=Scene_General label=\"Scene Selection\" mappings=[0=off, 1=TV, 2=Dinner, 3=Reading]";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Selection", "");
		expected.put("item=", "Scene_General");
		expected.put("label=", "\"Scene Selection\"");
		expected.put("mappings=", "[0=off, 1=TV, 2=Dinner, 3=Reading]");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				SelectionPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Setpoint() {
		String string = "Setpoint item=Temperature_Setpoint minValue=16 maxValue=28 step=0.5";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Setpoint", "");
		expected.put("item=", "Temperature_Setpoint");
		expected.put("minValue=", "16");
		expected.put("maxValue=", "28");
		expected.put("step=", "0.5");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				SetpointPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Slider() {
		String string = "Slider item=DimmedLight switchSupport";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Slider", "");
		expected.put("item=", "DimmedLight");
		expected.put("switchSupport", "");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				SliderPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Switch() {
		String string = "Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\", 1=\"Day\", 2=\"Week\"]";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Switch", "");
		expected.put("item=", "Weather_Chart_Period");
		expected.put("label=", "\"Chart Period\"");
		expected.put("mappings=", "[0=\"Hour\", 1=\"Day\", 2=\"Week\"]");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				SwitchPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Text() {
		String string = "Text item=Weather_Temp_Max valuecolor=[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Text", "");
		expected.put("item=", "Weather_Temp_Max");
		expected.put("valuecolor=",
				"[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				TextPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Video() {
		String string = "Video url=\"http://demo.openhab.org/Hue.m4v\"";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Video", "");
		expected.put("url=", "\"http://demo.openhab.org/Hue.m4v\"");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				VideoPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

	@Test
	public void testTrimAndSeparateIngoreCase_Webview() {
		String string = "Webview url=\"http://heise-online.mobi/\" height=8";
		Map<String, String> expected = Maps.newHashMap();
		expected.put("Webview", "");
		expected.put("url=", "\"http://heise-online.mobi/\"");
		expected.put("height=", "8");
		// testing
		Map<String, String> actual = Util.toMapTrimmingValues(string,
				WebviewPropertiesParser.keysCopy());
		Iterator<String> it = expected.keySet().iterator();
		while (it.hasNext()) {
			final String key = it.next();
			assertThat(actual.get(key), Matchers.equalTo(expected.get(key)));
		}
	}

}
