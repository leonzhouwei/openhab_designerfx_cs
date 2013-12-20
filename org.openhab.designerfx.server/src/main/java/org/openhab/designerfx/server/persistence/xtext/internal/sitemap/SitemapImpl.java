package org.openhab.designerfx.server.persistence.xtext.internal.sitemap;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Node;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Sitemap;

public class SitemapImpl implements Sitemap {
	
	public static final String DEFAULT_INDENTATION = "    ";
	
	private static final String LABEL = Constants.LABEL;
	private static final String LINE_SEPARATOR = Constants.LINE_SEPARATOR;
	private static final String SITEMAP = Constants.SITEMAP;
	private static final String SPACE_MARK = Constants.SPACE_MARK;
	
	private String name;
	private String label;
	private Node root;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getLabel() {
		return label;
	}
	
	@Override
	public Node getRoot() {
		return root;
	}

	@Override
	public String toXtext() {
		StringBuilder sb = new StringBuilder();
		sb.append(SITEMAP);
		if (label != null && !label.isEmpty()) {
			sb.append(SPACE_MARK);
			sb.append(LABEL);
			sb.append("=");
			sb.append(label);			
		}
		if (root != null) {
			sb.append(SPACE_MARK);
			sb.append("{");
			sb.append(LINE_SEPARATOR);
			String elements = root.toXtext(DEFAULT_INDENTATION);
			sb.append(elements);
			sb.append(LINE_SEPARATOR);
			sb.append("}");
		}
		return sb.toString();
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
