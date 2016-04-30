package br.com.eshopper.ecommerce.controllers.integrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import br.com.eshopper.ecommerce.daos.ProductDAO;
import br.com.eshopper.ecommerce.models.CartDto;
import br.com.eshopper.ecommerce.models.ShoppingCart;
import br.com.eshopper.ecommerce.models.ShoppingItem;

/**
 * Created by Erick on 04/04/2016.
 */
@RestController
@RequestMapping(value = "/v1/shopping")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ShoppingCartRestController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ShoppingCart shoppingCart;

    private ShoppingItem item;
    
    @RequestMapping(value = "/increaseItem")
    public CartDto increaseItem(@RequestParam(value="productId") Integer productId) {
        shoppingCart.add(createItem(productId));
        return createCartDto();
    }

    @RequestMapping(value = "/decreaseItem")
    public CartDto decreaseItem(@RequestParam(value="productId") Integer productId) {
        shoppingCart.decreaseItem(createItem(productId));
        return createCartDto();
    }
    
    @RequestMapping(value = "/changeItemQuantity")
    public CartDto changeQuantity(@RequestParam(value="productId") Integer productId, @RequestParam(value="quantity") Integer quantity) {
    	shoppingCart.changeQuantity(createItem(productId), quantity);
    	return createCartDto();
    }
    
    @Cacheable("cartItem")
    private ShoppingItem createItem(Integer productId) {
    	item = new ShoppingItem(productDAO.find(productId));
        return item;
    }

    private CartDto createCartDto() {
        return new CartDto()
                .quantityItem(shoppingCart.getQuantity(item))
                	.quantityTotal(shoppingCart.getQuantity())
                		.priceItem(shoppingCart.getTotal(item))
                			.priceSubTotal(shoppingCart.getSubTotal())
                				.priceTotal(shoppingCart.getTotal());
    }

}
