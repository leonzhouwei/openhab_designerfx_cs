package org.openhab.designerfx.server.persistence.textfile.internal.parse.props;

import java.util.List;

import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;

import com.google.common.collect.Lists;

/**
 * 
 * Syntax:
 * Setpoint item="<itemname>" [label="<labelname>"] [icon="<iconname>"] minValue="<min value>" maxValue="<max value>" step="<step value>"
 * 
 * @author zhouwei
 *
 */
public class SetpointPropertiesParser implements SitemapElementPropertiesParser {

	public static final String[] SEPARATORS = {
		"icon=",
		"item=",
		"label=",
		"maxValue=",
		"minValue=",
		"step="
	};
	
	@Override
	public void parse(SitemapElement e, String line) {
		List<SitemapElementProperty> list = Lists.newArrayList();
		
	}

}
