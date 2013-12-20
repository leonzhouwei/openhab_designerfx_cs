package org.openhab.designerfx.server.persistence.xtext.sitemap;

public interface Property {

	public String getName();

	public String getValue();
	
	public String toXtext();

}
