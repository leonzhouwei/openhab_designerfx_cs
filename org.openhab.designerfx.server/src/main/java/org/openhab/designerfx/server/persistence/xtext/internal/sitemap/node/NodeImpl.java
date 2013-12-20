package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node;

import java.util.Collection;
import java.util.List;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.SitemapImpl;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Atom;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Node;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Properties;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Property;

import com.google.common.collect.Lists;

public class NodeImpl implements Node {
	
	private static final String SPACE = Constants.SPACE_MARK;
	private static final String LINE_SEPARATOR = Constants.LINE_SEPARATOR;
	private static final String TAB = SitemapImpl.DEFAULT_INDENTATION;

	private Atom atom;
	private List<Node> children = Lists.newArrayList();
	
	public NodeImpl(Atom atom) {
		this.atom = atom;
	}
	
	@Override
	public String getType() {
		return atom.getType();
	}

	@Override
	public Properties getProperties() {
		return atom.getProperties();
	}

	@Override
	public boolean addProperty(Property property) {
		return atom.addProperty(property);
	}

	@Override
	public List<Node> getChildren() {
		return children;
	}

	@Override
	public boolean addChild(Node child) {
		return children.add(child);
	}

	@Override
	public boolean addProperties(Collection<? extends Property> properties) {
		return atom.addProperties(properties);
	}

	@Override
	public boolean addChildren(Collection<? extends Node> children) {
		return this.children.addAll(children);
	}

	@Override
	public String toXtext(String indentation) {
		StringBuilder sb = new StringBuilder();
		sb.append(indentation);
		sb.append(atom.toXtext());
		// children
		if (!children.isEmpty()) {
			sb.append(SPACE);
			sb.append("{");
			sb.append(LINE_SEPARATOR);
			for (Node child : children) {
				sb.append(child.toXtext(indentation + TAB));
				sb.append(LINE_SEPARATOR);
			}
			sb.append(indentation);
			sb.append("}");
		}
		return sb.toString();
	}

	@Override
	public String toXtext() {
		return toXtext("");
	}

}