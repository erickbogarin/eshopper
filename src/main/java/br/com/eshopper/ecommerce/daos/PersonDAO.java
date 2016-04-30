package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.Person;

@Repository
public class PersonDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Person> list() {
		return manager.createQuery("select p from Person p", Person.class)
				.getResultList();
	}
	
	public Person find(Integer id) {
		return manager.find(Person.class, id);
	}
	
}
