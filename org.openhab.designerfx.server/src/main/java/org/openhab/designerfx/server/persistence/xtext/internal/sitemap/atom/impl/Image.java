package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.atom.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.NodePropertiesImpl;
import org.openhab.designerfx.server.persistence.xtext.internal.util.Util;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Atom;
import org.openhab.designerfx.server.persistence.xtext.sitemap.NodeProperties;
import org.openhab.designerfx.server.persistence.xtext.sitemap.NodeProperty;

import com.google.common.collect.Sets;

/**
 * 
 * Syntax:
 * Image [item="<itemname>"] [icon="<iconname>"] url="<url of image>" [label="<labelname>"] [refresh=IMAGE]
 * 
 * @author zhouwei
 *
 */
public class Image implements Atom {

	public static final String TYPE = "Image";

	private static final String[] KEYWORDS = {
		TYPE,
		"icon=",
		"item=",
		"label=",
		"refresh=",
		"url="
	};
	private static final String[] ORDERED_PROPERTY_NAMES = {
		"item",
		"icon",
		"url",
		"label",
		"refresh"
	};
	
	private NodeProperties properties = new NodePropertiesImpl();
	
	public static Image parse(String line) {
		line = line.replaceAll("\\{", "").trim();
		if (!line.startsWith(TYPE)) {
			throw new RuntimeException(line + " is NOT a " + TYPE);
		}
		Set<String> keywordSet = Sets.newHashSet();
		for (String key : KEYWORDS) {
			keywordSet.add(key);
		}
		Map<String, String> map = Util.toMapTrimmingValues(line, keywordSet);
		List<NodeProperty> list = Util.toSitemapElementPropertyList(map, TYPE, keywordSet);
		Image instance = new Image();
		instance.addProperties(list);
		return instance;
	}

	@Override
	public String toXtext() {
		return TYPE + Constants.STRING_SPACE + Util.toXtext(properties, ORDERED_PROPERTY_NAMES);
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public NodeProperties getProperties() {
		return properties;
	}

	@Override
	public boolean addProperty(NodeProperty property) {
		return properties.add(property);
	}

	@Override
	public boolean addProperties(Collection<? extends NodeProperty> properties) {
		return this.properties.addAll(properties);
	}

}
