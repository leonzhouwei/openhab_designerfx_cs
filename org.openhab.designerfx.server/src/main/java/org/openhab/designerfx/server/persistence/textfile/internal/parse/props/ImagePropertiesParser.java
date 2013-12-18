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
 * Image [item="<itemname>"] [icon="<iconname>"] url="<url of image>" [label="<labelname>"] [refresh=xxxx]
 * 
 * @author zhouwei
 *
 */
public class ImagePropertiesParser implements SitemapElementPropertiesParser {
	
	public static final String IMAGE = "Image";
	
	private static final String[] SEPARATORS = {
		IMAGE,
		"icon=",
		"item=",
		"label=",
		"refresh=",
		"url="
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
