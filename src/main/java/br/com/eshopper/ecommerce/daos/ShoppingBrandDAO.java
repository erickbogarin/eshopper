package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.wrapers.ShoppingBrand;

@Repository
public class ShoppingBrandDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<ShoppingBrand> list() {

		String jpql = "select new br.com.eshopper.ecommerce.models.wrapers.ShoppingBrand"
				+ "(s.product.name, s.purchase.purchaseDate, COUNT(s.id), SUM(s.total), s.product.category.categoryType, s.product.person.personType, s.product.brand.brandType)"
				+ " from Sale s"
				+ " GROUP BY s.product.brand.brandType, s.product.person.personType, s.product.name"
				+ " ORDER BY s.product.brand.brandType ASC, COUNT(s.id) DESC";

		return manager.createQuery(jpql, ShoppingBrand.class).getResultList();
	}

}
