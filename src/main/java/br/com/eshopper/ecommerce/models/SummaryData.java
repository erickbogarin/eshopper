package br.com.eshopper.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class SummaryData implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String OBJECT_KEY = "SummaryData";
	
	private String period;
	private BigDecimal monthlyProfit;
	private Integer monthPurchaseTotal;
	
	public SummaryData() {
		this.period = LocalDate.now().getMonthOfYear() + "-" + LocalDate.now().getYear();
	}
	
	public String getPeriod() {
		return period;
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

	public void initialize() {
		this.monthlyProfit = BigDecimal.ZERO;
		this.monthPurchaseTotal = 0;
	}

	@Override
	public String toString() {
		return "SummaryData [period=" + period + ", monthlyProfit=" + monthlyProfit + ", monthPurchaseTotal="
				+ monthPurchaseTotal + "]";
	}

	public void setMonth(Integer month) {
		this.period = month + "-" + LocalDate.now().getYear();
	}
	
	public void setYear(Integer year) {
		this.period = LocalDate.now().getMonthOfYear() + "-" + year;
	}
	
}
