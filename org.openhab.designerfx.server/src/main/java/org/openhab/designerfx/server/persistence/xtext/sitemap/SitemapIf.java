package org.openhab.designerfx.server.persistence.xtext.sitemap;

public interface SitemapIf {

	public String getName();

	public String getLabel();
	
	public Node getRoot();

	public String toXtext();

}
