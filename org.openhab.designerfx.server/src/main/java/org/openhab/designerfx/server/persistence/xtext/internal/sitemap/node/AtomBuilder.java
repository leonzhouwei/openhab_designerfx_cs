package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node;

import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Chart;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Colorpicker;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Frame;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Group;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Image;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.List;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Selection;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Setpoint;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Slider;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Switch;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Text;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Video;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.Webview;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Atom;

public class AtomBuilder {
	
	public static Atom build(String line) {
		line = line.trim();
		Atom atom = null;
		if (line.startsWith(Chart.TYPE)) {
			atom = Chart.parse(line);
		} else if (line.startsWith(Colorpicker.TYPE)) {
			atom = Colorpicker.parse(line);
		} else if (line.startsWith(Frame.TYPE)) {
			atom = Frame.parse(line);
		} else if (line.startsWith(Group.TYPE)) {
			atom = Group.parse(line);
		} else if (line.startsWith(Image.TYPE)) {
			atom = Image.parse(line);
		} else if (line.startsWith(List.TYPE)) {
			atom = List.parse(line);
		} else if (line.startsWith(Selection.TYPE)) {
			atom = Selection.parse(line);
		} else if (line.startsWith(Setpoint.TYPE)) {
			atom = Setpoint.parse(line);
		} else if (line.startsWith(Slider.TYPE)) {
			atom = Slider.parse(line);
		} else if (line.startsWith(Switch.TYPE)) {
			atom = Switch.parse(line);
		} else if (line.startsWith(Text.TYPE)) {
			atom = Text.parse(line);
		} else if (line.startsWith(Video.TYPE)) {
			atom = Video.parse(line);
		} else if (line.startsWith(Webview.TYPE)) {
			atom = Webview.parse(line);
		} else {
			atom = null;
		}
		return atom;
	}
	
}
