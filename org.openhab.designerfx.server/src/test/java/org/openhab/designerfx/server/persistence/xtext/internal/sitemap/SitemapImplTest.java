package org.openhab.designerfx.server.persistence.xtext.internal.sitemap;

import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.NodeImpl;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Frame;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Group;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Atom;

public class SitemapImplTest {

	@Test
	public void test() {
		final String name = "demo";
		final String label = "\"Main Menu\"";
		final String frame = "Frame label=\"aFrame\"";
		final String group = "Group item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		//
		SitemapImpl sitemap = new SitemapImpl();
		sitemap.setName(name);
		sitemap.setLabel(label);
		Atom rootAtom = Frame.parse(frame);
		NodeImpl rootNode = new NodeImpl(rootAtom);
		Atom childAtom = Group.parse(group);
		NodeImpl childNode = new NodeImpl(childAtom);
		rootNode.addChild(childNode);
		//
		sitemap.setRoot(rootNode);
		//
		System.out.println(sitemap.toXtext());
	}

}
