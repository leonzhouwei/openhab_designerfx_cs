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
 * Switch item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [mappings="<mapping definition>"]
 * 
 * @author zhouwei
 *
 */
public class SwitchPropertiesParser implements SitemapElementPropertiesParser {

	public static final String SWITCH = "Switch";

	private static final String[] KEYS = {
		SWITCH,
		"icon=",
		"item=",
		"label=",
		"mappings="
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
		if (!line.startsWith(SWITCH)) {
			throw new RuntimeException(line + " is NOT a " + SWITCH);
		}
		Set<String> keysCopy = keysCopy();
		Map<String, String> map = Util.toMapTrimmingValues(line, keysCopy);
		List<Property> list = Util.toSitemapElementPropertyList(map, SWITCH, keysCopy);
		e.addPropertys(list);
	}

}
