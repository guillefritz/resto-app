package ar.gmf.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.gmf.RestoApplication;
import ar.gmf.entities.Menu;
import ar.gmf.services.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestoApplication.class)
public class MenuServiceTests {

	@Autowired
	MenuService menuService;
	
	@Test
	public void findAll() {
		Collection<Menu> all = menuService.findAll();
		Assert.assertNotNull("should not be null", all);
		Assert.assertEquals("should be 8, depending on the MenuInMemoryDAOImpl", 8, all.size());
	}

}
