package br.com.eshopper.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.eshopper.ecommerce.system.ApplicationURL;

public class ProductDetailPage {
	
	private WebDriver driver;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ProductDetailPage visit() {
		driver.get(ApplicationURL.ADDRESS + "produtos/camisa-nike-new-orleans-saints-masculina");
		return this;
	}

	public ProductDetailPage addToShoppingCart() {
		driver.findElement(By.id("addCart")).submit();
		return this;
	}
	
}
