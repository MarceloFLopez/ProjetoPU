package br.com.projetopeu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetopeu.model.Produto;
import br.com.projetopeu.util.JPAUTil;

public class ProdutoDAO {

	private EntityManager em = JPAUTil.getEntityManager();

	public void save(Produto t) {
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
			Produto p = em.find(Produto.class, id);
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}

	public void edit(Produto t) {
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

	public Produto findId(Long id) {
		EntityManager em = JPAUTil.getEntityManager();
		Produto p = em.find(Produto.class, id);
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> list() {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Produto p ORDER BY p.id");
		List<Produto> list = query.getResultList();
		return list;
	}

	public Produto findName(String nome) {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Produto p WHERE p.nome = :nome");
		Produto p = (Produto) query.setParameter("nome", nome).getSingleResult();
		return p;
	}

}
