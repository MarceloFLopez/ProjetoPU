package br.com.projetopeu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetopeu.model.Revista;
import br.com.projetopeu.util.JPAUTil;

public class RevistaDAO {

	private EntityManager em = JPAUTil.getEntityManager();

	public void save(Revista t) {
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
			Revista p = em.find(Revista.class, id);
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}

	public void edit(Revista t) {
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

	public Revista findId(Long id) {
		EntityManager em = JPAUTil.getEntityManager();
		Revista p = em.find(Revista.class, id);
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Revista> list() {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Revista p ORDER BY p.id");
		List<Revista> list = query.getResultList();
		return list;
	}

}
