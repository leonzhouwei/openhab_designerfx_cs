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
 * Video item="<itemname>"  [icon="<iconname>"] url="<url of video to embed>"
 * 
 * @author zhouwei
 *
 */
public class VideoPropertiesParser implements SitemapElementPropertiesParser {

	public static final String VIDEO = "Video";

	private static final String[] KEYS = {
		VIDEO,
		"icon=",
		"item=",
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
	public void parse(SitemapElement e, String line) {
		List<SitemapElementProperty> list = Lists.newArrayList();
		
	}

}
