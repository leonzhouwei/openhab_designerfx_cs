package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.properties;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Properties;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Property;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class PropertiesImpl implements Properties {
	
	private List<Property> properties = Lists.newArrayList();
	
	public static PropertiesImpl parse(String xtext, String expectedType, Set<String> keywords) {
		Map<String, String> map = toMapTrimmingValues(xtext, keywords);
		List<Property> props = toPropertyList(map, expectedType, keywords);
		PropertiesImpl instance = new PropertiesImpl();
		instance.addAll(props);
		return instance;
	}
	
	@Override
	public boolean add(Property property) {
		properties.add(property);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends Property> properties) {
		this.properties.addAll(properties);
		return true;
	}

	@Override
	public String toXtext(String[] orders) {
		StringBuilder sb = new StringBuilder();
		Map<String, Property> map = Maps.newHashMap();
		for (Property p : properties) {
			String name = p.getName();
			map.put(name, p);
		}
		for (String order : orders) {
			Property p = map.get(order);
			if (p != null) {
				String name = p.getName();
				String value = p.getValue();
				if (name != null && !name.trim().isEmpty() && value != null && !value.isEmpty()) {
					sb.append(name.trim());
					sb.append("=");
					sb.append(value.trim());
					sb.append(Constants.SPACE_MARK);
				} else {
					if (name != null) {
						sb.append(name.trim());
					}
				}
			}
		}
		return sb.toString().trim();
	}
	
	@Override
	public boolean isEmpty() {
		return properties.isEmpty();
	}

	@Override
	public List<Property> getAll() {
		return properties;
	}
	
	/**
	 * 
	 * 
	 * @param string
	 * @param keywords  keywords for separation
	 * @return  a map containg the properties that have appeared in the string
	 */
	private static Map<String, String> toMapTrimmingValues(String string, Set<String> keywords) {
		string = string.trim();
		Map<String, String> result = Maps.newHashMap();
		for (String key : keywords) {
			result.put(key, null);
		}
		final int keyCount = keywords.size();
		if (keyCount == 1) {
			String key = keywords.iterator().next();
			String[] array = string.split(key);
			result.put(key, array[1].trim());
			return result;
		}
		// parse effective key-startIndex pairs from @string
		Map<Integer, String> effectiveIndexKeyPairs = Maps.newHashMap();
		Iterator<String> iterator = keywords.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			int index = string.indexOf(key);
			if (index != -1) {
				effectiveIndexKeyPairs.put(index, key.trim());
			}
		}
		if (effectiveIndexKeyPairs.isEmpty()) {
			return result;
		}
		List<Integer> orderedIndexes = Lists.newArrayList();
		orderedIndexes.addAll(effectiveIndexKeyPairs.keySet());
		Collections.sort(orderedIndexes);
		
		// extract keys and related values pairs before the last pair
		final int size = orderedIndexes.size();
		for (int i = 0; i < size - 1; ++i) {
			final int start = orderedIndexes.get(i) + effectiveIndexKeyPairs.get(orderedIndexes.get(i)).length();
			final String key = effectiveIndexKeyPairs.get(orderedIndexes.get(i));
			final String value = string.substring(start, orderedIndexes.get(i + 1));
			System.out.println("oops: " + key + ", " + value);
			result.put(key, value.trim());
		}
		// extract the last pair
		final int start = orderedIndexes.get(size - 1) + effectiveIndexKeyPairs.get(orderedIndexes.get(size - 1)).length();
		final String key = effectiveIndexKeyPairs.get(orderedIndexes.get(size - 1));
		final String value = string.substring(start, string.length());
		result.put(key, value.trim());
		// remove properties that did NOT appear in the text line
		Set<String> set = result.keySet();
		List<String> list = Lists.newArrayList();
		list.addAll(set);
		for (String s : list) {
			String v = result.get(s);
			if (v == null) {
				result.remove(s);
			}
		}
		return result;
	}
	
	private static List<Property> toPropertyList(Map<String, String> map, String expectedType, Set<String> keys) {
		List<Property> list = Lists.newArrayList();
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
			if (key.compareTo(expectedType) != 0) {
				if (keys.contains(key)) {
					PropertyImpl prop = new PropertyImpl();
					String name = key;
					if (key.endsWith("=")) {
						name = key.replace("=", "");
					}
					prop.setName(name);
					prop.setValue(value);
					list.add(prop);					
				}
			}
		}
		return list;
	}

}
