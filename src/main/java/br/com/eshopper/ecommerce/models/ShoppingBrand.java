package br.com.eshopper.ecommerce.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.eshopper.ecommerce.models.BrandType;
import br.com.eshopper.ecommerce.models.CategoryType;
import br.com.eshopper.ecommerce.models.PersonType;

@Component
public class ShoppingBrand {

	private String product;
	private Calendar purchaseDate;
	private Long quantity;
	private BigDecimal total;
	private CategoryType categoryType;
	private PersonType personType;
	private BrandType brandType;
	
	public ShoppingBrand() {
	}
	
	public ShoppingBrand(String product, Calendar purchaseDate, Long quantity, BigDecimal total,
			CategoryType categoryType, PersonType personType, BrandType brandType) {
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

}
