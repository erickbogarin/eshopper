package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.Sale;

@Repository
public class SaleDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(Sale sale) {
		manager.persist(sale);
	}
	
	public List<Sale> list() {
		return manager.createQuery("select s from Sale s", Sale.class).getResultList();
	}
	
	/*public List<Sale> latestSales() {
		String jpql = "select s from Sale s ORDER BY s.purchase.purchaseDate DESC";
		return manager.createQuery(jpql, Sale.class).setMaxResults(50).getResultList();
	}*/
	
}
