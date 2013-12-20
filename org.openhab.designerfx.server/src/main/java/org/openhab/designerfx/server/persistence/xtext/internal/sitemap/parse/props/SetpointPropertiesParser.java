package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.SitemapElementProperty;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.util.Util;

import com.google.common.collect.Sets;

/**
 * 
 * Syntax:
 * Setpoint item="<itemname>" [label="<labelname>"] [icon="<iconname>"] minValue="<min value>" maxValue="<max value>" step="<step value>"
 * 
 * @author zhouwei
 *
 */
public class SetpointPropertiesParser implements SitemapElementPropertiesParser {
	
	public static final String SETPOINT = "Setpoint";

	private static final String[] KEYS = {
		SETPOINT,
		"icon=",
		"item=",
		"label=",
		"maxValue=",
		"minValue=",
		"step="
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
		if (!line.startsWith(SETPOINT)) {
			throw new RuntimeException(line + " is NOT a " + SETPOINT);
		}
		Set<String> keysCopy = keysCopy();
		Map<String, String> map = Util.toMapTrimmingValues(line, keysCopy);
		List<SitemapElementProperty> list = Util.toSitemapElementPropertyList(map, SETPOINT, keysCopy);
		e.addPropertys(list);
	}

}
