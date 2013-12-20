package org.openhab.designerfx.server.persistence.textfile;

import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.impl.Frame;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.impl.Group;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Sitemap;

public class SitemapTest {

	@Test
	public void test() {
		Sitemap sitemap = new Sitemap();
		sitemap.setLabel("Main Menu");
		sitemap.setName("demo");
		Frame root = Frame.parse("Frame {");
		Group group = Group.parse("Group item=gFF label=\"First Floor\" icon=\"firstfloor\"");
		root.addChild(group);
		sitemap.setRoot(root);
		System.out.println(sitemap.toXtext());
	}

}