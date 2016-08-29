package br.com.eshopper.ecommerce.system;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.eshopper.ecommerce.pages.ShoppingCartPage;
import br.com.eshopper.loja.builders.ScenarioBuilder;

public class ShoppingCartSystemTest {
	
	WebDriver driver;
	private ShoppingCartPage shoppingCart;
	
	@Before
	public void init() {
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "src/test/resources/phantomjs.exe"
        );

        driver = new PhantomJSDriver(caps);
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
