package org.openhab.designerfx.server.persistence.xtext.internal.sitemap;

import java.util.List;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.internal.util.Util;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Node;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Sitemap;

import com.google.common.collect.Lists;

public class SitemapImpl implements Sitemap {

	public static final String DEFAULT_INDENTATION = "    ";

	private static final String LABEL = Constants.LABEL;
	private static final String LINE_SEPARATOR = Constants.LINE_SEPARATOR;
	private static final String SITEMAP = Constants.SITEMAP;
	private static final String SPACE_MARK = Constants.SPACE_MARK;

	private String name;
	private String label;
	private Node root;

	public static SitemapImpl parse(List<String> list) {
		//
		List<String> lines = Lists.newArrayList();
		lines.addAll(list);
		//
		check(lines);
		trim(lines);
		SitemapImpl sitemap = new SitemapImpl();
		final String firstLine = lines.get(0).trim();
		if (!firstLine.startsWith(SITEMAP)) {
			throw new RuntimeException("could not find 'sitemap' in "
					+ firstLine);
		}
		final int index = firstLine.indexOf(LABEL + "=");
		if (index > 0) {
			String name = firstLine.substring(SITEMAP.length(), index);
			sitemap.setName(name);
			String label = firstLine.substring(index + LABEL.length());
			label = label.replaceAll("\\{", "").trim();
			sitemap.setLabel(label);
		} else {
			String name = firstLine.substring(SITEMAP.length());
			name = name.replaceAll("\\{", "").trim();
			sitemap.setName(name);
		}
		int rootNodeStartLine = -1;
		if (firstLine.endsWith("{")) {

		}
		int rootNodeEndLint = -1;
		return sitemap;
	}

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
		if (name == null || name.trim().isEmpty()) {
			throw new RuntimeException(
					"sitemap name should NOT be null or empty");
		}
		this.name = name;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public static void check(List<String> lines) {
		// check if '{'s and '}'s have the same count
		int count = 0;
		for (String line : lines) {
			count += Util.count(line, "{");
			count -= Util.count(line, "}");
		}
		if (count != 0) {
			throw new RuntimeException(
					"the number of '{'s is not equal to '}'s");
		}
	}

	private static void trim(List<String> list) {
		List<String> lines = Lists.newArrayList();
		for (String line : list) {
			line = line.trim();
			if (!line.isEmpty()) {
				lines.add(line);
			}
		}
		list.clear();
		list.addAll(lines);
	}

}
