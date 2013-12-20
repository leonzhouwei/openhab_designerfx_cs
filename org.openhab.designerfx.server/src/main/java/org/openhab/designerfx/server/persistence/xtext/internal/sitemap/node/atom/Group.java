package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom;

import java.util.Collection;
import java.util.Set;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.properties.PropertiesImpl;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Atom;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Properties;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Property;

import com.google.common.collect.Sets;

/**
 * 
 * Syntax:
 * Group [item="<itemname>"] [label="<labelname>"] [icon="<iconname>"]
 * 
 * @author zhouwei
 *
 */
public class Group implements Atom {

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
	
	private Properties properties = new PropertiesImpl();
	
	public static Group parse(String line) {
		line = line.replaceAll("\\{", "").trim();
		if (!line.startsWith(TYPE)) {
			throw new RuntimeException(line + " is NOT a " + TYPE);
		}
		Set<String> keywordSet = Sets.newHashSet();
		for (String key : KEYWORDS) {
			keywordSet.add(key);
		}
		Group instance = new Group();
		instance.addProperties(PropertiesImpl.parse(line, TYPE, keywordSet).getAll());
		return instance;
	}

	@Override
	public String toXtext() {
		return TYPE + Constants.SPACE_MARK + properties.toXtext(ORDERED_PROPERTY_NAMES);
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public Properties getProperties() {
		return properties;
	}

	@Override
	public boolean addProperty(Property property) {
		return properties.add(property);
	}

	@Override
	public boolean addProperties(Collection<? extends Property> properties) {
		return this.properties.addAll(properties);
	}

}
