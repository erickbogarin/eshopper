package br.com.eshopper.ecommerce.servicelayer;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.eshopper.ecommerce.daos.PurchaseDAO;
import br.com.eshopper.ecommerce.daos.SalesSummaryDAO;
import br.com.eshopper.ecommerce.daos.UserDAO;
import br.com.eshopper.ecommerce.models.CorreiosDto;
import br.com.eshopper.ecommerce.models.Purchase;
import br.com.eshopper.ecommerce.models.PurchaseStatus;
import br.com.eshopper.ecommerce.models.Sale;
import br.com.eshopper.ecommerce.models.SalesSummary;
import br.com.eshopper.ecommerce.models.ShoppingCart;

@Service
@Transactional
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PaymentService {
	
	@Autowired
	private CorreiosDto correios;
	
	@Autowired
	private PurchaseDAO purchaseDAO;
	
	@Autowired
	private Purchase purchase;
	
	@Autowired
	private SalesSummaryDAO summaryDataDAO;
	
	@Autowired
	private ShoppingCart shoppingCart;
	
	@Autowired
	private UserDAO userDao;
	
	public void save() {
		registerPayment();
		recordPayment();
		correios.clear();
	}
	
	private void registerPayment() {
		purchase.setPrice(shoppingCart.getTotal());
		purchase.chargeFreight(correios.getFreight());
		purchase.setProductsQuantity(shoppingCart.getQuantity());
		purchase.setPurchaseDate(Calendar.getInstance());
		purchase.setPurchaseStatus(PurchaseStatus.Pago);
		
		// should be a logged in user but was left that way for the site to be demo
		purchase.setUser(userDao.find("visitante@email.com"));
		
		// Create Sales based on each ShoppingItem from a ShoppingCart
		shoppingCart.getList().forEach(shoppingItem -> {
			purchase.addSale(
							new Sale(shoppingCart.getQuantity(shoppingItem), 
							 	shoppingCart.getTotal(shoppingItem), 
							 		shoppingItem.getProduct()));
		});
		
		purchaseDAO.save(purchase);
	}
	
	private void recordPayment() {
		String currentPeriod = SalesSummary.getCurrentPeriod();
		SalesSummary currentSummary = summaryDataDAO.find(currentPeriod);
		
		SalesSummary billedSummary = SalesSummary.ofPeriod(currentSummary, purchase);
		summaryDataDAO.save(billedSummary);
	}
}
