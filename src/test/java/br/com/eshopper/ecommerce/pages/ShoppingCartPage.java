package br.com.eshopper.ecommerce.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.eshopper.ecommerce.system.ApplicationURL;

public class ShoppingCartPage {

	private WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public ShoppingCartPage visit() {
		driver.get(ApplicationURL.ADDRESS + "shopping");
		return this;
	}

	public ShoppingCartPage increaseAmount() {
		driver.findElement(By.id("increase-item")).click();
		return this;
	}
	
	public ShoppingCartPage decreaseAmount() {
		driver.findElement(By.id("decrease-item")).click();
		return this;
	}
	
	public ShoppingCartPage assertAmount(int expectedAmount) {
		String amount = driver.findElement(By.name("quantity")).getAttribute("value");
		assertTrue(amount.equals(String.valueOf(expectedAmount)));
		return this;
	}

	public ShoppingCartPage assertChangedAmount(int expectedAmount) {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		assertTrue(wait.until(
				ExpectedConditions.textToBePresentInElementValue(By.name("quantity"), String.valueOf(expectedAmount))));
		return this;
	}

}
