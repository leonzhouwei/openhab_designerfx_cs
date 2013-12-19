package org.openhab.designerfx.server.persistence.textfile.internal.parse;

import java.util.Set;

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

import com.google.common.collect.Sets;

public class SitemapElementProperty {
	
//	private static Set<String> types = Sets.newHashSet();
//	static {
//		types.add(ChartPropertiesParser.CHART);
//		types.add(ColorpickerPropertiesParser.COLORPICKER);
//		types.add(FramePropertiesParser.FRAME);
//		types.add(GroupPropertiesParser.GROUP);
//		types.add(ImagePropertiesParser.IMAGE);
//		types.add(ListPropertiesParser.LIST);
//		types.add(SelectionPropertiesParser.SELECTION);
//		types.add(SetpointPropertiesParser.SETPOINT);
//		types.add(SliderPropertiesParser.SLIDER);
//		types.add(SwitchPropertiesParser.SWITCH);
//		types.add(TextPropertiesParser.TEXT);
//		types.add(VideoPropertiesParser.VIDEO);
//		types.add(WebviewPropertiesParser.WEBVIEW);
//	}
	private String name; // should NOT be null or empty
	private String value; // if name is not null or empty, value can be null

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
//		if (!types.contains(name)) {
			sb.append("=");
			sb.append(value);
//		}
		return sb.toString();
	}

}
