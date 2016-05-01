package br.com.eshopper.ecommerce.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import br.com.eshopper.ecommerce.models.PersonType;
import br.com.eshopper.ecommerce.models.SystemUser;

@Repository
public class UserDAO implements UserDetailsService{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		String jpql = "select u from SystemUser u where u.login = :login";
		List<SystemUser> users = em.createQuery(jpql,SystemUser.class).setParameter("login", username).getResultList();
		if(users.isEmpty()){
			throw new UsernameNotFoundException("O usuario "+username+" não existe");
		}
		return users.get(0);
	}
	
	public SystemUser find(String login)
			throws UsernameNotFoundException {
		String jpql = "select u from SystemUser u where u.login = :login";
		List<SystemUser> users = em.createQuery(jpql,SystemUser.class).
				setParameter("login", login).getResultList();
		if(users.isEmpty()){
			throw new UsernameNotFoundException("Erro");
		}
		return users.get(0);
	}
	
	public Long findAllMen() {
		return em.createQuery("select COUNT(u) from SystemUser u where u.person.personType = :personType", Long.class)
				.setParameter("personType", PersonType.Masculino).getSingleResult();
	}
	
	public Long findAllWomen() {
		return em.createQuery("select COUNT(u) from SystemUser u where u.person.personType = :personType", Long.class)
				.setParameter("personType", PersonType.Feminino).getSingleResult();
	}
	
	public Long findAllChild() {
		return em.createQuery("select COUNT(u) from SystemUser u where u.person.personType = :personType", Long.class)
				.setParameter("personType", PersonType.Infantil).getSingleResult();
	}
	
	public Long findAllUsers() {
		return em.createQuery("select COUNT(u) from SystemUser u", Long.class)
				.getSingleResult();
	}

	
	public void save(SystemUser user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		em.persist(user);		
	}
	
	
}