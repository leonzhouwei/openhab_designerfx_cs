package org.openhab.designerfx.server.persistence.textfile.internal.parse.props;

import java.util.Set;

import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;

import com.google.common.collect.Sets;

/**
 * 
 * Syntax:
 * Chart [item="<itemname>"] [icon="<iconname>"] [label="<labelname>"] [service="<service>"] [period=xxxx] [refresh=xxxx] [visibility=xxxx]
 * 
 * @author zhouwei
 *
 */
public class ChartPropertiesParser implements SitemapElementPropertiesParser {
	
	public static final String CHART = "Chart";
	
	private static final String[] SEPARATORS = {
		CHART,
		"icon=",
		"item=",
		"label=",
		"period=",
		"refresh=",
		"service=",
		"visibility="
	};
	
	public static Set<String> keysCopy() {
		Set<String> keys = Sets.newHashSet();
		for (String key : SEPARATORS) {
			keys.add(key);
		}
		return keys;
	}

	@Override
	public void parse(SitemapElement e, String formattedLine) {
		e.clearProperties();
		formattedLine = formattedLine.trim();
		final String type = formattedLine.split("\\s")[0].trim(); 
		if (type.compareToIgnoreCase(CHART) != 0) {
			throw new RuntimeException(formattedLine + " is NOT a " + CHART);
		}
		SitemapElementProperty prop = new SitemapElementProperty();
		prop.setName(CHART);
		prop.setValue(CHART);
		String propsString = formattedLine.substring(type.length(), type.length()).trim();
	}

}
