package br.com.projetopeu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetopeu.model.Itens;
import br.com.projetopeu.util.JPAUTil;

public class ItensDAO {

	private EntityManager em = JPAUTil.getEntityManager();

	public void save(Itens t) {
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
			Itens p = em.find(Itens.class, id);
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}

	public void edit(Itens t) {
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

	public Itens findId(Long id) {
		EntityManager em = JPAUTil.getEntityManager();
		Itens p = em.find(Itens.class, id);
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Itens> list() {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Itens p ORDER BY p.id");
		List<Itens> list = query.getResultList();
		return list;
	}

	public Itens findName(String nome) {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Itens p WHERE p.nome = :nome");
		Itens p = (Itens) query.setParameter("nome", nome).getSingleResult();
		return p;
	}

}
