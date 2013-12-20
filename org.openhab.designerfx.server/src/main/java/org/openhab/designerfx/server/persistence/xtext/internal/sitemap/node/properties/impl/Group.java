package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.properties.impl;

import java.util.List;
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
 * Group [item="<itemname>"] [label="<labelname>"] [icon="<iconname>"]
 * 
 * @author zhouwei
 *
 */
public class Group implements Properties {

	public static final String TYPE = "Group";
	
	private static final String[] KEYWORDS = {
		TYPE,
		"icon=", 
		"item=",
		"label="
	};
	private static final String[] ORDERED_PROPERTY_NAMES = {
		"item",
		"label",
		"icon"
	};
	
	private List<Property> properties = Lists.newArrayList();
	private List<Properties> children = Lists.newArrayList();
	
	public static Set<String> keywords() {
		Set<String> keys = Sets.newHashSet();
		for (String key : KEYWORDS) {
			keys.add(key);
		}
		return keys;
	}
	
	public static Group parse(String line) {
		line = line.replaceAll("\\{", "").trim();
		if (!line.startsWith(TYPE)) {
			throw new RuntimeException(line + " is NOT a " + TYPE);
		}
		Set<String> keysCopy = keywords();
		Map<String, String> map = Util.toMapTrimmingValues(line, keysCopy);
		List<Property> list = Util.toSitemapElementPropertyList(map, TYPE, keysCopy);
		Group instance = new Group();
		instance.addProperties(list);
		return instance;
	}
	
	@Override
	public String type() {
		return TYPE;
	}

	@Override
	public List<Property> properties() {
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
	public List<Properties> children() {
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
	public void addProperties(List<Property> prop) {
		properties.addAll(prop);
	}

}
