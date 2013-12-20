package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.impl;

import java.util.Map;
import java.util.Set;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.Properties;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.Property;
import org.openhab.designerfx.server.persistence.xtext.internal.util.Util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 
 * Syntax:
 * List item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [separator=""]
 * 
 * @author zhouwei
 *
 */
public class List implements Properties {

	public static final String TYPE = "List";

	private static final String[] KEYWORDS = {
		TYPE,
		"icon=",
		"item=",
		"label=",
		"separator="
	};
	private static final String[] ORDERED_PROPERTY_NAMES = {
		"item",
		"label",
		"icon",
		"separator"
	};
	
	private java.util.List<Property> properties = Lists.newArrayList();
	private java.util.List<Properties> children = Lists.newArrayList();
	
	public static Set<String> keywords() {
		Set<String> keys = Sets.newHashSet();
		for (String key : KEYWORDS) {
			keys.add(key);
		}
		return keys;
	}
	
	public static List parse(String line) {
		line = line.replaceAll("\\{", "").trim();
		if (!line.startsWith(TYPE)) {
			throw new RuntimeException(line + " is NOT a " + TYPE);
		}
		Set<String> keysCopy = keywords();
		Map<String, String> map = Util.toMapTrimmingValues(line, keysCopy);
		java.util.List<Property> list = Util.toSitemapElementPropertyList(map, TYPE, keysCopy);
		List instance = new List();
		instance.addProperties(list);
		return instance;
	}

	@Override
	public String type() {
		return TYPE;
	}

	@Override
	public java.util.List<Property> properties() {
		return properties;
	}

	@Override
	public Set<String> propertyNameSet() {
		Set<String> set = Sets.newTreeSet();
		for (String s : ORDERED_PROPERTY_NAMES) {
			set.add(s);
		}
		return set;
	}

	@Override
	public String getValue(String name) {
		String value = null;
		for (Property p : properties) {
			if (p.getName().compareTo(name) == 0) {
				value = p.getValue();
				break;
			}
		}
		return value;
	}

	@Override
	public String getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<Properties> children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProperty(Property prop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChild(Properties child) {
		children.add(child);
	}

	@Override
	public void deleteProperty(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteChild(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toXtext() {
		return TYPE + Constants.STRING_SPACE + Util.toXtext(properties, ORDERED_PROPERTY_NAMES);
	}

	@Override
	public void addProperties(java.util.List<Property> prop) {
		properties.addAll(prop);
	}

}
