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


import br.com.carvalho.domain.Marca;

/**
 * @author manoel.carvalho
 *
 */
public class MarcaDao implements IMarcaDao {

	@Override
	public Marca create(Marca marca) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(marca);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		return marca;
	}

	@Override
	public Marca readId(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Marca marca = entityManager.find(Marca.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return marca;
	}

	@Override
	public List<Marca> readAll() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Marca> query = builder.createQuery(Marca.class);
		Root<Marca> root = query.from(Marca.class);
		query.select(root);
		
		TypedQuery<Marca> tpQuery = 
				entityManager.createQuery(query);
		List<Marca> list = tpQuery.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}

	@Override
	public Marca update(Marca marca) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		marca = entityManager.merge(marca);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return marca;
	}

	@Override
	public void delete(Marca marca) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		marca = entityManager.merge(marca);
		entityManager.remove(marca);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}


	

}
