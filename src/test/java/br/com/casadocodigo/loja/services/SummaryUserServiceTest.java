package br.com.casadocodigo.loja.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.conf.JPADataSourceConfigurationTest;
import br.com.eshopper.ecommerce.conf.AppWebConfiguration;
import br.com.eshopper.ecommerce.conf.JPAConfiguration;
import br.com.eshopper.ecommerce.conf.RedisConfiguration;
import br.com.eshopper.ecommerce.conf.SecurityConfiguration;
import br.com.eshopper.ecommerce.daos.SummaryUserDAO;
import br.com.eshopper.ecommerce.models.SystemUser;
import br.com.eshopper.ecommerce.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppWebConfiguration.class, JPAConfiguration.class, RedisConfiguration.class, SecurityConfiguration.class,
		JPADataSourceConfigurationTest.class })
@ActiveProfiles("dev")
public class SummaryUserServiceTest {

	@Autowired
	private SummaryUserDAO summaryUserDao;

	@Autowired
	private UserService userService;

	@Autowired
	private SystemUser user;

	@Test
	@Transactional
	public void shouldRegisterANewSummaryUser() {
		user.setLogin("teste@email.com");
		user.setName("Teste");
		user.setPassword("qwe123");
		userService.save(user);
		
		assertNotNull(summaryUserDao.find());
	}

}
