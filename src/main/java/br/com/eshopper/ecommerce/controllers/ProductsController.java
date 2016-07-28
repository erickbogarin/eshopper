package br.com.eshopper.ecommerce.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eshopper.ecommerce.models.Brand;
import br.com.eshopper.ecommerce.models.Category;
import br.com.eshopper.ecommerce.models.Person;
import br.com.eshopper.ecommerce.models.Product;
import br.com.eshopper.ecommerce.services.ProductService;
import br.com.eshopper.ecommerce.supports.BrandEditor;
import br.com.eshopper.ecommerce.supports.CategoryEditor;
import br.com.eshopper.ecommerce.supports.PersonEditor;

@Controller
@RequestMapping("/admin")
public class ProductsController {


	@Autowired
	private ProductService productService;
	
	@Autowired 
	private CategoryEditor categoryEditor;
	
	@Autowired 
	private BrandEditor brandEditor;
	
	@Autowired 
	private PersonEditor personEditor; 

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		 binder.registerCustomEditor(Brand.class, this.brandEditor);
		 binder.registerCustomEditor(Category.class, this.categoryEditor);
		 binder.registerCustomEditor(Person.class, this.personEditor);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(MultipartFile smallPhoto, MultipartFile mediumPhoto, MultipartFile largePhoto,
			@Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return form(product);
		}
		
		productService.save(product, smallPhoto, mediumPhoto, largePhoto);
		
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping("/form")
	public ModelAndView form(Product product) {
		ModelAndView modelAndView = new ModelAndView("/admin/form");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("/admin/list");
		modelAndView.addObject("products", productService.list());

		return modelAndView;
	}

}
