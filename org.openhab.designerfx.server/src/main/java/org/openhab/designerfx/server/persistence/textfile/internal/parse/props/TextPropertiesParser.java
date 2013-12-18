package org.openhab.designerfx.server.persistence.textfile.internal.parse.props;

import java.util.List;

import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;

import com.google.common.collect.Lists;

/**
 * 
 * Syntax:
 * Text item="<itemname>" [label="<labelname>"] [icon="<iconname>"]
 * 
 * @author zhouwei
 *
 */
public class TextPropertiesParser implements SitemapElementPropertiesParser {

	public static final String[] SEPARATORS = {
		"icon=",
		"item=",
		"lablel="
	};
	
	@Override
	public void parse(SitemapElement e, String line) {
		List<SitemapElementProperty> list = Lists.newArrayList();
		
	}

}
