package br.com.eshopper.ecommerce.models.wrapers;

import java.math.BigDecimal;

public class BestSallers {
	
	private Integer id;
	private String name;
	private Long quantity;
	private BigDecimal total;
	
	public BestSallers(Integer id, String name, Long quantity, BigDecimal total) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public BigDecimal getTotal() {
		return total;
	}
	
}
