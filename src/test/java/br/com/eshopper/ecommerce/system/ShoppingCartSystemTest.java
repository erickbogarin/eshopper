package br.com.eshopper.ecommerce.system;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.eshopper.ecommerce.pages.ShoppingCartPage;
import br.com.eshopper.loja.builders.ScenarioBuilder;

public class ShoppingCartSystemTest {

	WebDriver driver;
	private ShoppingCartPage shoppingCart;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		
		this.driver = new ChromeDriver();
		shoppingCart =  new ShoppingCartPage(driver);
		
		new ScenarioBuilder(driver).addOneProduct();
	}

	@Test
	public void shouldIncreaseAmountOfTheShoppingItem() {
		shoppingCart.assertAmount(1)
				.increaseAmount()
				.assertChangedAmount(2);
	}
	
	@Test
	public void shouldDecreaseAmountOfTheShoppingItem() {
		shoppingCart.assertAmount(1)
				.increaseAmount()
				.increaseAmount()
				.decreaseAmount()
				.assertChangedAmount(2);
	}
}
