package ar.gmf.dao;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.gmf.RestoApplication;
import ar.gmf.entities.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestoApplication.class)
public class MenuDAOTests {

	@Autowired
	MenuDAO menuDAO;

	@Test
	public void findAll() {
		Collection<Menu> all = menuDAO.findAll();
		Assert.assertNotNull("should not be null", all);
		Assert.assertEquals("should be 8, depending on the MenuInMemoryDAOImpl", 8, all.size());
	}

	@Test
	public void findById() {
		Menu one = menuDAO.findById(1l);
		Assert.assertNotNull("should not be null", one);
		Assert.assertEquals("name check, depending on the MenuInMemoryDAOImpl", "Dinner 1", one.getName());
		Assert.assertEquals("ranking check, depending on the MenuInMemoryDAOImpl", new Integer(4), one.getRanking());
	}

	@Test
	public void findByIdNoMenu() {
		Menu noMenu = menuDAO.findById(10000l);
		Assert.assertNull("should be null", noMenu);
	}

}
