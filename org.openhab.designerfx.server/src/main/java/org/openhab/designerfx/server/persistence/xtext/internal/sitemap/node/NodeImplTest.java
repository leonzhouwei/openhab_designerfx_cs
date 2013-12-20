package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Frame;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Group;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Atom;

public class NodeImplTest {

	@Test
	public void testToXtext() {
		final String frame = "Frame label=\"aFrame\"";
		final String group = "Group item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		final String indentation = "    ";
		StringBuilder sb = new StringBuilder();
		sb.append(indentation);
		sb.append(frame);
		sb.append(" {");
		sb.append(Constants.LINE_SEPARATOR);
		sb.append(indentation);
		sb.append(indentation);
		sb.append(group);
		sb.append(Constants.LINE_SEPARATOR);
		sb.append(indentation);
		sb.append("}");
		final String expected = sb.toString();
		Atom rootAtom = Frame.parse(frame);
		NodeImpl rootNode = new NodeImpl(rootAtom);
		Atom childAtom = Group.parse(group);
		NodeImpl childNode = new NodeImpl(childAtom);
		rootNode.addChild(childNode);
		final String actual = rootNode.toXtext(indentation);
		assertThat(actual, Matchers.equalTo(expected));
	}

}
