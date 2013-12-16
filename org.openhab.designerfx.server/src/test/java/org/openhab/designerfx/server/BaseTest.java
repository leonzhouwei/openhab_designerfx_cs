package org.openhab.designerfx.server;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Before;
import org.openhab.designerfx.server.common.Config;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
	
	protected ApplicationContext appContext;

	@Before
	public void setUp() throws Exception {
		// 启动 Spring
		appContext = new ClassPathXmlApplicationContext("/beans.xml");
		// 加载配置文件
		Config config = appContext.getBean(Config.class);
		InputStreamReader isr = new InputStreamReader(new FileInputStream(
				"server.properties"), "utf-8");
		config.load(isr);
		isr.close();
		//
		final String openHABHome = Constants.CURRENT_WORKING_DIR
				+ Constants.FILE_SEPARATOR + "test" + Constants.FILE_SEPARATOR
				+ "resources" + Constants.FILE_SEPARATOR + "openhab-runtime";
		Context context = appContext.getBean(Context.class);
		context.setOpenHABHome(openHABHome);
	}
	
}
