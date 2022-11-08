package br.com.projetopeu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetopeu.model.Fabricante;
import br.com.projetopeu.model.Funcionario;
import br.com.projetopeu.util.JPAUTil;

public class FuncionarioDAO {

	private EntityManager em = JPAUTil.getEntityManager();

	public void save(Funcionario t) {
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

	public void deleteFbricante(Fabricante f) {
		try {
			em.getTransaction().begin();
			em.remove(f);
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
			Funcionario p = em.find(Funcionario.class, id);
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.clear();
			em.close();
			throw e;
		}
	}

	public void edit(Funcionario t) {
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

	public Funcionario findId(Long id) {
		EntityManager em = JPAUTil.getEntityManager();
		Funcionario p = em.find(Funcionario.class, id);
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> list() {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Funcionario p ORDER BY p.id");
		List<Funcionario> list = query.getResultList();
		return list;
	}

	public Funcionario findName(String nome) {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Funcionario p WHERE p.nome = :nome");
		Funcionario p = (Funcionario) query.setParameter("nome", nome).getSingleResult();
		return p;
	}
	
	public Funcionario findC(String cpf) {
		EntityManager em = JPAUTil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Funcionario p WHERE p.cpf = :cpf");
		Funcionario p = (Funcionario) query.setParameter("cpf", cpf).getSingleResult();
		return p;
	}

}
