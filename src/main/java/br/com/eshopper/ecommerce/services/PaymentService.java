package br.com.eshopper.ecommerce.services;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.eshopper.ecommerce.daos.PurchaseDAO;
import br.com.eshopper.ecommerce.daos.UserDAO;
import br.com.eshopper.ecommerce.models.Purchase;
import br.com.eshopper.ecommerce.models.PurchaseStatus;
import br.com.eshopper.ecommerce.models.Sale;
import br.com.eshopper.ecommerce.models.ShoppingCart;
import br.com.eshopper.ecommerce.models.ShoppingItem;
import br.com.eshopper.ecommerce.models.User;

@Service
@Transactional
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PaymentService {
	
	@Autowired
	private PurchaseDAO purchaseDAO;
	@Autowired
	private SummaryDataService summaryDataService;
	@Autowired
	private UserDAO userDao;
	private Purchase purchase;
	private ShoppingCart shoppingCart;
	
	@Autowired
	public PaymentService(Purchase purchase, ShoppingCart shoppingCart) {
		this.purchase = purchase;
		this.shoppingCart = shoppingCart;
	}
	
	@PostConstruct
	public void createPurchase() {
		
		purchase.setPrice(shoppingCart.getTotal());
		purchase.setProductsQuantity(shoppingCart.getQuantity());
		purchase.setPurchaseDate(Calendar.getInstance());
		purchase.setPurchaseStatus(PurchaseStatus.Pago);
		purchase.setUser(checkUser());
	}

	public void save() {
		
		lookForSalesAndSaveEachOne();
		summaryDataService.trace(purchase);
		
		purchaseDAO.save(purchase);
	}

	private void lookForSalesAndSaveEachOne() {
		shoppingCart.getList().forEach(item -> addSale(createSale(item)));
	}

	public void addSale(Sale sale) {
		
		sale.setPurchase(purchase);
		purchase.addSale(sale);
	}

	private Sale createSale(ShoppingItem item) {
		
		return new Sale(
				shoppingCart.getQuantity(item), 
				shoppingCart.getTotal(item), item.getProduct());
	}

	private User checkUser() {

		/*if(SecurityContextHolder.getContext().getAuthentication() != null)
			return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();*/

		return userDao.find("visitante@email.com");
	}

}
