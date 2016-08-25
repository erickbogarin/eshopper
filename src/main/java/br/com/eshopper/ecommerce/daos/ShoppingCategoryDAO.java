package br.com.eshopper.ecommerce.daos;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.wrapers.ShoppingCategory;

@Repository
public class ShoppingCategoryDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public List<ShoppingCategory> list(Calendar start, Calendar ends) {

		String jpql = "select new br.com.eshopper.ecommerce.models.wrapers.ShoppingCategory"
				+ "(s.product.name, s.purchase.purchaseDate, COUNT(s.id), SUM(s.total), s.product.category.categoryType, s.product.person.personType, s.product.brand.brandType)"
				+ " from Sale s"
				+ " WHERE s.purchase.purchaseDate BETWEEN :start AND :ends"
				+ " GROUP BY s.product.category.categoryType, s.product.person.personType, s.product.brand.brandType"
				+ " ORDER BY s.product.category.categoryType ASC, COUNT(s.id) DESC, s.purchase.purchaseDate ASC";

		TypedQuery<ShoppingCategory> query = manager.createQuery(jpql, ShoppingCategory.class);
		query.setParameter("start", start);
		query.setParameter("ends", ends);
		
		return query.getResultList();
	}

}
