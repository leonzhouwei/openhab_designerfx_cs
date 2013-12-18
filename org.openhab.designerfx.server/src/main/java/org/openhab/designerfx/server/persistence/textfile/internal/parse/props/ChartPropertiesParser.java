package org.openhab.designerfx.server.persistence.textfile.internal.parse.props;

import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElement;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementPropertiesParser;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;

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
	public static final String[] SEPARATORS = {
		"icon=",
		"item=",
		"label=",
		"period=",
		"refresh=",
		"service=",
		"visibility="
	};

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
