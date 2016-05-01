package br.com.eshopper.ecommerce.controllers;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eshopper.ecommerce.models.ShoppingCart;
import br.com.eshopper.ecommerce.services.PaymentService;

@Controller
@RequestMapping("/payment")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ShoppingCart shoppingCart;
	
	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public Callable<ModelAndView> checkout(RedirectAttributes model) {
		return () -> {
			BigDecimal total = shoppingCart.getTotal();
			String uriToPay = "http://book-payment.herokuapp.com/payment";
			try {
				String response = restTemplate.postForObject(uriToPay,
						new PaymentData(total), String.class);

			//	paymentService.save();
			//	shoppingCart.clear();
				
				model.addFlashAttribute("sucesso", response);
				return new ModelAndView("redirect:/admin");
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				model.addFlashAttribute("falha", "Valor maior que o permitido");
				return new ModelAndView("redirect:/shopping");
			}

		};
	}

}
