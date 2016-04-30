package br.com.eshopper.ecommerce.controllers.integrations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eshopper.ecommerce.daos.PurchaseDAO;
import br.com.eshopper.ecommerce.models.Purchase;

@RestController
@RequestMapping(value = "/v1/purchase")
public class PurchaseRestController {
	
	@Autowired
	private PurchaseDAO purchaseDao;
	
	@RequestMapping(method =  RequestMethod.GET)
	public List<Purchase> latestPurchase() {
		return purchaseDao.latestPurchase();
	}
	
}
