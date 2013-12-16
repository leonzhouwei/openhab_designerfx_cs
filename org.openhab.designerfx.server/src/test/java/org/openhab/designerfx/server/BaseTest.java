package org.openhab.designerfx.server;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Before;
import org.openhab.designerfx.server.common.Config;
import org.openhab.designerfx.server.common.ConfigBuilder;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.common.ContextBuilder;

public class BaseTest {
	
	@Before
	public void setUp() throws Exception {
		// 加载配置文件
		InputStreamReader isr = new InputStreamReader(new FileInputStream(
				"server.properties"), "utf-8");
		Config config = ConfigBuilder.build();
		config.load(isr);
		isr.close();
		//
		final String openHABHome = Constants.CURRENT_WORKING_DIR
				+ Constants.FILE_SEPARATOR + "test" + Constants.FILE_SEPARATOR
				+ "resources" + Constants.FILE_SEPARATOR + "openhab-runtime";
		Context context = ContextBuilder.build();
		context.setOpenHABHome(openHABHome);
	}
	
}
