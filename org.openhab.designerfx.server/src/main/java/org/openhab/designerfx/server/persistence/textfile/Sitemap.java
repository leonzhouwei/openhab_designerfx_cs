package org.openhab.designerfx.server.persistence.textfile;

import java.util.List;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.SitemapElementIf;

public class Sitemap {

	public static final String SITEMAP = "sitemap";
	
	private static final String TAB = "    ";
	
	/* sitemap <name> <label> is not the root, according to the openHAB wiki */
	private String name;
	private String label;
	private SitemapElementIf root;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setRoot(SitemapElementIf root) {
		this.root = root;
	}
	
	public String toXtext() {
		StringBuilder sb = new StringBuilder();
		sb.append("sitemap");
		sb.append(Constants.STRING_SPACE);
		sb.append(name);
		sb.append(Constants.STRING_SPACE);
		if (label != null) {
			sb.append("label=");
			sb.append("\"");
			sb.append(label);
			sb.append("\"");
			sb.append(Constants.STRING_SPACE);
		}
		sb.append("{");
		sb.append(Constants.LINE_SEPARATOR);
		if (root != null) {
			sb.append(toXtext(root, TAB).toString());
		}
		sb.append(Constants.LINE_SEPARATOR);
		sb.append("}");
		return sb.toString();
	}
	
	private StringBuilder toXtext(SitemapElementIf e, String indentation) {
		StringBuilder sb = new StringBuilder();
		sb.append(indentation + e.toXtext());
		List<SitemapElementIf> children = e.children();
		if (children != null && !children.isEmpty()) {
			sb.append(" {");
			sb.append(Constants.LINE_SEPARATOR);
			for (SitemapElementIf child : children) {
				sb.append(toXtext(child, indentation + indentation).toString());
				sb.append(Constants.LINE_SEPARATOR);
			}
			sb.append(indentation + "}");
		}
		return sb;
	}

}
