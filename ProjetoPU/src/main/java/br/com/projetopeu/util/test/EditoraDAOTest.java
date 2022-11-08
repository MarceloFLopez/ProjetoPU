package br.com.projetopeu.util.test;

import java.util.List;

import org.junit.Test;

import br.com.projetopeu.dao.EditoraDAO;
import br.com.projetopeu.model.Editora;

public class EditoraDAOTest {

	private EditoraDAO dao = new EditoraDAO();

	@Test
	public void save() {
		Editora a2 = new Editora();
		a2.setNome("Editora Teste2");
		Editora a3 = new Editora();
		a3.setNome("Editora Teste3");
		Editora a4 = new Editora();
		a4.setNome("Editora Teste4");
		dao.save(a2);
		dao.save(a3);
		dao.save(a4);
	}
	
	public void findId() {
		Editora a2 = new Editora();
		a2 = dao.findId(1l);
		System.out.println(a2);
	}
	
	public void listAll() {
		List<Editora> list = dao.list();
		list.forEach(a -> System.out.println(a));
	}

	public void update() {
		Editora a2 = new Editora();
		a2 = dao.findId(1l);
		System.out.println(a2);
		a2.setNome("Teste 1");
		dao.edit(a2);
		a2 = dao.findId(1l);
		System.out.println(a2);
	}

	public void delete() {
		Editora a2 = new Editora();
		dao.deleteId(1l);
		a2 = dao.findId(1l);
		System.out.println(a2);
	}
}
