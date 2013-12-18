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
 * Switch item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [mappings="<mapping definition>"]
 * 
 * @author zhouwei
 *
 */
public class SwitchPropertiesParser implements SitemapElementPropertiesParser {

	public static final String SWITCH = "Switch";

	private static final String[] SEPARATORS = {
		SWITCH,
		"icon=",
		"item=",
		"label=",
		"mappings="
	};

	public static Set<String> keysCopy() {
		Set<String> keys = Sets.newHashSet();
		for (String key : SEPARATORS) {
			keys.add(key);
		}
		return keys;
	}
	
	@Override
	public void parse(SitemapElement e, String line) {
		List<SitemapElementProperty> list = Lists.newArrayList();
	}

}
