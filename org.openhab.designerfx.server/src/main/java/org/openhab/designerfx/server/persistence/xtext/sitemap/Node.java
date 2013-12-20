package org.openhab.designerfx.server.persistence.xtext.sitemap;

import java.util.List;

public interface Node {
	
	/**
	 * 
	 * @return  "Chart", "Colorpicker", ...
	 */
	public String getType();

	public List<NodeProperty> getProperties();
	
	public NodeProperty addProperty(NodeProperty property);
	
	public List<Node> getChildren();
	
	public Node addChild(Node child);
	
}
