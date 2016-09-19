package br.com.eshopper.ecommerce.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import br.com.eshopper.ecommerce.daos.BrandDAO;
import br.com.eshopper.ecommerce.daos.CategoryDAO;
import br.com.eshopper.ecommerce.daos.PersonDAO;

@Component
public class ProductFilter {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private BrandDAO brandDAO;
	
	@Autowired
	private PersonDAO personDAO;
	
	@Cacheable(value = "categoriesList")
	public List<Category> categories() {
		return categoryDAO.list();
	}
	
	@Cacheable(value = "brandsList")
	public List<Brand> brands() {
		return brandDAO.list();
	}
	
	@Cacheable(value = "personList")
	public List<Person> personList() {
		return personDAO.list();
	}
	
	@Cacheable(value = "categoryName")
	public String category(Integer id) {
		return categoryDAO.find(id).getCategoryType().name();
	}
	
	@Cacheable(value = "brandName")
	public String brand(Integer id) {
		return brandDAO.find(id).getBrandType().name();
	}
 
}
