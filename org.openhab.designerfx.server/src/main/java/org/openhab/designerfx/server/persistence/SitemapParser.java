package org.openhab.designerfx.server.persistence;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerfx.server.util.Util;

import com.google.common.collect.Lists;

public class SitemapParser {
	
	public static Sitemap parse(File file) throws IOException {
		List<String> lines = Util.readAllTrimEmptyLines(file);
		format(lines);
		print(lines);
		Sitemap sitemap = new Sitemap();
		return sitemap;
	}
	
	private static void format(List<String> lines) throws RuntimeException {
		final int size = lines.size();
		List<String> formatted = Lists.newArrayList();
		for (int i = 0; i < size; ++i) {
			String line = lines.get(i).trim();
			if (Util.count(line, "{") > 1) {
				throw new RuntimeException("More than 1 '{' found in '" + line + "'");
			}
			if (Util.count(line, "}") > 1) {
				throw new RuntimeException("More than 1 '}' found in '" + line + "'");
			}
			if (line.startsWith("{")) {
				final int z = formatted.size() - 1;
				formatted.set(z, formatted.get(z) + " {");
				if (line.length() > 1) {
					formatted.add(line.substring(line.indexOf("{") + 1, line.length()).trim());
				}
			} else if (line.length() > 1 && line.matches(".*\\}.*")) {
				final int z = line.indexOf("}");
				formatted.add(line.substring(0, z).trim());
				formatted.add("}");
				if (line.length() -1 > z) {
					formatted.add(line.substring(z + 1, line.length()).trim());
				}
			} else {
				formatted.add(line);
			}
		}
		lines.clear();
		lines.addAll(formatted);
	}
	
	private static void print(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}
	
}
