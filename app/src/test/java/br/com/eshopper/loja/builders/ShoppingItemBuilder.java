package br.com.eshopper.loja.builders;

import java.util.ArrayList;
import java.util.List;

import br.com.eshopper.ecommerce.models.Product;
import br.com.eshopper.ecommerce.models.ShoppingItem;

public class ShoppingItemBuilder {
	
	private List<ShoppingItem> shoppingItem = new ArrayList<>();

	private ShoppingItemBuilder(ShoppingItem item) {
		shoppingItem.add(item);
	}
	
	public static ShoppingItemBuilder withProductId(Integer productId) {
		Product product = new Product();
		product.setId(productId);
		
		ShoppingItem item = createItem(product);
		return new ShoppingItemBuilder(item);
	}
	
	public static ShoppingItemBuilder withProduct(Product product) {
		ShoppingItem item = createItem(product);
		return new ShoppingItemBuilder(item);
	}
	
	private static ShoppingItem createItem(Product product) {
		return new ShoppingItem(product);
	}
	
	public ShoppingItemBuilder more(int number) {
		ShoppingItem item = shoppingItem.get(0);
		
		for(int i = 0; i < number; i++) {
			shoppingItem.add(createItem(item.getProduct()));
		}
		
		return this;
	}
	
	public ShoppingItem buildOne() {
		return shoppingItem.get(0);
	}
	
	public List<ShoppingItem> build() {
		return shoppingItem;
	}
	
}
