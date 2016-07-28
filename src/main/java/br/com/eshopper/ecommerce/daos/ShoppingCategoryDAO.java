package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.wrapers.ShoppingCategory;

@Repository
public class ShoppingCategoryDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public List<ShoppingCategory> list() {

		String jpql = "select new br.com.eshopper.ecommerce.models.wrapers.ShoppingCategory"
				+ "(s.product.name, s.purchase.purchaseDate, COUNT(s.id), SUM(s.total), s.product.category.categoryType, s.product.person.personType, s.product.brand.brandType)"
				+ " from Sale s"
				+ " GROUP BY s.product.category.categoryType, s.product.person.personType, s.product.brand.brandType"
				+ " ORDER BY s.product.category.categoryType ASC, COUNT(s.id) DESC, s.purchase.purchaseDate ASC";

		 return manager.createQuery(jpql, ShoppingCategory.class).getResultList();
	}

}
