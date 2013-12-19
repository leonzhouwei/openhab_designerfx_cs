package org.openhab.designerfx.server.persistence.textfile.internal.parse.props;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;
import org.openhab.designerfx.server.util.Util;

import com.google.common.collect.Sets;

/**
 * 
 * Syntax:
 * List item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [separator=""]
 * 
 * @author zhouwei
 *
 */
public class ListPropertiesParser implements SitemapElementPropertiesParser {

	public static final String LIST = "List";
	
	private static final String[] KEYS = {
		LIST,
		"icon=",
		"item=",
		"label=",
		"separator="
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
		if (!line.startsWith(LIST)) {
			throw new RuntimeException(line + " is NOT a " + LIST);
		}
		Set<String> keysCopy = keysCopy();
		Map<String, String> map = Util.toMapTrimmingValues(line, keysCopy);
		List<SitemapElementProperty> list = Util.toSitemapElementPropertyList(map, LIST, keysCopy);
		e.addPropertys(list);
	}

}
