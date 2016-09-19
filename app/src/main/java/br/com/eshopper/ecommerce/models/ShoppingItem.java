package br.com.eshopper.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class ShoppingItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Product product;
	private Integer productId;
	
	public ShoppingItem() {
	}
	
	public static ShoppingItem zeroed() {
		Product product = new Product();
		return new ShoppingItem(product);
	}

	public ShoppingItem(Product product) {
		this.product = product;
		this.productId = product.getId();
	}

	public Product getProduct() {
		return product;
	}

	public BigDecimal getPrice() {
		return product.getPrice();
	}
	
	public BigDecimal getTotal(Integer quantity) {
		return getPrice().multiply(new BigDecimal(quantity));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingItem other = (ShoppingItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
}
