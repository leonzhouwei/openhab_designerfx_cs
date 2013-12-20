package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node;

import org.junit.Test;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Frame;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Group;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Atom;

public class NodeImplTest {

	@Test
	public void testToXtext() {
		Atom rootAtom = Frame.parse("Frame label=\"aFrame\"");
		NodeImpl rootNode = new NodeImpl(rootAtom);
		Atom childAtom = Group.parse("Group item=gFF label=\"First Floor\" icon=\"firstfloor\"");
		NodeImpl childNode = new NodeImpl(childAtom);
		rootNode.addChild(childNode);
		System.out.println(rootNode.toXtext("\t"));
	}

}
