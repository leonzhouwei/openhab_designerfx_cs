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
 * Frame [label="<labelname>"] [icon="<icon>"] [item="<item">]
 * 
 * @author zhouwei
 *
 */
public class FramePropertiesParser implements SitemapElementPropertiesParser {
	
	public static final String FRAME = "Frame";
	
	private static final String[] KEYS = {
		FRAME,
		"icon=", 
		"item=",
		"label="
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
		if (!line.startsWith(FRAME)) {
			throw new RuntimeException(line + " is NOT a " + FRAME);
		}
		Set<String> keysCopy = keysCopy();
		Map<String, String> map = Util.toMapTrimmingValues(line, keysCopy);
		List<Property> list = Util.toSitemapElementPropertyList(map, FRAME, keysCopy);
		e.addPropertys(list);
	}

}
