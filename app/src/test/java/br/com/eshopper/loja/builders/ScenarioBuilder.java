package br.com.eshopper.loja.builders;

import org.openqa.selenium.WebDriver;

import br.com.eshopper.ecommerce.pages.ProductDetailPage;

public class ScenarioBuilder {
	
	private WebDriver driver;

	public ScenarioBuilder(WebDriver driver) {
		this.driver = driver;
	}

	public ScenarioBuilder addOneProduct() {
		ProductDetailPage productDetail = new ProductDetailPage(driver);
		productDetail.visit();
		productDetail.addToShoppingCart();
		return this;
	}
	
}
