package br.com.projetopeu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetopeu.model.Editora;
import br.com.projetopeu.util.JPAUTil;

public class EditoraDAO {

	private EntityManager em = JPAUTil.getEntityManager();

	public void save(Editora t) {
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
			Editora p = em.find(Editora.class, id);
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}

	public void edit(Editora t) {
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

	public Editora findId(Long id) {
		EntityManager em = JPAUTil.getEntityManager();
		Editora p = em.find(Editora.class, id);
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Editora> list() {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Editora p ORDER BY p.id");
		List<Editora> list = query.getResultList();
		return list;
	}

}
