package org.openhab.designerfx.server.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openhab.designerfx.server.common.Constants;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Util {

	public static List<File> listRegularFileNames(File directory, String fileExtension) {
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
	
	public static List<String> readAllTrimEmptyLines(File file) throws IOException {
		BufferedReader br = null;
		List<String> list = Lists.newArrayList();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Constants.CHARSET_NAME_UTF_8));
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
		System.out.println("--------------------------------------------------------------------------------");
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
	
	public static List<String> separateTrimmingSpace(String string, String[] differentSeparators) {
		List<String> result = Lists.newArrayList();
		string = string.trim();
		String[] seps = new String[differentSeparators.length];
		for (int i = 0; i < seps.length; ++i) {
			seps[i] = differentSeparators[i];
		}
		if (seps.length == 1) {
			String[] array = string.split(seps[0]);
			for (String s : array) {
				result.add(s.trim());
			}
			return result;
		}
		int[] indexes = new int[seps.length];
		for (int i = 0; i < seps.length; ++i) {
			int index = string.indexOf(seps[i]);
			indexes[i] = index;
		}
		// effective separator and its start index in @string
		Map<Integer, String> effectiveSepMap = Maps.newHashMap();
		for (int i = 0; i < seps.length; ++i) {
			if (indexes[i] != -1) {
				effectiveSepMap.put(indexes[i], seps[i]);
			}
		}
		
		if (effectiveSepMap.isEmpty()) {
			result.add(string.trim());
			return result;
		}
		
		List<Integer> effectiveIndexes = Lists.newArrayList();
		effectiveIndexes.addAll(effectiveSepMap.keySet());
		Collections.sort(effectiveIndexes);
		// extract the substring before the first separator
		if (effectiveIndexes.get(0) != 0) {
			result.add(string.substring(0, effectiveIndexes.get(0)).trim());
		}
		final int size = effectiveIndexes.size();
		for (int i = 0; i < size - 1; ++i) {
			final int start = effectiveIndexes.get(i) + effectiveSepMap.get(effectiveIndexes.get(i)).length();
			result.add(string.substring(start, effectiveIndexes.get(i + 1)).trim());
		}
		if (effectiveIndexes.get(size - 1) < string.length() - 1) {
			final int start = effectiveIndexes.get(size - 1) + effectiveSepMap.get(effectiveIndexes.get(size - 1)).length();
			result.add(string.substring(start, string.length()).trim());
		}
		// extract the substring after the last separator
		return result;
	}
	
}
