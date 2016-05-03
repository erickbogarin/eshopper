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
		Product book = create("T-shirt", value);
		return new ProductBuilder(book);
	}

	public static ProductBuilder newProduct() {
		Product book = create("Hat", BigDecimal.TEN);
		return new ProductBuilder(book);
	}

	private static Product create(String bookName, BigDecimal value) {
		Product book = new Product();
		book.setName(bookName);
		
		book.setDescription("great book about testing");
		return book;
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
