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
 * Chart [item="<itemname>"] [icon="<iconname>"] [label="<labelname>"] [service="<service>"] [period=xxxx] [refresh=xxxx] [visibility=xxxx]
 * 
 * @author zhouwei
 *
 */
public class Chart implements Atom {
	
	public static final String TYPE = "Chart";
	
	private static final String[] KEYWORDS = {
		TYPE,
		"icon=",
		"item=",
		"label=",
		"period=",
		"refresh=",
		"service=",
		"visibility="
	};
	private static final String[] ORDERED_PROPERTY_NAMES = {
		"item",
		"icon",
		"label",
		"service",
		"period",
		"refresh",
		"visibility"
	};
	
	private NodeProperties properties = new NodePropertiesImpl();
	
	public static Chart parse(String line) {
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
		Chart instance = new Chart();
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
