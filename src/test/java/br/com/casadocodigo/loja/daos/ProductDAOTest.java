package br.com.casadocodigo.loja.daos;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.builders.ProductBuilder;
import br.com.casadocodigo.loja.conf.JPADataSourceConfigurationTest;
import br.com.eshopper.ecommerce.conf.JPAConfiguration;
import br.com.eshopper.ecommerce.daos.ProductDAO;
import br.com.eshopper.ecommerce.models.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPADataSourceConfigurationTest.class, ProductDAO.class, JPAConfiguration.class })
@ActiveProfiles("test")
public class ProductDAOTest {

	@Autowired
	private ProductDAO productDAO;

	@Transactional
	@Test
	public void shouldSumAllPricesOfEachProduct() {
		List<Product> products = 
				ProductBuilder.newProduct(BigDecimal.TEN).more(4).buildAll();
		
		products.stream().forEach(productDAO::save);
				
		BigDecimal value  = productDAO.sumPrices();
		
		assertEquals(new BigDecimal(50).setScale(2), value);
	}

}
