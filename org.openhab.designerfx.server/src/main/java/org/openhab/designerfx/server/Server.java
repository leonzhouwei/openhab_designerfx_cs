package org.openhab.designerfx.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openhab.designerfx.server.common.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 主Acotr监听socket连接请求，然后将请求转发给新建Acotr处理
 * 
 * @author Leon Zhou
 * 
 */
public class Server {
	
	private static ApplicationContext springApplicationContext;

	public static void main(String[] args) throws IOException {
		// 启动 Spring
		springApplicationContext = new ClassPathXmlApplicationContext(
				"/beans.xml");
		// 加载配置文件
		Config config = springApplicationContext.getBean(Config.class);
		InputStreamReader isr = new InputStreamReader(new FileInputStream("server.properties"), "utf-8");
		config.load(isr);
		isr.close();
		System.out.println(config.getHost());
		System.out.println(config.getPort());
		// 获取各个领域仓库
		// 获取各个领域模型
		// 创建单例型actor
		// 创建多例型acotr
	}
	
	public static ApplicationContext getSpringApplicationContext() {
		return springApplicationContext;
	}
	
}
