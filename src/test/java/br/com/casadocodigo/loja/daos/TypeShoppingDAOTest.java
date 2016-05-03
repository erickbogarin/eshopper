package br.com.casadocodigo.loja.daos;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.casadocodigo.loja.conf.JPADataSourceConfigurationTest;
import br.com.eshopper.ecommerce.conf.JPAConfiguration;
import br.com.eshopper.ecommerce.daos.ShoppingBrandDAO;
import br.com.eshopper.ecommerce.daos.ShoppingCategoryDAO;
import br.com.eshopper.ecommerce.daos.ShoppingPersonDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{JPADataSourceConfigurationTest.class, ShoppingPersonDAO.class, ShoppingCategoryDAO.class, ShoppingBrandDAO.class, JPAConfiguration.class})
@ActiveProfiles("dev")
public class TypeShoppingDAOTest {
	
	@Autowired
	private ShoppingPersonDAO shoppingPersonDao;
	
	@Autowired
	private ShoppingCategoryDAO shoppingCategoryDao;
	
	@Autowired
	private ShoppingBrandDAO shoppingBrandDao;
	
	@Test
	public void shoulFillPersonList() {
		assertNotNull(shoppingPersonDao.list());
	}
	
	@Test
	public void shoulFillCategoryList() {
		assertNotNull(shoppingCategoryDao.list());
	}
	
	@Test
	public void shoulFillBrandList() {
		assertNotNull(shoppingBrandDao.list());
	}
	
}
