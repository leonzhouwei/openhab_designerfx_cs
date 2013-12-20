package org.openhab.designerfx.server.persistence.xtext.internal.sitemap;

import java.util.Collection;
import java.util.List;

import org.openhab.designerfx.server.persistence.xtext.sitemap.NodeProperties;
import org.openhab.designerfx.server.persistence.xtext.sitemap.NodeProperty;

import com.google.common.collect.Lists;

public class NodePropertiesImpl implements NodeProperties {
	
	private List<NodeProperty> properties = Lists.newArrayList();

	@Override
	public boolean add(NodeProperty property) {
		properties.add(property);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends NodeProperty> properties) {
		this.properties.addAll(properties);
		return true;
	}

	@Override
	public String toXtext() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		return properties.isEmpty();
	}

	@Override
	public List<NodeProperty> getAll() {
		return properties;
	}

}
