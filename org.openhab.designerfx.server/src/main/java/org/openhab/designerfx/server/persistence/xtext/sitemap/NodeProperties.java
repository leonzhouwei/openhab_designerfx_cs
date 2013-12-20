package org.openhab.designerfx.server.persistence.xtext.sitemap;

import java.util.Collection;
import java.util.List;

public interface NodeProperties {
	
	public List<NodeProperty> getAll();

	public boolean add(NodeProperty property);
	
	public boolean addAll(Collection<? extends NodeProperty> properties);
	
	public boolean isEmpty();
	
	public String toXtext();

}
