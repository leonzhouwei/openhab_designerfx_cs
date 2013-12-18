package org.openhab.designerfx.server.persistence.textfile.internal.parse;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerfx.server.persistence.textfile.Sitemap;
import org.openhab.designerfx.server.util.Util;

import com.google.common.collect.Lists;

public class SitemapParser {
	
	private static final String SITEMAP = "sitemap";
	
	public static Sitemap parse(File file) throws IOException {
		List<String> lines = Util.readAllTrimEmptyLines(file);
		if (lines.isEmpty() || !lines.get(0).startsWith(SITEMAP)) {
			throw new RuntimeException("Invalid sitemap file (" + file.getPath() + ")");
		}
		format(lines);
		print(lines);
		return doParse(lines);
	}
	
	private static Sitemap doParse(List<String> lines) {
		Sitemap sitemap = new Sitemap();
		// parse the head part (e.g. sitemap demo label="Main Menu")
		String line = lines.get(0);
		String temp = line.substring(SITEMAP.length(), line.length()).trim();
		String name = temp.split("\\s")[0].trim();
		sitemap.setName(name);
		if (!temp.endsWith(name)) {
			String label = temp.substring(name.length(), temp.length()).trim();
			sitemap.setLabel(label.split("=")[1].trim());
		}
		return sitemap;
	}
	
	private static int parseSitemapElement(SitemapElement empty, List<String> lines, final int startLine) {
		int endLine = -1;
		final int size = lines.size();
		for (int i = startLine; i < size; ++i) {
			String line = lines.get(i);
			if (line.endsWith("{")) {
				SitemapElement child = new SitemapElement();
				parseSitemapElement(child, lines, i);
				empty.addChild(child);
			}
			if (line.startsWith("}")) {
				endLine = i;
				break;
			}
			
		}
		return endLine;
	}
	
	private SitemapElement parseAtomic(String line) {
		return null;
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
