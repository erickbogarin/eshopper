package br.com.eshopper.ecommerce.daos;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.wrapers.ShoppingPerson;

@Repository
public class ShoppingPersonDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<ShoppingPerson> list(Calendar starts, Calendar ends) {

		String jpql = "select new br.com.eshopper.ecommerce.models.wrapers.ShoppingPerson"
				+ "(s.product.name, s.purchase.purchaseDate, COUNT(s.id), SUM(s.total), s.product.person.personType, s.product.category.categoryType, s.product.brand.brandType)"
				+ " from Sale s"
				+ " WHERE s.purchase.purchaseDate BETWEEN :start AND :ends"
				+ " GROUP BY s.product.person.personType, s.product.name"
				+ " ORDER BY s.product.person.personType DESC";

		TypedQuery<ShoppingPerson> query = manager.createQuery(jpql, ShoppingPerson.class);
		query.setParameter("start", starts);
		query.setParameter("ends", ends);
		
		return query.getResultList();
	}

}
