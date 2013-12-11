package org.openhab.designerfx.server;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerfx.server.queryservice.ItemQueryService;
import org.openhab.designerfx.server.util.Util;
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
		ItemQueryService iqs = context.getBean(ItemQueryService.class);
		System.out.println(iqs.listResourcesNames().get(0));
		List<String> lines = Util.readAll(new File("server.properties"));
		for (String line : lines) {
			System.out.println(line);
		}
	}

}
