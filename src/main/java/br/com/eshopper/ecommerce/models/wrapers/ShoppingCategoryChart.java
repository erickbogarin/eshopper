package br.com.eshopper.ecommerce.models.wrapers;

import java.math.BigDecimal;

public class ShoppingCategoryChart {
	
	private Integer month;
	private BigDecimal total;
	
	public ShoppingCategoryChart(Integer month, BigDecimal total) {
		this.month = month;
		this.total = total;
	}

	public Integer getMonth() {
		return month;
	}
	
	public BigDecimal getTotal() {
		return total;
	}
	
}
