package br.com.projetopeu.util.test;

import java.util.List;

import org.junit.Test;

import br.com.projetopeu.dao.CategoriaDAO;
import br.com.projetopeu.model.Categoria;

public class CategoriaDAOTest {

	private CategoriaDAO dao = new CategoriaDAO();
	@Test
	public void save() {
		Categoria a2 = new Categoria();
		a2.setNome("Categoria Teste2");
		Categoria a3 = new Categoria();
		a3.setNome("Categoria Teste3");
		Categoria a4 = new Categoria();
		a4.setNome("Categoria Teste4");
		dao.save(a2);
		dao.save(a3);
		dao.save(a4);
	}

	public void findId() {
		Categoria a2 = new Categoria();
		a2 = dao.findId(1l);
		System.out.println(a2);
	}

	public void listAll() {
		List<Categoria> list = dao.list();
		list.forEach(a -> System.out.println(a));
	}

	public void update() {
		Categoria a2 = new Categoria();
		a2 = dao.findId(1l);
		System.out.println(a2);
		a2.setNome("Teste 1");
		dao.edit(a2);
		a2 = dao.findId(1l);
		System.out.println(a2);
	}


	public void delete() {
		Categoria a2 = new Categoria();		
		dao.deleteId(5l);
		a2 = dao.findId(1l);
		System.out.println(a2);
	}

}
