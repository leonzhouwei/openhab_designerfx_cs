package org.openhab.designerfx.server.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.openhab.designerfx.server.common.Constants;

import com.google.common.collect.Lists;

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

}
