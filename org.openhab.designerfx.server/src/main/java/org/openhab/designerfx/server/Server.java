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

	public static void main(String[] args) throws IOException {
		final ApplicationContext context = new ClassPathXmlApplicationContext(
				"/beans.xml");
		Config config = context.getBean(Config.class);
		InputStreamReader isr = new InputStreamReader(new FileInputStream("server.properties"), "utf-8");
		config.load(isr);
		isr.close();
		System.out.println(config.getHost());
		System.out.println(config.getPort());
	}
	
}
