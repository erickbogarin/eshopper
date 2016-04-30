package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.Product;

@Repository
public class ProductDAO {

    @PersistenceContext
    private EntityManager manager;

    public void save(Product product) {
        manager.persist(product);
    }

    public List<Product> list() {
        return manager.createQuery("select p from Product p", Product.class)
                .setMaxResults(6).getResultList();
    }

    public Product find(Integer productId) {
        return manager.find(Product.class, productId);
    }

    public List<Product> filterByCategory(Integer categoryId) {
        return manager.createQuery("select p from Product p where p.category.id = :categoryId", Product.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    public List<Product> filterByBrand(Integer brandId) {
        return manager.createQuery("select p from Product p where p.brand.id = :brandId", Product.class)
                .setParameter("brandId", brandId)
                .getResultList();
    }

    public List<Product> filterByPersonAndCategory(Integer personId, Integer categoryId) {
        return manager.createQuery("select p from Product p where p.person.id = :personId and p.category.id = :categoryId", Product.class)
                .setParameter("personId", personId)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

	public Product findNameId(String nameId) {
		return manager.createQuery("select p from Product p where p.nameId = :nameId", Product.class)
				.setParameter("nameId", nameId)
				.getSingleResult();
	}

}
