package br.com.projetopeu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetopeu.model.Autor;
import br.com.projetopeu.util.JPAUTil;

public class AutorDAO {

	private EntityManager em = JPAUTil.getEntityManager();

	// save
	public void save(Autor t) {
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
	public void edit(Autor t) {
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
			Autor e = em.find(Autor.class, id);
			em.remove(e);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}

	// find id
	public Autor findId(Long id) {
		EntityManager em = JPAUTil.getEntityManager();
		Autor c = em.find(Autor.class, id);
		return c;
	}

	// list
	@SuppressWarnings("unchecked")
	public List<Autor> list() {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Autor p ORDER BY p.id");
		List<Autor> list = query.getResultList();
		return list;
	}

}
