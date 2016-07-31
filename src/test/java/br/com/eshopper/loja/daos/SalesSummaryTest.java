package br.com.eshopper.loja.daos;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.eshopper.ecommerce.conf.AppWebConfiguration;
import br.com.eshopper.ecommerce.conf.JPAConfiguration;
import br.com.eshopper.ecommerce.conf.RedisConfiguration;
import br.com.eshopper.ecommerce.conf.SecurityConfiguration;
import br.com.eshopper.ecommerce.daos.SalesSummaryDAO;
import br.com.eshopper.ecommerce.models.SalesSummary;
import br.com.eshopper.loja.conf.JPADataSourceConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppWebConfiguration.class, JPAConfiguration.class, RedisConfiguration.class,
		SecurityConfiguration.class, JPADataSourceConfigurationTest.class })
@ActiveProfiles("dev")
public class SalesSummaryTest {

	private static final String PERIOD = LocalDate.now().getMonthOfYear() + "-" + LocalDate.now().getYear();

	@Autowired
	private SalesSummaryDAO summaryDataDao;

	@Autowired
	private SalesSummary salesSummary;

	@Test
	public void shouldInsertOrUpdateANewSummaryData() {
		
		salesSummary.setMonthlyProfit(BigDecimal.ZERO);
		salesSummary.setMonthPurchaseTotal(1);
		summaryDataDao.save(salesSummary);
		
		assertNotNull(summaryDataDao.findAll());
	}
	
	@Test
	public void shouldFindTheLastInsertedKey() {
		assertNotNull(summaryDataDao.find(PERIOD));
	}

}
