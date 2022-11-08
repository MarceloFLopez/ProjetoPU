package br.com.projetopeu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetopeu.model.Autor;
import br.com.projetopeu.util.JPAUTil;

public class AutorDAO {

	private EntityManager em = JPAUTil.getEntityManager();

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

	public void deleteId(Long id) {
		try {
			em.getTransaction().begin();
			Autor p = em.find(Autor.class, id);
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}

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

	public Autor findId(Long id) {
		EntityManager em = JPAUTil.getEntityManager();
		Autor p = em.find(Autor.class, id);
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Autor> list() {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Autor p ORDER BY p.id");
		List<Autor> list = query.getResultList();
		return list;
	}

}
