package br.com.eshopper.ecommerce.models;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import br.com.casadocodigo.loja.builders.ProductBuilder;

public class ShoppingItemTest {
	
	@Test
	public void shoudCalculateThePriceOfItemWithOneProductOnly() {
		BigDecimal expectedPrice = BigDecimal.valueOf(34.5);
		Product product = ProductBuilder.newProduct(expectedPrice).buildOne();
		
		ShoppingItem item = new ShoppingItem(product);
		BigDecimal total = item.getTotal(1);
		
		assertEquals(expectedPrice, total);
	}
	
	@Test
	public void shouldCalculateThePriceOfTheProductItemByQuantityIndicated() {
		List<Product> products = ProductBuilder.newProduct(BigDecimal.valueOf(40.5)).more(2).buildAll();
			
		BigDecimal expectedResult = products.stream()
				.map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
		
		ShoppingItem item = products.stream().map(ShoppingItem::new).collect(toList()).get(0);
		BigDecimal total = item.getTotal(products.size());
		
		assertEquals(expectedResult, total);
	}
	
	

}
