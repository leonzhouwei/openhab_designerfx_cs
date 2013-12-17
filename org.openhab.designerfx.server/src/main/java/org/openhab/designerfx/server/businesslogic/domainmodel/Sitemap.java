package org.openhab.designerfx.server.businesslogic.domainmodel;

import org.openhab.designerfx.server.common.Loadable;

public class Sitemap implements Loadable {
	
	private final Long id;
	private String name;
	
	public Sitemap(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
