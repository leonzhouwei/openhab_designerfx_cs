package org.openhab.designerfx.server.persistence.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.persistence.ItemResourcePersistence;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:beans.xml")
public class ItemResourcePersistenceImplTest extends AbstractJUnit4SpringContextTests {
	
	private ItemResourcePersistence irp;
	@Resource
	private Context context;
	@Resource
	private ApplicationContext appContext;

	@Before
    public void setUp() throws Exception {
		final String openHABHome = Constants.CURRENT_WORKING_DIR + Constants.FILE_SEPARATOR + "test" + Constants.FILE_SEPARATOR + "resources" + Constants.FILE_SEPARATOR + "openhab-runtime";
		context.setOpenHABHome(openHABHome);
		irp = appContext.getBean(ItemResourcePersistence.class);
    }
	
	@Test
	public void testListNames() {
		List<String> names = irp.listNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

	@Test
	public void testGetContent() {
		List<String> content = irp.getContent("demo");
		for (String line : content) {
			System.out.println(line);
		}
	}

}
