package br.com.casadocodigo.loja.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.eshopper.ecommerce.conf.AppWebConfiguration;
import br.com.eshopper.ecommerce.conf.JPAConfiguration;
import br.com.eshopper.ecommerce.conf.SecurityConfiguration;
import br.com.eshopper.ecommerce.daos.UserDAO;
import br.com.eshopper.ecommerce.models.SummaryData;
import br.com.eshopper.ecommerce.models.User;
import br.com.eshopper.ecommerce.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppWebConfiguration.class, JPAConfiguration.class, SecurityConfiguration.class,
		DataSourceConfigurationTest.class })
@ActiveProfiles("test")
public class RedisConnectionTest {
/*
	@Autowired
	private SummaryDataDAO summaryDataDao;
	
	@Autowired
	private SummaryUserDAO summaryUserDao;*/
	
	@Autowired
	private SummaryData summaryData;
	
	@Autowired
	private SummaryData summaryUser;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private User user;
	
/*	@Test
	public void testRedis() {
		summaryData.setMonthlyProfit(BigDecimal.ZERO);
		summaryData.setMonthPurchaseTotal(12);
		summaryDataDao.save(summaryData);
		System.out.println(summaryDataDao.findAll());
	}
*/	
	/*@Test
	@Transactional
	public void testUser() {
		user.setLogin("testes@email.com");
		user.setName("Teste");
		user.setPassword("qwe123");
		userService.save(user);
		System.out.println(summaryUserDao.find());
	}*/
	
	@Test
	public void testUser() {
		
		if(SecurityContextHolder.getContext().getAuthentication() != null)
			System.out.println("oi");
		
			
	}
	
	/*
	 * @Test public void testNull() {
	 * summaryData.setPeriod(Month.APRIL.getValue(), Year.of(2016).getValue());
	 * summaryData = summaryDataDao.find(summaryData.getPeriod());
	 * System.out.println(summaryData.getMonthPurchaseTotal());
	 * assertTrue(summaryData != null); }
	 */

}
