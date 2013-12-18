package org.openhab.designerfx.server.persistence.textfile.internal.parse.props;

import java.util.List;

import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;

import com.google.common.collect.Lists;

/**
 * 
 * Syntax:
 * List item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [separator=""]
 * 
 * @author zhouwei
 *
 */
public class ListPropertiesParser implements SitemapElementPropertiesParser {

	public static final String[] SEPARATORS = {
		"icon=",
		"item=",
		"label=",
		"separator=",
		"{"
	};
	
	@Override
	public void parse(SitemapElement e, String line) {
		List<SitemapElementProperty> list = Lists.newArrayList();
		
	}

}
