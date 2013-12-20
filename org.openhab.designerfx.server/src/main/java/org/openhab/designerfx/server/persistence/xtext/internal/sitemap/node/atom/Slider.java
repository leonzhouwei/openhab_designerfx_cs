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
 * Slider item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [sendFrequency="frequency"] [switchEnabled]
 * 
 * @author zhouwei
 *
 */
public class Slider implements Atom {

	public static final String TYPE = "Slider";
	
	private static final String[] KEYWORDS = {
		TYPE,
		"item=",
		"icon=",
		"label=",
		"sendFrequency=",
		"switchEnabled",
		"switchSupport"
	};
	private static final String[] ORDERED_PROPERTY_NAMES = {
		"item",
		"label",
		"icon",
		"sendFrequency",
		"switchEnabled",
		"switchSupport"
	};
	
	private Properties properties = new PropertiesImpl();
	
	public static Slider parse(String line) {
		line = line.replaceAll("\\{", "").trim();
		if (!line.startsWith(TYPE)) {
			throw new RuntimeException(line + " is NOT a " + TYPE);
		}
		Set<String> keywordSet = Sets.newHashSet();
		for (String key : KEYWORDS) {
			keywordSet.add(key);
		}
		Slider instance = new Slider();
		instance.addProperties(PropertiesImpl.parse(line, TYPE, keywordSet).getAll());
		return instance;
	}

	@Override
	public String toXtext() {
		return TYPE + Constants.STRING_SPACE + properties.toXtext(ORDERED_PROPERTY_NAMES);
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
