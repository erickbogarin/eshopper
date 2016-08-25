package br.com.eshopper.ecommerce.daos;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.wrapers.ShoppingBrand;

@Repository
public class ShoppingBrandDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<ShoppingBrand> list(Calendar start, Calendar ends) {

		String jpql = "select new br.com.eshopper.ecommerce.models.wrapers.ShoppingBrand"
				+ "(s.product.name, s.purchase.purchaseDate, COUNT(s.id), SUM(s.total), s.product.category.categoryType, s.product.person.personType, s.product.brand.brandType)"
				+ " from Sale s"
				+ " WHERE s.purchase.purchaseDate BETWEEN :start AND :ends"
				+ " GROUP BY s.product.brand.brandType, s.product.person.personType, s.product.name"
				+ " ORDER BY s.product.brand.brandType ASC, COUNT(s.id) DESC";

		TypedQuery<ShoppingBrand> query = manager.createQuery(jpql, ShoppingBrand.class);
		query.setParameter("start", start);
		query.setParameter("ends", ends);
		
		return query.getResultList();
	}

}
