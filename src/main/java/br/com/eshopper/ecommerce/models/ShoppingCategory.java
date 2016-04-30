package br.com.eshopper.ecommerce.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCategory {

	private String product;
	private Calendar purchaseDate;
	private Long quantity;
	private BigDecimal total;
	private CategoryType categoryType;
	private BrandType brandType;
	private PersonType personType;
	
	public ShoppingCategory() {
	}
	
	public ShoppingCategory(String product, Calendar purchaseDate, Long quantity, BigDecimal total, CategoryType categoryType, PersonType personType, BrandType brandType) {
		this.product = product;
		this.purchaseDate = purchaseDate;
		this.quantity = quantity;
		this.total = total;
		this.categoryType = categoryType;
		this.personType = personType;
		this.brandType = brandType;
	}

	public String getProduct() {
		return product;
	}

	public Date getPurchaseDate() {
		return purchaseDate.getTime();
	}

	public Long getQuantity() {
		return quantity;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public String getCategoryType() {
		return categoryType.name();
	}

	public String getPersonType() {
		return personType.name();
	}
	
	public String getBrandType() {
		return brandType.name();
	}

	@Override
	public String toString() {
		return "CategoryBusinessDriver [product=" + product + ", quantity="
				+ quantity + ", total=" + total + ", categoryType=" + categoryType + ", brandType=" + brandType + "] \n";
	}
	
}
