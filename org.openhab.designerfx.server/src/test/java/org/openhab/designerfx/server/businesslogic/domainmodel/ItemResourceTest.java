package org.openhab.designerfx.server.businesslogic.domainmodel;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:beans.xml")
public class ItemResourceTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private Context context;
	@Resource
	private ApplicationContext appContext;
	
	@Before
    public void setUp() throws Exception {
		final String openHABHome = Constants.CURRENT_WORKING_DIR + Constants.FILE_SEPARATOR + "test" + Constants.FILE_SEPARATOR + "resources" + Constants.FILE_SEPARATOR + "openhab-runtime";
		context.setOpenHABHome(openHABHome);
    }
	
	@Test
	public void testLoad() {
		ItemResource ir = appContext.getBean(ItemResource.class);
		ir.setName("demo");
		ir.load();
		ir.toString();
	}

}
