package br.com.projetopeu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetopeu.model.Venda;
import br.com.projetopeu.util.JPAUTil;

public class VendaDAO {

	private EntityManager em = JPAUTil.getEntityManager();

	public void save(Venda t) {
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
			Venda p = em.find(Venda.class, id);
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}

	public void edit(Venda t) {
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

	public Venda findId(Long id) {
		EntityManager em = JPAUTil.getEntityManager();
		Venda p = em.find(Venda.class, id);
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Venda> list() {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Venda p");
		List<Venda> list = query.getResultList();
		return list;
	}

	public Venda findName(String nome) {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Venda p WHERE p.nome = :nome");
		Venda p = (Venda) query.setParameter("nome", nome).getSingleResult();
		return p;
	}

}
