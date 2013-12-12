package org.openhab.designerfx.server.common;

import java.io.IOException;
import java.io.InputStreamReader;

public interface Config {
	
	public void load(InputStreamReader inputStreamReader) throws IOException;
	
	public String getHost();
	
	public String getPort();
}
