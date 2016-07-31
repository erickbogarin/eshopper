package br.com.eshopper.loja.builders;

import java.util.ArrayList;
import java.util.List;

import br.com.eshopper.ecommerce.models.ShoppingCart;
import br.com.eshopper.ecommerce.models.ShoppingItem;

public class ShoppingCartBuilder {
	
	private ShoppingCart shoppingCart = new ShoppingCart();
	private List<ShoppingItem> items = new ArrayList<>();
	
	private ShoppingCartBuilder(ShoppingItem... items) {
		for (ShoppingItem shoppingItem : items) {
			this.items.add(shoppingItem);
		}
	}
	
	public static ShoppingCartBuilder newCart() {
		ShoppingItem item = ShoppingItemBuilder.withProductId(1).buildOne();
		return new ShoppingCartBuilder(item);
	}
	
	public static ShoppingCartBuilder newCart(ShoppingItem... item) {
		return new ShoppingCartBuilder(item);
	}
	
	public ShoppingCartBuilder withItem(ShoppingItem item) {
		this.items.add(item);
		return this;
	}
	
	public ShoppingCartBuilder more(int number) {
		ShoppingItem item = items.get(0);
		
		for (int i = 0; i < number; i++) {
			items.add(item);
		}
		
		return this;
	}
	
	public ShoppingCart build() {
		items.forEach(shoppingCart::add);
		return shoppingCart;
	}
	
	
}
