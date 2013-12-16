package org.openhab.designerfx.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openhab.designerfx.server.businesslogic.domainmodel.ItemResourceMaster;
import org.openhab.designerfx.server.common.Config;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 主Acotr监听socket连接请求，然后将请求转发给新建Acotr处理
 * 
 * @author Leon Zhou
 * 
 */
public class Server {
	
	private static ApplicationContext appContext;

	public static void main(String[] args) throws Exception {
		// 启动 Spring
		appContext = new ClassPathXmlApplicationContext(
				"/beans.xml");
		// 加载配置文件
		Config config = appContext.getBean(Config.class);
		InputStreamReader isr = new InputStreamReader(new FileInputStream("server.properties"), "utf-8");
		config.load(isr);
		isr.close();
		System.out.println(config.getHost());
		System.out.println(config.getPort());
		//
		final String openHABHome = Constants.CURRENT_WORKING_DIR + Constants.FILE_SEPARATOR + "test" + Constants.FILE_SEPARATOR + "resources" + Constants.FILE_SEPARATOR + "openhab-runtime";
		Context context = appContext.getBean(Context.class);
		context.setOpenHABHome(openHABHome);
		ItemResourceMaster irm = appContext.getBean(ItemResourceMaster.class);
		irm.load();
	}
	
	public static ApplicationContext getSpringApplicationContext() {
		return appContext;
	}
	
}
