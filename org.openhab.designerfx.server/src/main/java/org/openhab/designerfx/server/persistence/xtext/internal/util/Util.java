package org.openhab.designerfx.server.persistence.xtext.internal.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.NodePropertyImpl;
import org.openhab.designerfx.server.persistence.xtext.sitemap.NodeProperties;
import org.openhab.designerfx.server.persistence.xtext.sitemap.NodeProperty;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Util {

	public static List<File> listRegularFileNames(File directory,
			String fileExtension) {
		File[] array = directory.listFiles();
		List<File> files = Lists.newArrayList();
		for (File file : array) {
			if (file.getName().endsWith(fileExtension)) {
				files.add(file);
			}
		}
		return files;
	}

	public static List<String> baseNames(List<File> files, String fileExtension) {
		List<String> baseNames = Lists.newArrayList();
		for (File file : files) {
			String name = file.getName();
			int index = name.indexOf(fileExtension);
			String baseName = name.substring(0, index);
			baseNames.add(baseName);
		}
		return baseNames;
	}

	public static List<String> readAllTrimEmptyLines(File file)
			throws IOException {
		BufferedReader br = null;
		List<String> list = Lists.newArrayList();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					file), Constants.CHARSET_NAME_UTF_8));
			String s = null;
			while ((s = br.readLine()) != null) {
				s = s.trim();
				if (!s.isEmpty()) {
					list.add(s);
				}
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return list;
	}

	public static void printSeparateLine() {
		System.out
				.println("--------------------------------------------------------------------------------");
	}

	public static int count(String source, String target) {
		int count = 0;
		int index = -1;
		while ((index = source.indexOf(target)) >= 0) {
			count += 1;
			if (index > source.length() - 1) {
				break;
			}
			source = source.substring(index + 1, source.length());
		}
		return count;
	}

	/**
	 * 
	 * 
	 * @param string
	 * @param keywords  keywords for separation
	 * @return  a map containg the properties that have appeared in the string
	 */
	public static Map<String, String> toMapTrimmingValues(String string, Set<String> keywords) {
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
	
	public static List<NodeProperty> toSitemapElementPropertyList(Map<String, String> map, String type, Set<String> keys) {
		List<NodeProperty> list = Lists.newArrayList();
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
			if (key.compareTo(type) != 0) {
				if (keys.contains(key)) {
					NodePropertyImpl prop = new NodePropertyImpl();
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
	
	public static String toXtext(List<NodeProperty> properties) {
		StringBuilder sb = new StringBuilder();
		for (NodeProperty p : properties) {
			String name = p.getName();
			String value = p.getValue();
			if (name != null && !name.trim().isEmpty() && value != null && !value.isEmpty()) {
				sb.append(name.trim());
				sb.append("=");
				sb.append(value.trim());
				sb.append(Constants.STRING_SPACE);
			} else {
				if (name != null) {
					sb.append(name.trim());
				}
			}
		}
		return sb.toString().trim();
	}

	public static String toXtext(NodeProperties np, String[] orders) {
		List<NodeProperty> properties = np.getAll();
		StringBuilder sb = new StringBuilder();
		Map<String, NodeProperty> map = Maps.newHashMap();
		for (NodeProperty p : properties) {
			String name = p.getName();
			map.put(name, p);
		}
		for (String order : orders) {
			NodeProperty p = map.get(order);
			if (p != null) {
				String name = p.getName();
				String value = p.getValue();
				if (name != null && !name.trim().isEmpty() && value != null && !value.isEmpty()) {
					sb.append(name.trim());
					sb.append("=");
					sb.append(value.trim());
					sb.append(Constants.STRING_SPACE);
				} else {
					if (name != null) {
						sb.append(name.trim());
					}
				}
			}
		}
		return sb.toString().trim();
	}
	
}
