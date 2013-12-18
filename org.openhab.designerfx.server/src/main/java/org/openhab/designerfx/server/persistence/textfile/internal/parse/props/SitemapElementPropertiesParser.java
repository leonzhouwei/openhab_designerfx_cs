package org.openhab.designerfx.server.persistence.textfile.internal.parse.props;

import java.util.List;

import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;

public interface SitemapElementPropertiesParser {
	
	public List<SitemapElementProperty> parse(String type, String props);
	
}
