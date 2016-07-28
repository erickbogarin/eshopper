package br.com.casadocodigo.loja.builders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.eshopper.ecommerce.models.Product;
import br.com.eshopper.ecommerce.models.ShoppingCart;
import br.com.eshopper.ecommerce.models.ShoppingItem;

public class ShoppingCartBuilder {
	
	@Autowired
	private ShoppingCart cart;
	
	private List<ShoppingItem> items = new ArrayList<>();
	
	private ShoppingCartBuilder(ShoppingItem item) {
		items.add(item);
	}
	
	public static ShoppingCartBuilder newCart() {
		Product product = ProductBuilder.newProduct().buildOne();
		ShoppingItem item = ShoppingItemBuilder.withProduct(product).buildOne();
		return new ShoppingCartBuilder(item);
	}
	
	public static ShoppingCartBuilder withItem(ShoppingItem item) {
		return new ShoppingCartBuilder(item);
	}
	
	public ShoppingCartBuilder more(int number) {
		ShoppingItem item = items.get(0);
		
		for (int i = 0; i < number; i++) {
			items.add(item);
		}
		
		return this;
	}
	
	public ShoppingCart buildOne() {
		cart.add(items.get(0));
		return cart;
	}
	
	public ShoppingCart build() {
		items.forEach(cart::add);
		return cart;
	}
	
	
}
