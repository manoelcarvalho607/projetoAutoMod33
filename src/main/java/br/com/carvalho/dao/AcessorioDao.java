/**
 * 
 */
package br.com.carvalho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.carvalho.domain.Acessorio;


/**
 * @author manoel.carvalho
 *
 */
public class AcessorioDao implements IAcessorioDao {

	@Override
	public Acessorio create(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(acessorio);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		return acessorio;
	}

	@Override
	public Acessorio readId(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Acessorio ac = entityManager.find(Acessorio.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return ac;
	}

	@Override
	public List<Acessorio> readAll() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Acessorio> query = builder.createQuery(Acessorio.class);
		Root<Acessorio> root = query.from(Acessorio.class);
		query.select(root);
		
		TypedQuery<Acessorio> tpQuery = 
				entityManager.createQuery(query);
		List<Acessorio> list = tpQuery.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}

	@Override
	public Acessorio update(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		acessorio = entityManager.merge(acessorio);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return acessorio;
	}

	@Override
	public void delete(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		acessorio = entityManager.merge(acessorio);
		entityManager.remove(acessorio);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
