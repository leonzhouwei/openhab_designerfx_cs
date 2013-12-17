package org.openhab.designerfx.server.common;

public class Constants {
	
	// System
	public static final String CURRENT_WORKING_DIR = System.getProperty("user.dir");
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static final String USER_HOME_DIR = System.getProperty("user.home");
	
	//
	public static final String CHARSET_NAME_UTF_8 = "utf-8";
	public static final String STRING_SPACE = " ";
	
	// openHAB
	public static final String ITEMS_FILE_EXTENSION = ".items";
	public static final String OPENHAB_CONFIG_DIR_BASE_NAME = "configurations";
	public static final String OPENHAB_ITEMS_DIR_BASE_NAME = "items";
	public static final String OPENHAB_RULES_DIR_BASE_NAME = "rules";
	public static final String OPENHAB_SCRIPTS_DIR_BASE_NAME = "scripts";
	public static final String OPENHAB_SITEMAPS_DIR_BASE_NAME = "sitemaps";
	public static final String OPENHAB_SITEMAPS_DIR_RELATIVE_PATH = Constants.FILE_SEPARATOR + OPENHAB_CONFIG_DIR_BASE_NAME + FILE_SEPARATOR + OPENHAB_SITEMAPS_DIR_BASE_NAME;
	public static final String OPENHAB_TRANSFORM_DIR_BASE_NAME = "transform";
	public static final String OPENHAB_ITEMS_DIR_RELATIVE_PATH = Constants.FILE_SEPARATOR + OPENHAB_CONFIG_DIR_BASE_NAME + FILE_SEPARATOR + OPENHAB_ITEMS_DIR_BASE_NAME;
	public static final String SITEMAP_FILE_EXTENSION = ".sitemap";
	
	// DesignerFX
}
