package org.openhab.designerfx.server.persistence.xtext.internal.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.Lists;

public class Util {

	public static List<File> listRegularFileNames(File directory,
			String fileExtension) {
		return org.openhab.designerfx.server.util.Util.listRegularFileNames(directory, fileExtension);
	}

	public static List<String> baseNames(List<File> files, String fileExtension) {
		return org.openhab.designerfx.server.util.Util.baseNames(files, fileExtension);
	}

	public static List<String> readAllTrimEmptyLines(File file)
			throws IOException {
		return org.openhab.designerfx.server.util.Util.readAllTrimEmptyLines(file);
	}

	public static void printSeparateLine() {
		org.openhab.designerfx.server.util.Util.printSeparateLine();
	}

	public static int count(String source, String target) {
		return org.openhab.designerfx.server.util.Util.count(source, target);
	}
	
	public static void trim(List<String> list) {
		List<String> trimmed = Lists.newArrayList();
		for (String string : list) {
			string = string.trim();
			if (!string.isEmpty()) {
				trimmed.add(string);
			}
		}
		list.clear();
		list.addAll(trimmed);
	}
	
}
