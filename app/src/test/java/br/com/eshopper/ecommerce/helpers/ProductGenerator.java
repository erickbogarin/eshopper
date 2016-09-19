package br.com.eshopper.ecommerce.helpers;

import java.util.ArrayList;
import java.util.List;

import br.com.eshopper.ecommerce.models.Product;

public final class ProductGenerator {
	
	public static List<Product> generateProducts(Product... products) {
		List<Product> productsGenerated = new ArrayList<Product>();
		
		for (Product product : products) {
			productsGenerated.add(product);
		}
		
		return productsGenerated;
	}
	
}
