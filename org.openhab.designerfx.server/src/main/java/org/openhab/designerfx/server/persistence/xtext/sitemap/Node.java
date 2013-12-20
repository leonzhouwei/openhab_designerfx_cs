package org.openhab.designerfx.server.persistence.xtext.sitemap;

import java.util.Collection;
import java.util.List;

public interface Node extends Atom {
	
	public List<Node> getChildren();
	
	public boolean addChild(Node child);
	
	public boolean addChildren(Collection<? extends Node> children);
	
	public String toXtext(String indentation);
	
}
