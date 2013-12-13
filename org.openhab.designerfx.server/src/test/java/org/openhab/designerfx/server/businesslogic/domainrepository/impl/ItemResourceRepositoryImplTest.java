package org.openhab.designerfx.server.businesslogic.domainrepository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.openhab.designerfx.server.businesslogic.domainmodel.ItemResource;
import org.openhab.designerfx.server.businesslogic.domainrepository.ItemResourceRepository;
import org.openhab.designerfx.server.common.Constants;
import org.openhab.designerfx.server.common.Context;
import org.openhab.designerfx.server.util.Util;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:beans.xml")
public class ItemResourceRepositoryImplTest extends AbstractJUnit4SpringContextTests {
	
	@Resource
	private ApplicationContext appContext;
	@Resource
	private Context context;
	@Resource
	private ItemResourceRepository itemResRepo;
	
	@Before
    public void setUp() throws Exception {
		final String openHABHome = Constants.CURRENT_WORKING_DIR + Constants.FILE_SEPARATOR + "test" + Constants.FILE_SEPARATOR + "resources" + Constants.FILE_SEPARATOR + "openhab-runtime";
		context.setOpenHABHome(openHABHome);
		itemResRepo.load();
    }
	
	@Test
	public void testListAllNames() {
		Util.printSeparateLine();
		List<String> names = itemResRepo.listAllNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

	@Test
	public void testListAll() {
		Util.printSeparateLine();
		List<ItemResource> irs = itemResRepo.listAll();
		for (ItemResource ir : irs) {
			ir.load();
			System.out.println(ir.toString());
		}
	}

}
