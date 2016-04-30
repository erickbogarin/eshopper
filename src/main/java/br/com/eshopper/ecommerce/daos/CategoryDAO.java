package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.Category;

@Repository
public class CategoryDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Category> list() {
		return manager.createQuery("select c from Category c", Category.class)
				.getResultList();
	}
	
	public Category find(Integer id) {
		return manager.find(Category.class,id);
	}
	
}
