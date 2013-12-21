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

//	@Test
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
	
//	@Test
	public void testFormat() {
		List<String> lines = Lists.newArrayList();
		lines.add("Frame label=\"Weather\" {");
		lines.add("    Text item=Weather_Temperature valuecolor=[Weather_LastUpdate==\"Uninitialized\"=\"lightgray\",Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"] {");
		lines.add("        Frame {");
		lines.add("            Text item=Weather_Temp_Max valuecolor=[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]");
		lines.add("                Text item=Weather_Temp_Min valuecolor=[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]");
		lines.add("                Text item=Weather_LastUpdate visibility=[Weather_LastUpdate>30] valuecolor=[Weather_LastUpdate>120=\"orange\", Weather_LastUpdate>300=\"red\"]");
		lines.add("        }");
		lines.add("        Frame {");
		lines.add("            Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\", 1=\"Day\", 2=\"Week\"]");
		lines.add("            Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]");
		lines.add("            Chart item=Weather_Chart period=D refresh=3600 visibility=[Weather_Chart_Period==1]");
		lines.add("            Chart item=Weather_Chart period=W refresh=3600 visibility=[Weather_Chart_Period==2]");
		lines.add("        }");
		lines.add("    }");
		lines.add("}");
		NodeImpl.format(lines);
		for (String line : lines) {
			System.out.println(line);
		}
	}
	
//	@Test
	public void testParseNode() {
		final String frame = "Frame {";
		final String group = "Group item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		final String closeure = "}";
		List<String> lines = Lists.newArrayList();
		lines.add(frame);
		lines.add(group);
		lines.add(closeure);
		NodeImpl root = new NodeImpl();
		NodeImpl.parseNode(root, lines, 0);
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
	
//	@Test
	public void testParse_1() {
		List<String> lines = Lists.newArrayList();
		lines.add("Frame {");
		lines.add("    Group item=gFF label=\"First Floor\" icon=\"firstfloor\"");
		lines.add("    Group item=gGF label=\"Ground Floor\" icon=\"groundfloor\"");
		lines.add("    Group item=gC label=\"Cellar\" icon=\"cellar\"");
		lines.add("    Group item=Outdoor icon=\"garden\"");
		lines.add("}");
		NodeImpl node = NodeImpl.parse(lines);
		StringBuilder sb = new StringBuilder();
		for (String line : lines) {
			sb.append(line);
			sb.append(Constants.LINE_SEPARATOR);
		}
		final String expected = sb.toString().trim();
		final String actual = node.toXtext().trim();
		assertThat(actual, Matchers.equalTo(expected));
	}
	
//	@Test
	public void testParse_2() {
		List<String> lines = Lists.newArrayList();
		lines.add("Frame label=\"Weather\" {");
		lines.add("    Text item=Weather_Temperature valuecolor=[Weather_LastUpdate==\"Uninitialized\"=\"lightgray\",Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"] {");
		lines.add("        Frame {");
		lines.add("            Text item=Weather_Temp_Max valuecolor=[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]");
		lines.add("            Text item=Weather_Temp_Min valuecolor=[>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]");
		lines.add("            Text item=Weather_LastUpdate visibility=[Weather_LastUpdate>30] valuecolor=[Weather_LastUpdate>120=\"orange\", Weather_LastUpdate>300=\"red\"]");
		lines.add("        }");
		lines.add("        Frame {");
		lines.add("            Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\", 1=\"Day\", 2=\"Week\"]");
		lines.add("            Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]");
		lines.add("            Chart item=Weather_Chart period=D refresh=3600 visibility=[Weather_Chart_Period==1]");
		lines.add("            Chart item=Weather_Chart period=W refresh=3600 visibility=[Weather_Chart_Period==2]");
		lines.add("        }");
		lines.add("    }");
		lines.add("}");
		NodeImpl node = NodeImpl.parse(lines);
		StringBuilder sb = new StringBuilder();
		for (String line : lines) {
			sb.append(line);
			sb.append(Constants.LINE_SEPARATOR);
		}
		final String expected = sb.toString().trim();
		final String actual = node.toXtext().trim();
		assertThat(actual, Matchers.equalTo(expected));
	}
	
	@Test
	public void testParse_Sitemap() {
		List<String> lines = Lists.newArrayList();
		lines.add("sitemap demo label=\"Main Menu\" {");
		lines.add("    Frame {");
		lines.add("        Group item=gFF label=\"First Floor\" icon=\"firstfloor\"");
		lines.add("        Group item=gGF label=\"Ground Floor\" icon=\"groundfloor\"");
		lines.add("        Group item=gC label=\"Cellar\" icon=\"cellar\"");
		lines.add("        Group item=Outdoor icon=\"garden\"");
		lines.add("    }");
		lines.add("}");
		NodeImpl node = NodeImpl.parse(lines);
		StringBuilder sb = new StringBuilder();
		for (String line : lines) {
			sb.append(line);
			sb.append(Constants.LINE_SEPARATOR);
		}
		final String expected = sb.toString().trim();
		final String actual = node.toXtext().trim();
		assertThat(actual, Matchers.equalTo(expected));
	}
	
}
