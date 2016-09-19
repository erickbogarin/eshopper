package br.com.eshopper.ecommerce.models;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.eshopper.loja.builders.ShoppingItemBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ShoppingCart.class })
@WebAppConfiguration
public class ShoppingCartTest {
	
	@Autowired
	private ShoppingCart shoppingCart;
	
	@Test
	public void shouldChangeAmountOfOneItemFromAShoppingCart() {
		ShoppingItem item = ShoppingItemBuilder.withProductId(112).buildOne();
		shoppingCart.add(item);
		
		int amountExpected = 5;
		shoppingCart.changeQuantity(item, amountExpected);

		assertEquals(amountExpected, shoppingCart.getQuantity(item).intValue());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotChangeInvalidAmountOfAnItem() {
		ShoppingItem item = ShoppingItemBuilder.withProductId(112).buildOne();
		shoppingCart.add(item);

		Integer invalidAmount = 0;
		
		shoppingCart.changeQuantity(item, invalidAmount);
	}

	@Test
	public void shouldDecreaseOneItemFromAShoppingCart() {
		ShoppingItem item = ShoppingItemBuilder.withProductId(33).buildOne();
		shoppingCart.add(item);
		shoppingCart.add(item);

		shoppingCart.decreaseItem(item);

		assertEquals(1, shoppingCart.getQuantity(item).intValue());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotDecreaseInvalidAmountOfAnItem() {
		ShoppingItem item = ShoppingItemBuilder.withProductId(1344).buildOne();
		shoppingCart.add(item);

		shoppingCart.decreaseItem(item);
		shoppingCart.decreaseItem(item);
		shoppingCart.decreaseItem(item);
	}

	@Test
	public void shoudtIncraseAmountOfItems() {
		ShoppingItem item = ShoppingItemBuilder.withProductId(513).buildOne();

		shoppingCart.add(item);
		shoppingCart.add(item);
		shoppingCart.add(item);

		assertEquals(3, shoppingCart.getQuantity().intValue());
	}

	@Test
	public void shoultRemoveOneItemFromAShoppingCart() {
		ShoppingItem itemToBeRemoved = ShoppingItemBuilder.withProductId(1).buildOne();
		ShoppingItem itemToRemain = ShoppingItemBuilder.withProductId(2).buildOne();
		shoppingCart.add(itemToRemain);
		shoppingCart.add(itemToBeRemoved);
	
		shoppingCart.remove(itemToBeRemoved);

		assertFalse(shoppingCart.getList().contains(itemToBeRemoved));
		assertTrue(shoppingCart.getList().contains(itemToRemain));
		assertEquals(1, shoppingCart.getQuantity().intValue());
	}

	@Test
	public void shoultInsertDiferentsItemsInToShoppingCart() {
		ShoppingItem itemOne = ShoppingItemBuilder
				.withProduct(new Product(1, new BigDecimal("34.50")))
					.buildOne();
		ShoppingItem itemTwo = ShoppingItemBuilder
				.withProduct(new Product(2, new BigDecimal("40.50")))
					.buildOne();
		
		shoppingCart.add(itemOne);
		shoppingCart.add(itemTwo);

		assertEquals(2, shoppingCart.getList().size());
		assertEquals(new BigDecimal("75.00"), shoppingCart.getTotal());
	}

	@Test
	public void shouldInsertAndIncreaseRepeatedItemsButConsiderLikeAsJustOneItem() {
		ShoppingItem item = ShoppingItemBuilder.withProduct(
					new Product(1, new BigDecimal("100.00"))
				).buildOne();
		
		shoppingCart.add(item);
		shoppingCart.add(item);
		shoppingCart.add(item);
		shoppingCart.add(item);
		shoppingCart.add(item);
		shoppingCart.add(item);
		
		assertEquals(1, shoppingCart.getList().size());
		assertEquals(6, shoppingCart.getQuantity(item).intValue());
		assertEquals(new BigDecimal("600.00"), shoppingCart.getTotal());
	}
	
}