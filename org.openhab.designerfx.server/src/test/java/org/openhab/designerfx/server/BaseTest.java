package org.openhab.designerfx.server;

import org.junit.Before;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.common.ContextBuilder;

public class BaseTest {
	
	@Before
	public void setUp() throws Exception {
		// 获取环境参数
		final String openHABHome = Constants.CURRENT_WORKING_DIR
				+ Constants.FILE_SEPARATOR + "test" + Constants.FILE_SEPARATOR
				+ "resources" + Constants.FILE_SEPARATOR + "openhab-runtime-1.2.0";
		Context context = ContextBuilder.build();
		context.setOpenHABHome(openHABHome);
		// 加载配置文件
		Server.loadConfig();
	}
	
}
