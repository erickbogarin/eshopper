package br.com.eshopper.ecommerce.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eshopper.ecommerce.daos.ProductDAO;
import br.com.eshopper.ecommerce.infra.FileSaver;
import br.com.eshopper.ecommerce.models.Brand;
import br.com.eshopper.ecommerce.models.Category;
import br.com.eshopper.ecommerce.models.Person;
import br.com.eshopper.ecommerce.models.Product;
import br.com.eshopper.ecommerce.supports.BrandEditor;
import br.com.eshopper.ecommerce.supports.CategoryEditor;
import br.com.eshopper.ecommerce.supports.PersonEditor;

@Controller
@RequestMapping("/admin")
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileSaver fileSaver;
	
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
	@Transactional
	@CacheEvict(value = "products", allEntries = true)
	public ModelAndView save(MultipartFile smallPhoto, MultipartFile mediumPhoto, MultipartFile largePhoto,
			@Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return form(product);
		}
			
		String unformattedNameId = product.getName();
		product.setNameId(unformattedNameId);
		product.setSmallPhotoPath(webPath(smallPhoto));
		product.setMediumPhotoPath(webPath(mediumPhoto));
		product.setLargePhotoPath(webPath(largePhoto));
		
		productDAO.save(product);
		
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:/admin");
	}
	
	private String webPath(MultipartFile sizePhoto) {
		return fileSaver.write("uploaded-images", sizePhoto);
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Product product) {
		ModelAndView modelAndView = new ModelAndView("/admin/form");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("/admin/list");
		modelAndView.addObject("products", productDAO.list());

		return modelAndView;
	}

}
