package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.props;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.Property;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.persistence.xtext.internal.util.Util;

import com.google.common.collect.Sets;

/**
 * 
 * Syntax:
 * Image [item="<itemname>"] [icon="<iconname>"] url="<url of image>" [label="<labelname>"] [refresh=IMAGE]
 * 
 * @author zhouwei
 *
 */
public class ImagePropertiesParser implements SitemapElementPropertiesParser {
	
	public static final String IMAGE = "Image";
	
	private static final String[] KEYS = {
		IMAGE,
		"icon=",
		"item=",
		"label=",
		"refresh=",
		"url="
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
		if (!line.startsWith(IMAGE)) {
			throw new RuntimeException(line + " is NOT a " + IMAGE);
		}
		Set<String> keysCopy = keysCopy();
		Map<String, String> map = Util.toMapTrimmingValues(line, keysCopy);
		List<Property> list = Util.toSitemapElementPropertyList(map, IMAGE, keysCopy);
		e.addPropertys(list);
	}

}
