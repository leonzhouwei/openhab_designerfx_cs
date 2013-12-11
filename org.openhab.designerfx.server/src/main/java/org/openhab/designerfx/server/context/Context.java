package org.openhab.designerfx.server.context;

public interface Context {

	/**
	 * set the absolute path of the openHAB program home folder
	 * 
	 * @param openHABHome
	 */
	public void setOpenHABHome(String path) throws Exception;
	
	public String getOpenHABHome();
	
}
