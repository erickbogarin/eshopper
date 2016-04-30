package br.com.eshopper.ecommerce.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eshopper.ecommerce.daos.SummaryDataDAO;
import br.com.eshopper.ecommerce.models.Purchase;
import br.com.eshopper.ecommerce.models.SummaryData;

@Service
public class SummaryDataService {

	@Autowired
	private SummaryDataDAO summaryDataDAO;

	@Autowired
	private SummaryData summaryData;
	
	private Purchase purchase;
	
	public void trace(Purchase purchase) {
		this.purchase = purchase;

		checkoutPeriod();
		summaryDataDAO.save(summaryData);
	}

	private void checkoutPeriod() {
		
		this.summaryData = summaryDataDAO.find(summaryData.getPeriod());
		if (summaryData == null) { 
			
			summaryData = new SummaryData();
			summaryData.initialize();
		} 
			
		summaryData.setMonthPurchaseTotal(totalPurchase());
		summaryData.setMonthlyProfit(totalProfit());
	}

	private BigDecimal totalProfit() {
		return summaryData.getMonthlyProfit().add(purchase.getPrice());
	}
	
	private Integer totalPurchase() {
		return summaryData.getMonthPurchaseTotal() + purchase.getProductsQuantity();
	}
	
}
