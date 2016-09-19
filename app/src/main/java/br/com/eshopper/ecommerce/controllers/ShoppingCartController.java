package br.com.eshopper.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.eshopper.ecommerce.daos.ProductDAO;
import br.com.eshopper.ecommerce.models.Product;
import br.com.eshopper.ecommerce.models.ShoppingCart;
import br.com.eshopper.ecommerce.models.ShoppingItem;

@Controller
@RequestMapping("/shopping")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ShoppingCartController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ShoppingCart shoppingCart;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView add(Integer productId) {
        ShoppingItem item = createItem(productId);
        shoppingCart.add(item);
        return new ModelAndView("redirect:/shopping");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String items() {
        return "shoppingCart/items";
    }
    
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public ModelAndView remove(Integer productId) {
    	shoppingCart.remove(createItem(productId));
    	return new ModelAndView("redirect:/shopping");
    }
    
    private ShoppingItem createItem(Integer productId) {
        Product product = productDAO.find(productId);
        return new ShoppingItem(product);
    }

}
