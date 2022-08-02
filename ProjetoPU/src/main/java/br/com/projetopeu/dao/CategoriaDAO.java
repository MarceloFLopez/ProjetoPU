package br.com.projetopeu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetopeu.model.Categoria;
import br.com.projetopeu.util.JPAUTil;

public class CategoriaDAO {

	private EntityManager em = JPAUTil.getEntityManager();

	public void save(Categoria t) {
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

	public void edit(Categoria t) {
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

	public Categoria findId(Long id) {
		EntityManager em = JPAUTil.getEntityManager();
		Categoria c = em.find(Categoria.class, id);
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> list() {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Categoria p ORDER BY nome");
		List<Categoria> list = query.getResultList();
		return list;
	}

}
