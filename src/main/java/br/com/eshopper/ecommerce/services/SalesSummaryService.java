package br.com.eshopper.ecommerce.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eshopper.ecommerce.daos.SalesSummaryDAO;
import br.com.eshopper.ecommerce.models.Purchase;
import br.com.eshopper.ecommerce.models.SalesSummary;

@Service
public class SalesSummaryService {

	@Autowired
	private SalesSummaryDAO summaryDataDAO;

	@Autowired
	private SalesSummary salesSummary;
	
	private Purchase purchase;
	
	public void trace(Purchase purchase) {
		this.purchase = purchase;

		checkoutPeriod();
		summaryDataDAO.save(salesSummary);
	}

	private void checkoutPeriod() {
		
		this.salesSummary = summaryDataDAO.find(salesSummary.getPeriod());
		if (salesSummary == null) { 
			this.salesSummary = new SalesSummary();
			this.salesSummary.initialize();
		} 

		this.salesSummary.setMonthPurchaseTotal(sumTotalPurchase());
		this.salesSummary.setMonthlyProfit(sumTotalProfit());
	}

	private BigDecimal sumTotalProfit() {
		return salesSummary.getMonthlyProfit().add(purchase.getPrice());
	}
	
	private Integer sumTotalPurchase() {
		return salesSummary.getMonthPurchaseTotal() + purchase.getProductsQuantity();
	}
	
}
