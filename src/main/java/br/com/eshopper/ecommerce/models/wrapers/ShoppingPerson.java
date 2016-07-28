package br.com.eshopper.ecommerce.models.wrapers;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.eshopper.ecommerce.models.BrandType;
import br.com.eshopper.ecommerce.models.CategoryType;
import br.com.eshopper.ecommerce.models.PersonType;

@Component
public class ShoppingPerson {
	
	private String product;
	private Calendar purchaseDate;
	private Long quantity;
	private BigDecimal total;
	private PersonType personType;
	private CategoryType categoryType;
	private BrandType brandType;
	
	public ShoppingPerson() {
	}
	
	public ShoppingPerson(String product, Calendar purchaseDate, Long quantity, BigDecimal total, PersonType personType, CategoryType categoryType,
			BrandType brandType) {
		this.product = product;
		this.purchaseDate = purchaseDate;
		this.quantity = quantity;
		this.total = total;
		this.personType = personType;
		this.categoryType = categoryType;
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
	public String getPersonType() {
		return personType.name();
	}
	public String getCategoryType() {
		return categoryType.name();
	}
	public String getBrandType() {
		return brandType.name();
	}
	
}
