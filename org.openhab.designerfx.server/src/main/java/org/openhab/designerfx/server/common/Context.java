package org.openhab.designerfx.server.common;

public interface Context {

	/**
	 * set the absolute path of the openHAB program home folder
	 * 
	 * @param openHABHome
	 */
	public void setOpenHABHome(String path) throws Exception;
	
	public String getOpenHABHome();
	
}
