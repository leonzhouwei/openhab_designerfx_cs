package org.openhab.designerfx.server.persistence.xtext.internal.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.NodeImpl;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Frame;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Group;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Atom;

import com.google.common.collect.Lists;

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
		NodeImpl rootNode = new NodeImpl();
		rootNode.setAtom(rootAtom);
		Atom childAtom = Group.parse(group);
		NodeImpl childNode = new NodeImpl();
		childNode.setAtom(childAtom);
		rootNode.addChild(childNode);
		final String actual = rootNode.toXtext(indentation);
		assertThat(actual, Matchers.equalTo(expected));
	}
	
	@Test
	public void testFormat() {
		List<String> lines = Lists.newArrayList();
		lines.add("Frame {");
		lines.add("Group item=gFF label=\"First Floor\" icon=\"firstfloor\"");
		lines.add("}");
		NodeImpl.format(lines, 0, lines.size() - 1);
	}
	
	@Test
	public void testParse() {
		final String frame = "Frame {";
		final String group = "Group item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		final String closeure = "}";
		List<String> lines = Lists.newArrayList();
		lines.add(frame);
		lines.add(group);
		lines.add(closeure);
		NodeImpl root = new NodeImpl();
		NodeImpl.parseNode(root, lines, 0, lines.size() - 1);
		final String actual = root.toXtext();
		StringBuilder sb = new StringBuilder();
		sb.append(frame);
		sb.append(Constants.LINE_SEPARATOR);
		sb.append("    ");
		sb.append(group);
		sb.append(Constants.LINE_SEPARATOR);
		sb.append(closeure);
		final String expected = sb.toString();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
