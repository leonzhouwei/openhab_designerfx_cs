package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openhab.designerfx.server.persistence.xtext.Sitemap;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.ChartPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.ColorpickerPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.FramePropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.GroupPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.ImagePropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.ListPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.SelectionPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.SetpointPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.SliderPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.SwitchPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.TextPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.VideoPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props.WebviewPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.util.Util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SitemapParser {
	
	private static final String SITEMAP = "sitemap";
	private static Map<String, SitemapElementPropertiesParser> typeAndPropsParsers = Maps.newHashMap();
	static {
		typeAndPropsParsers.put(ChartPropertiesParser.CHART, new ChartPropertiesParser());
		typeAndPropsParsers.put(ColorpickerPropertiesParser.COLORPICKER, new ColorpickerPropertiesParser());
		typeAndPropsParsers.put(FramePropertiesParser.FRAME, new FramePropertiesParser());
		typeAndPropsParsers.put(GroupPropertiesParser.GROUP, new GroupPropertiesParser());
		typeAndPropsParsers.put(ImagePropertiesParser.IMAGE, new ImagePropertiesParser());
		typeAndPropsParsers.put(ListPropertiesParser.LIST, new ListPropertiesParser());
		typeAndPropsParsers.put(SelectionPropertiesParser.SELECTION, new SelectionPropertiesParser());
		typeAndPropsParsers.put(SetpointPropertiesParser.SETPOINT, new SetpointPropertiesParser());
		typeAndPropsParsers.put(SliderPropertiesParser.SLIDER, new SliderPropertiesParser());
		typeAndPropsParsers.put(SwitchPropertiesParser.SWITCH, new SwitchPropertiesParser());
		typeAndPropsParsers.put(TextPropertiesParser.TEXT, new TextPropertiesParser());
		typeAndPropsParsers.put(VideoPropertiesParser.VIDEO, new VideoPropertiesParser());
		typeAndPropsParsers.put(WebviewPropertiesParser.WEBVIEW, new WebviewPropertiesParser());
	}
	
	public static Sitemap parse(File file) throws IOException {
		List<String> lines = Util.readAllTrimEmptyLines(file);
		if (lines.isEmpty() || !lines.get(0).startsWith(SITEMAP)) {
			throw new RuntimeException("Invalid sitemap file (" + file.getPath() + ")");
		}
		format(lines);
		print(lines);
		return doParse(lines);
	}
	
	private static Sitemap doParse(List<String> lines) {
		Sitemap sitemap = new Sitemap();
		// parse the head part (e.g. sitemap demo label="Main Menu")
		String line = lines.get(0);
		String temp = line.substring(SITEMAP.length(), line.length()).trim();
		String name = temp.split("\\s")[0].trim();
		sitemap.setName(name);
		if (!temp.endsWith(name)) {
			String label = temp.substring(name.length(), temp.length()).trim();
			sitemap.setLabel(label.split("=")[1].trim());
		}
		SitemapElement root = new SitemapElement();
		parseSitemapElement(root, lines, 1);
		return sitemap;
	}
	
	private static int parseSitemapElement(SitemapElement empty, List<String> lines, final int startLine) {
		int endLine = -1;
		final int size = lines.size();
		for (int i = startLine; i < size;) {
			int step = 1;
			String line = lines.get(i).trim();
			SitemapElementPropertiesParser sepp = findPropertiesParser(line);
			sepp.parseAndFill(empty, line);
			if (line.endsWith("{")) {
				SitemapElement child = new SitemapElement();
				step = parseSitemapElement(child, lines, i) - i;
				empty.addChild(child);
			}
			if (line.startsWith("}")) {
				endLine = i;
				break;
			}
			SitemapElement child = new SitemapElement();
			parseSitemapElement(child, lines, i);
			empty.addChild(child);
			i += step;
		}
		return endLine;
	}
	
	private static SitemapElementPropertiesParser findPropertiesParser(String startLine) {
		SitemapElementPropertiesParser sepp = null;
		Iterator<String> iterator = typeAndPropsParsers.keySet().iterator();
		while (iterator.hasNext()) {
			String type = iterator.next();
			if (startLine.trim().startsWith(type)) {
				sepp = typeAndPropsParsers.get(type);
				break;
			}
		}
		return sepp;
	}
	
	private static void format(List<String> lines) throws RuntimeException {
		final int size = lines.size();
		List<String> formatted = Lists.newArrayList();
		for (int i = 0; i < size; ++i) {
			String line = lines.get(i).trim();
			if (Util.count(line, "{") > 1) {
				throw new RuntimeException("More than 1 '{' found in '" + line + "'");
			}
			if (Util.count(line, "}") > 1) {
				throw new RuntimeException("More than 1 '}' found in '" + line + "'");
			}
			if (line.startsWith("{")) {
				final int z = formatted.size() - 1;
				formatted.set(z, formatted.get(z) + " {");
				if (line.length() > 1) {
					formatted.add(line.substring(line.indexOf("{") + 1, line.length()).trim());
				}
			} else if (line.length() > 1 && line.matches(".*\\}.*")) {
				final int z = line.indexOf("}");
				formatted.add(line.substring(0, z).trim());
				formatted.add("}");
				if (line.length() -1 > z) {
					formatted.add(line.substring(z + 1, line.length()).trim());
				}
			} else {
				formatted.add(line);
			}
		}
		lines.clear();
		lines.addAll(formatted);
	}
	
	private static void print(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}
	
}
