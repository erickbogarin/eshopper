package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.Brand;

@Repository
public class BrandDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Brand> list() {
		return manager.createQuery("select b from Brand b", Brand.class).getResultList();
	}

	public Brand find(Integer id) {
		return manager.find(Brand.class, id);
	}
}
