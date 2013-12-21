package org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom;

import java.util.Collection;

import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.properties.PropertiesImpl;
import org.openhab.designerfx.server.persistence.xtext.internal.sitemap.node.atom.properties.PropertyImpl;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Atom;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Properties;
import org.openhab.designerfx.server.persistence.xtext.sitemap.Property;

/**
 * 
 * Syntax:
 * sitemap <itemname> [label="<labelname>"]
 * 
 * @author zhouwei
 *
 */
public class AtomSitemap implements Atom {
	
	public static final String TYPE = "sitemap";
	public static final String DEFAULT_INDENTATION = "    ";
	
	private static final String[] ORDERED_PROPERTY_NAMES = {
		"label"
	};
	
	private String name;
	private Properties properties = new PropertiesImpl();
	
	public static AtomSitemap parse(String line) {
		line = line.replaceAll("\\{", "").trim();
		if (!line.startsWith(TYPE)) {
			throw new RuntimeException(line + " is NOT a " + TYPE);
		}
		final String LABEL_EQU = "label=";
		final int labelStartIndex = line.indexOf(LABEL_EQU);
		String name = null;
		String label = null;
		if (labelStartIndex == -1) {
			name = line.substring(TYPE.length()).trim();;
			if (name.isEmpty()) {
				throw new RuntimeException("can not find the sitemap name in '" + line + "'");
			}
		} else {
			label = line.substring(labelStartIndex + LABEL_EQU.length(), line.length()).trim();
			name = line.substring(TYPE.length(), labelStartIndex).trim();
			if (name.isEmpty()) {
				throw new RuntimeException("can not find the sitemap name in '" + line + "'");
			}
		}
		AtomSitemap instance = new AtomSitemap();
		instance.setName(name);
		if (label != null) {
			PropertyImpl prop = new PropertyImpl();
			prop.setName("label");
			prop.setValue(label);
			instance.addProperty(prop);
		}
		return instance;
	}

	@Override
	public String toXtext() {
		StringBuilder sb = new StringBuilder();
		sb.append(TYPE);
		sb.append(Constants.SPACE_MARK);
		sb.append(name);
		if (!properties.isEmpty()) {
			sb.append(Constants.SPACE_MARK);
			sb.append(properties.toXtext(ORDERED_PROPERTY_NAMES));	
		}
		return sb.toString();
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
