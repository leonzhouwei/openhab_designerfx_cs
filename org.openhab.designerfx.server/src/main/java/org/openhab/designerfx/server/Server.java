package org.openhab.designerfx.server;

import org.openhab.designerfx.server.queryservice.ItemQueryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 主Acotr监听socket连接请求，然后将请求转发给新建Acotr处理
 * 
 * @author Leon Zhou
 * 
 */
public class Server {

	public static void main(String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext(
				"/beans.xml");
		System.out.println(context.getBean(ItemQueryService.class));
	}

}
