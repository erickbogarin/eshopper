package br.com.eshopper.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class SalesSummary implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String OBJECT_KEY = "SalesSummary";
	
	private String period;
	private BigDecimal monthlyProfit;
	private Integer monthPurchaseTotal;
	
	public String getPeriod() {
		return period;
	}
	
	public SalesSummary() {
		this.period = LocalDate.now().getMonthOfYear() + "-" + LocalDate.now().getYear();
	}
	
	public static String getCurrentPeriod() {
		return LocalDate.now().getMonthOfYear() + "-" + LocalDate.now().getYear();
	}
	
	public void setPeriod(Integer month, Integer year) {
		this.period = month + "-" + year;
	}
	
	public BigDecimal getMonthlyProfit() {
		return monthlyProfit;
	}

	public void setMonthlyProfit(BigDecimal monthlyProfit) {
		this.monthlyProfit = monthlyProfit;
	}

	public Integer getMonthPurchaseTotal() {
		return monthPurchaseTotal;
	}

	public void setMonthPurchaseTotal(Integer monthPurchaseTotal) {
		this.monthPurchaseTotal = monthPurchaseTotal;
	}

	public void resetNewSummary() {
		this.monthlyProfit = BigDecimal.ZERO;
		this.monthPurchaseTotal = 0;
	}

	public void setMonth(Integer month) {
		this.period = month + "-" + LocalDate.now().getYear();
	}
	
	public void setYear(Integer year) {
		this.period = LocalDate.now().getMonthOfYear() + "-" + year;
	}
	
	@Override
	public String toString() {
		return "SalesSummary [period=" + period + ", monthlyProfit=" + monthlyProfit + ", monthPurchaseTotal="
				+ monthPurchaseTotal + "]";
	}

	public static SalesSummary ofPeriod(SalesSummary currentResume, Purchase purchase) {
		if (currentResume == null) { 
			currentResume = new SalesSummary();
			currentResume.resetNewSummary();
		} 
		
		Integer totalMonthlyAmount = currentResume.getMonthPurchaseTotal() + purchase.getProductsQuantity();
		BigDecimal totalMonthlyPrice = currentResume.getMonthlyProfit().add(purchase.getPrice());
		
		currentResume.setMonthPurchaseTotal(totalMonthlyAmount);
		currentResume.setMonthlyProfit(totalMonthlyPrice);
		
		return currentResume;
	}
}
