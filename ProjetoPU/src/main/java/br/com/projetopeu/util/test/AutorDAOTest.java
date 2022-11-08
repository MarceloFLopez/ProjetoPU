package br.com.projetopeu.util.test;

import java.util.List;

import org.junit.Test;

import br.com.projetopeu.dao.AutorDAO;
import br.com.projetopeu.model.Autor;

public class AutorDAOTest {

	private AutorDAO dao = new AutorDAO();

	public void save() {
		Autor a2 = new Autor();
		a2.setNome("Autor Teste2");
		Autor a3 = new Autor();
		a3.setNome("Autor Teste3");
		Autor a4 = new Autor();
		a4.setNome("Autor Teste4");
		dao.save(a2);
		dao.save(a3);
		dao.save(a4);
	}

	public void findId() {
		Autor a2 = new Autor();
		a2 = dao.findId(1l);
		System.out.println(a2);
	}

	public void listAll() {
		List<Autor> list = dao.list();
		list.forEach(a -> System.out.println(a));
	}

	public void update() {
		Autor a2 = new Autor();
		a2 = dao.findId(1l);
		System.out.println(a2);
		a2.setNome("Teste 1");
		dao.edit(a2);
		a2 = dao.findId(1l);
		System.out.println(a2);
	}

	@Test
	public void delete() {
		Autor a2 = new Autor();		
		dao.deleteId(5l);
		a2 = dao.findId(1l);
		System.out.println(a2);
	}

}
