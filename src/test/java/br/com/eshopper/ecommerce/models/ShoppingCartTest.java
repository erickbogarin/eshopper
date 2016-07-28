package br.com.eshopper.ecommerce.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import br.com.casadocodigo.loja.builders.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ShoppingCart.class, CorreiosDto.class })
@WebAppConfiguration
public class ShoppingCartTest {

	@Test
	public void test() {
		ShoppingCart cart = ShoppingCartBuilder.newCart().buildOne();
		assertEquals(1, cart.getList());
	}
	
//	@Autowired
//	private ShoppingCart shoppingCart;
//	private List<ShoppingItem> shoppingItem;
//	private static Integer CART_SIZE;
//	
//	@Before
//	public void init() {
//		CART_SIZE = 5;
//		createCart();
//	}
//	
//	@Test
//	public void shoultInsertItemsInCart() {
//		assertEquals(shoppingCart.getQuantity(), Integer.valueOf(CART_SIZE));
//	}
//	
//	@Test
//	public void shoultRemoveItemsInCart() {
//		shoppingItem.stream().forEach(shoppingCart::remove);
//		assertEquals(shoppingCart.getQuantity(), Integer.valueOf(0));
//	}
//	
//	@Test
//	public void shoultChangeAmountInCart() {
//		int newQuantity = 10;
//		shoppingCart.changeQuantity(shoppingItem.get(0), newQuantity);
//		assertEquals(shoppingCart.getQuantity(), Integer.valueOf(newQuantity));
//	}
//	
//	@Test
//	public void shoultDecraseItemsInCart() {
//		shoppingCart.decreaseItem(shoppingItem.get(0));
//		assertEquals(shoppingCart.getQuantity(), Integer.valueOf(CART_SIZE-1));
//	}
//	
//	@Test
//	public void shouldAddAndSunRepeatedItemButConsiderLikeAsJustOne() {
//		BigDecimal price = new BigDecimal("100");
//		Product tennis = ProductBuilder.newProduct(price).buildOne();
//		tennis.setId(99);
//		
//		ShoppingItem newItem = new ShoppingItem(tennis);
//		ShoppingItem repeatedItem = new ShoppingItem(tennis);
//		shoppingCart.add(newItem);
//		shoppingCart.add(repeatedItem);
//		
//		assertEquals(shoppingCart.getTotal(newItem), new BigDecimal("200"));
//		assertEquals(shoppingCart.getQuantity(newItem), Integer.valueOf(2));
//	}
//
//	
//	@Test
//	public void shouldChangeQuantityOfRepeatedItem() {
//		BigDecimal price = new BigDecimal("100");
//		Product tennis = ProductBuilder.newProduct(price).buildOne();
//		tennis.setId(99);
//		
//		ShoppingItem newItem = new ShoppingItem(tennis);
//		ShoppingItem repeatedItem = new ShoppingItem(tennis);
//		shoppingCart.add(newItem);
//		shoppingCart.add(repeatedItem);
//		
//		shoppingCart.decreaseItem(repeatedItem);
//		
//		assertEquals(shoppingCart.getTotal(newItem), new BigDecimal("100"));
//		assertEquals(shoppingCart.getQuantity(newItem), Integer.valueOf(1));
//	}
//
//	
//	private void createCart() {
//		List<Product> products = ProductBuilder.newProduct(BigDecimal.TEN).more(CART_SIZE++).buildAll();
//		shoppingItem = products.stream().map(ShoppingItem::new).collect(toList());
//		shoppingItem.stream().forEach(shoppingCart::add);
//	}

}
