package br.com.eshopper.ecommerce.models;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ShoppingItemTest {
	
	@Test
	public void shoudCalculateThePriceOfOneProduct() {
		BigDecimal expectedPrice = BigDecimal.valueOf(34.5);

		Product product = new Product(50, expectedPrice);
		ShoppingItem item = new ShoppingItem(product);
		
		assertEquals(expectedPrice, item.getPrice());
	}
	
	@Test
	public void shoudCalculateTotalPriceOfFiveProducts() {
		BigDecimal price = BigDecimal.valueOf(55.5);
		int quantity = 5;
		BigDecimal expectedPrice = price.multiply(BigDecimal.valueOf(quantity));

		Product product = new Product(150, price);
		ShoppingItem item = new ShoppingItem(product);

		assertEquals(expectedPrice, item.getTotal(quantity));
	}
	
}
