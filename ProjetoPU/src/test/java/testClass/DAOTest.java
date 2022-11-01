package testClass;

import java.util.List;

import org.junit.Test;

import br.com.projetopeu.dao.FabricanteDAO;
import br.com.projetopeu.model.Fabricante;

public class DAOTest {

//	@Test
//	@Ignore
//	public void inciar() {
//		FabricanteDAO dao = new FabricanteDAO();		
//
//		Fabricante f1 = new Fabricante();
//		f1.setDescricacao("Fabricante 1");
//
//		Fabricante f2 = new Fabricante();
//		f2.setDescricacao("Fabricante 2");
//
//		Fabricante f3 = new Fabricante();
//		f3.setDescricacao("Fabricante 3");
//
//		dao.save(f1);
//		dao.save(f2);
//		dao.save(f3);
//		
//		List<Fabricante> list = dao.list();
//		list.forEach(System.out::println);
//		
//		dao.deleteId(1l);
//
//		List<Fabricante> list1 = dao.list();
//		list1.forEach(System.out::println);
//	}

	@Test
	public void inciar() {
		FabricanteDAO dao = new FabricanteDAO();
		// save
//		Fabricante f1 = new Fabricante();
//		f1.setDescricacao("Fabricante 1");
//
//		Fabricante f2 = new Fabricante();
//		f2.setDescricacao("Fabricante 2");
//
//		dao.save(f1);
//		dao.save(f2);

		// list
		List<Fabricante> list = dao.list();
		list.forEach(System.out::println);

		// delete
//		dao.deleteId(1l);

		// update
		Fabricante f3 = dao.findId(1l);
		f3.setDescricacao("Teste");
		dao.edit(f3);

		// list
		List<Fabricante> list1 = dao.list();
		list1.forEach(System.out::println);
	}

}
