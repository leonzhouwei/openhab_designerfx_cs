package org.openhab.designerfx.server.persistence.textfile;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElement;

public class Sitemap {

	private String name;
	private String label;
	/* sitemap <name> <label> is not the root, according to the openHAB wiki */
	private SitemapElement root = new SitemapElement();

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
	
	public void setRoot(SitemapElement e) {
		this.root = e;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("sitemap");
		sb.append(Constants.STRING_SPACE);
		sb.append(name);
		sb.append(Constants.STRING_SPACE);
		if (label != null) {
			sb.append(label);
			sb.append(Constants.STRING_SPACE);
		}
		sb.append("{");
		sb.append(root.toString());
		sb.append(Constants.LINE_SEPARATOR);
		sb.append("}");
		return sb.toString();
	}

}
