package br.com.casadocodigo.loja.builders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.eshopper.ecommerce.models.Product;

public class ProductBuilder {

	private List<Product> products = new ArrayList<Product>();
	
	private ProductBuilder(Product product) {
		products.add(product);
	}
	
	public static ProductBuilder newProduct(BigDecimal value) {
		Product tShirt = create("T-shirt", value);
		return new ProductBuilder(tShirt);
	}

	public static ProductBuilder newProduct() {
		Product hat = create("Hat", BigDecimal.TEN);
		return new ProductBuilder(hat);
	}

	private static Product create(String productName, BigDecimal value) {
		Product product = new Product();
		product.setPrice(value);
		product.setName(productName);
		
		product.setDescription("great t-shirt to wear");
		return product;
	}

	public ProductBuilder more(int number) {
		Product base = products.get(0);
		
		for (int i = 0; i < number; i++) {
			products.add(create("Pants" + i, base.getPrice()));
		}
		return this;
	}
	
	public Product buildOne() {
		return products.get(0);
	}

	public List<Product> buildAll() {
		return products;
	}

}
