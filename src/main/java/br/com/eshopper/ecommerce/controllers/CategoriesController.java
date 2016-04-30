package br.com.eshopper.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eshopper.ecommerce.daos.CategoryDAO;
import br.com.eshopper.ecommerce.models.Category;

@Controller
public class CategoriesController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/api/categories")
	@Cacheable(value = "categoriesAPI")
	public List<Category> list() {
		return categoryDAO.list();
	}
	
}
