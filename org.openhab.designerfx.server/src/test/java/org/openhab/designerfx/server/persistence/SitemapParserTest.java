package org.openhab.designerfx.server.persistence;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openhab.designerfx.server.BaseTest;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.common.ContextBuilder;
import org.openhab.designerfx.server.util.Util;

public class SitemapParserTest extends BaseTest {

	@Test
	public void test() throws IOException {
		Util.printSeparateLine();
		Context context = ContextBuilder.build();
		final String path = context.getOpenHABHome() + Constants.OPENHAB_SITEMAPS_DIR_RELATIVE_PATH + Constants.FILE_SEPARATOR + "demo" + Constants.SITEMAP_FILE_EXTENSION;
		System.out.println(path);
		File file = new File(path);
		Util.printSeparateLine();
		Sitemap sitemap = SitemapParser.parse(file);
	}

}
