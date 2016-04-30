package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.ShoppingPerson;

@Repository
public class ShoppingPersonDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<ShoppingPerson> list() {

		String jpql = "select new br.com.eshopper.ecommerce.models.ShoppingPerson"
				+ "(s.product.name, s.purchase.purchaseDate, COUNT(s.id), SUM(s.total), s.product.person.personType, s.product.category.categoryType, s.product.brand.brandType)"
				+ " from Sale s"
				+ " GROUP BY s.product.person.personType, s.product.name"
				+ " ORDER BY s.product.person.personType DESC";

		return manager.createQuery(jpql, ShoppingPerson.class).getResultList();
	}

}
