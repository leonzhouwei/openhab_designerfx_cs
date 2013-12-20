package org.openhab.designerfx.server.persistence.xtext.sitemap;

import java.util.Collection;
import java.util.List;

public interface Properties {
	
	public List<Property> getAll();

	public boolean add(Property property);
	
	public boolean addAll(Collection<? extends Property> properties);
	
	public boolean isEmpty();
	
	public String toXtext(String[] orders);

}
