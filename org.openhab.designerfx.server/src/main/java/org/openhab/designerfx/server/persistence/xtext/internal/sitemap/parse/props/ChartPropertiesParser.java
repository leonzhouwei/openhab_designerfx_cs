package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.Property;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.util.Util;

import com.google.common.collect.Sets;

/**
 * 
 * Syntax:
 * Chart [item="<itemname>"] [icon="<iconname>"] [label="<labelname>"] [service="<service>"] [period=xxxx] [refresh=xxxx] [visibility=xxxx]
 * 
 * @author zhouwei
 *
 */
public class ChartPropertiesParser implements SitemapElementPropertiesParser {
	
	public static final String CHART = "Chart";
	
	private static final String[] KEYS = {
		CHART,
		"icon=",
		"item=",
		"label=",
		"period=",
		"refresh=",
		"service=",
		"visibility="
	};
	
	public static Set<String> keysCopy() {
		Set<String> keys = Sets.newHashSet();
		for (String key : KEYS) {
			keys.add(key);
		}
		return keys;
	}

	@Override
	public void parseAndFill(SitemapElement e, String line) {
		line = line.replaceAll("\\{", "").trim();
		e.clearProperties();
		if (!line.startsWith(CHART)) {
			throw new RuntimeException(line + " is NOT a " + CHART);
		}
		Set<String> keysCopy = keysCopy();
		Map<String, String> map = Util.toMapTrimmingValues(line, keysCopy);
		List<Property> list = Util.toSitemapElementPropertyList(map, CHART, keysCopy);
		e.addPropertys(list);
	}

}
