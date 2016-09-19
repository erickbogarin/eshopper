package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.Sale;
import br.com.eshopper.ecommerce.models.wrapers.BestSallers;
import br.com.eshopper.ecommerce.models.wrapers.ShoppingCategoryChart;

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

	public List<BestSallers> bestSallers() {
		String jpql = "SELECT NEW br.com.eshopper.ecommerce.models.wrapers.BestSallers"
				+ "(s.product.id, s.product.name, SUM(s.quantity), SUM(s.total))" + " FROM Sale s"
				+ " GROUP BY s.product.id" + " ORDER BY SUM(s.quantity) DESC";

		return manager.createQuery(jpql, BestSallers.class).setMaxResults(20).getResultList();
	}
	
	public List<ShoppingCategoryChart> shoppingCategoryChartList() {
		String jqpl = "SELECT NEW br.com.eshopper.ecommerce.models.wrapers.ShoppingCategoryChart"
				+ "(MONTH(s.purchase.purchaseDate), SUM(s.total))"
				+ " from Sale s"
				+ " group by MONTH(s.purchase.purchaseDate)";
		
		return manager.createQuery(jqpl, ShoppingCategoryChart.class)
				.getResultList();
	}
	
}
