package org.openhab.designerfx.server.persistence.textfile.internal.parse.props;

import java.util.List;

import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;

import com.google.common.collect.Lists;

/**
 * 
 * Syntax:
 * Image [item="<itemname>"] [icon="<iconname>"] url="<url of image>" [label="<labelname>"] [refresh=xxxx]
 * 
 * @author zhouwei
 *
 */
public class ImagePropertiesParser implements SitemapElementPropertiesParser {
	
	public static final String[] SEPARATORS = {
		"icon=",
		"item=",
		"label=",
		"refresh=",
		"url=",
		"{"
	};

	@Override
	public void parse(SitemapElement e, String line) {
		List<SitemapElementProperty> list = Lists.newArrayList();
		
	}

}
