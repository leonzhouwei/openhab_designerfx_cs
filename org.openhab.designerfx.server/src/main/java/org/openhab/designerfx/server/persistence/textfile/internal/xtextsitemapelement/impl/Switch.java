package org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.textfile.internal.parse.SitemapElementProperty;
import org.openhab.designerfx.server.persistence.textfile.internal.xtextsitemapelement.SitemapElementIf;
import org.openhab.designerfx.server.util.Util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Switch implements SitemapElementIf {

	public static final String TYPE = "Switch";
	
	private static final String[] KEYWORDS = {
		TYPE,
		"icon=",
		"item=",
		"label=",
		"mappings="
	};
	private static final String[] PROPERTY_NAMES = {
		"icon",
		"item",
		"label",
		"mappings"
	};
	
	private List<SitemapElementProperty> properties = Lists.newArrayList();

	public static Set<String> keywords() {
		Set<String> keys = Sets.newHashSet();
		for (String key : KEYWORDS) {
			keys.add(key);
		}
		return keys;
	}
	
	public static Switch parse(String line) {
		line = line.replaceAll("\\{", "").trim();
		if (!line.startsWith(TYPE)) {
			throw new RuntimeException(line + " is NOT a " + TYPE);
		}
		Set<String> keysCopy = keywords();
		Map<String, String> map = Util.toMapTrimmingValues(line, keysCopy);
		List<SitemapElementProperty> list = Util.toSitemapElementPropertyList(map, TYPE, keysCopy);
		Switch instance = new Switch();
		instance.addProperties(list);
		return instance;
	}
	
	@Override
	public String type() {
		return TYPE;
	}

	@Override
	public List<SitemapElementProperty> properties() {
		return properties;
	}

	@Override
	public Set<String> propertyNameSet() {
		Set<String> set = Sets.newTreeSet();
		for (String s : PROPERTY_NAMES) {
			set.add(s);
		}
		return set;
	}

	@Override
	public String getValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SitemapElementIf> children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProperty(SitemapElementProperty prop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChild(SitemapElementIf child) {
		// TODO Auto-generated method stub
		
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
		return TYPE + Constants.STRING_SPACE + Util.toXtext(properties);
	}

	@Override
	public void addProperties(List<SitemapElementProperty> prop) {
		properties.addAll(prop);
	}

}
