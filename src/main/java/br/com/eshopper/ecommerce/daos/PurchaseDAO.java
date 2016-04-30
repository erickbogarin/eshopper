package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.Purchase;

@Repository
public class PurchaseDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Purchase purchase) {
		manager.persist(purchase);
	}
	
	public Purchase find(Integer id) {
		return manager.find(Purchase.class, id);
	}
	
	public List<Purchase> list() {
		return manager.createQuery("select p from Purchase p join fetch p.sales", Purchase.class).getResultList();
	}
	
	public List<Purchase> latestPurchase() {
		String jpql = "select p from Purchase p ORDER BY p.purchaseDate DESC";
		return manager.createQuery(jpql, Purchase.class).setMaxResults(20).getResultList();
	}
	
}
