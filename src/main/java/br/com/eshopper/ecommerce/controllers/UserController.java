package br.com.eshopper.ecommerce.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eshopper.ecommerce.models.SystemUser;
import br.com.eshopper.ecommerce.services.UserService;

@Controller
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView register(@Valid SystemUser user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("/login");
		}
		
		userService.save(user);
		
		redirectAttributes.addFlashAttribute("sucesso", "Cadastro realizado com sucesso.");
		return new ModelAndView("redirect:/login");
	}
	
}
