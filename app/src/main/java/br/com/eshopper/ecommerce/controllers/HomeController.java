package br.com.eshopper.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.eshopper.ecommerce.daos.BrandDAO;
import br.com.eshopper.ecommerce.daos.CategoryDAO;
import br.com.eshopper.ecommerce.daos.ProductDAO;
import br.com.eshopper.ecommerce.models.Brand;
import br.com.eshopper.ecommerce.models.Category;
import br.com.eshopper.ecommerce.models.Product;

@Controller
public class HomeController {

	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private BrandDAO brandDAO;
	
	@RequestMapping("/")
	@Cacheable(value = "productsHome")
	public ModelAndView index() {
		List<Product> products = productDao.list();
		List<Category> categories = categoryDAO.list();
		List<Brand> brands = brandDAO.list();
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("products", products);
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("brands", brands);
		
		return modelAndView;
	}

}
