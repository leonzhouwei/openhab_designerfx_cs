package org.openhab.designerfx.server.persistence.textfile.internal.parse.props;

import java.util.List;
import java.util.Set;

import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 
 * Syntax:
 * Text item="<itemname>" [label="<labelname>"] [icon="<iconname>"]
 * 
 * @author zhouwei
 *
 */
public class TextPropertiesParser implements SitemapElementPropertiesParser {

	public static final String TEXT = "Text";

	private static final String[] KEYS = {
		TEXT,
		"icon=",
		"item=",
		"label=",
		"valuecolor="
	};

	public static Set<String> keysCopy() {
		Set<String> keys = Sets.newHashSet();
		for (String key : KEYS) {
			keys.add(key);
		}
		return keys;
	}
	
	@Override
	public void parse(SitemapElement e, String line) {
		line = line.replaceAll("\\{", "");
		List<SitemapElementProperty> list = Lists.newArrayList();
		
	}

}
