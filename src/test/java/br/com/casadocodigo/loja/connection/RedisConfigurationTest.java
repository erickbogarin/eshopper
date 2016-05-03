package br.com.casadocodigo.loja.connection;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.casadocodigo.loja.conf.JPADataSourceConfigurationTest;
import br.com.eshopper.ecommerce.conf.AppWebConfiguration;
import br.com.eshopper.ecommerce.conf.JPAConfiguration;
import br.com.eshopper.ecommerce.conf.RedisConfiguration;
import br.com.eshopper.ecommerce.conf.SecurityConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppWebConfiguration.class, JPAConfiguration.class, RedisConfiguration.class, SecurityConfiguration.class,
		JPADataSourceConfigurationTest.class })
@ActiveProfiles("dev")
public class RedisConfigurationTest {

	@Inject
	private RedisTemplate<String, String> redisTemplate;

	@Test
	public void testRedisTemplate() {
		assertNotNull(redisTemplate);
	}
	
	@Test
	public void testSimpleInsertion() {
		redisTemplate.convertAndSend("test", "123");
	}

}
