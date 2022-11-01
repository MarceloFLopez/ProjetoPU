package br.com.projetopeu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetopeu.model.Fabricante;
import br.com.projetopeu.util.JPAUTil;

public class FabricanteDAO {
	private EntityManager em = JPAUTil.getEntityManager();

	// save
	public void save(Fabricante t) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}

	// update
	public void edit(Fabricante t) {
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}
	
	// delete
	public void deleteId(Long id) {
		try {
			em.getTransaction().begin();
			Fabricante e = em.find(Fabricante.class, id);
			em.remove(e);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}

	// find id
	public Fabricante findId(Long id) {
		EntityManager em = JPAUTil.getEntityManager();
		Fabricante c = em.find(Fabricante.class, id);
		return c;
	}

	// list
	@SuppressWarnings("unchecked")
	public List<Fabricante> list() {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Fabricante p");
		List<Fabricante> list = query.getResultList();
		return list;
	}
}
