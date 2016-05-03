package br.com.casadocodigo.loja.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.casadocodigo.loja.conf.JPADataSourceConfigurationTest;
import br.com.eshopper.ecommerce.conf.AppWebConfiguration;
import br.com.eshopper.ecommerce.conf.JPAConfiguration;
import br.com.eshopper.ecommerce.conf.RedisConfiguration;
import br.com.eshopper.ecommerce.conf.SecurityConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppWebConfiguration.class, JPAConfiguration.class, RedisConfiguration.class, SecurityConfiguration.class,
		JPADataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProductsControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	// pq tem apenas esse filtro
	@Autowired
	private Filter springSecurityFilterChain;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilters(springSecurityFilterChain).build();
	}

	@Test
	public void onlyAdminShoudAccessProductsForm() throws Exception {
		// poderia usar o isFound()
		this.mockMvc.perform(get("/admin/form").with(
				SecurityMockMvcRequestPostProcessors.user("comprador@gmail.com").password("123456").roles("COMPRADOR")))
				.andExpect(status().is(403));
	}

}
