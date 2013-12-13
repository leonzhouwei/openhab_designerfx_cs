package org.openhab.designerfx.server;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.openhab.designerfx.server.businesslogic.domainrepository.ItemResourceRepository;
import org.openhab.designerfx.server.common.Config;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	private static ApplicationContext appContext;

	public static void main(String[] args) throws Exception {
		// 启动 Spring
		appContext = new ClassPathXmlApplicationContext(
				"/beans.xml");
		// 加载配置文件
		Config config = appContext.getBean(Config.class);
		InputStreamReader isr = new InputStreamReader(new FileInputStream(
				"server.properties"), "utf-8");
		config.load(isr);
		isr.close();
		// 设置上下文环境
		Context context = appContext.getBean(Context.class);
		final String openHABHome = Constants.CURRENT_WORKING_DIR + Constants.FILE_SEPARATOR + "test" + Constants.FILE_SEPARATOR + "resources" + Constants.FILE_SEPARATOR + "openhab-runtime";
		context.setOpenHABHome(openHABHome);
		// 获取各个领域仓库
		ItemResourceRepository irr = appContext.getBean(ItemResourceRepository.class);
		List<String> names = irr.listAllNames();
		for (String name : names) {
			System.out.println(name);
		}
		// 获取各个领域模型
		// 创建单例型actor
		// 创建多例型acotr
	}

	public static ApplicationContext getSpringApplicationContext() {
		return appContext;
	}

}
