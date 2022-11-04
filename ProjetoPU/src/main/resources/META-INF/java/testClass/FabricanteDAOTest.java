package testClass;

import java.util.List;

import org.junit.Test;

import br.com.projetopeu.dao.FabricanteDAO;
import br.com.projetopeu.model.Fabricante;

public class FabricanteDAOTest {

	//save
		public void save() {
		Fabricante f = new Fabricante();
		FabricanteDAO dao = new FabricanteDAO();		

		Fabricante f1 = new Fabricante();
		f1.setDescricacao("Fabricante 1");

		Fabricante f2 = new Fabricante();
		f2.setDescricacao("Fabricante 2");

		Fabricante f3 = new Fabricante();
		f3.setDescricacao("Fabricante 3");

		dao.save(f1);
		dao.save(f2);
		dao.save(f3);
		f.setDescricacao("Abot");
		dao.save(f);		
		}
		
		//find
		public void findId() {		
			FabricanteDAO dao = new FabricanteDAO();
			Fabricante f = dao.findId(1l);
			System.out.println(f);		
		}
		
		//List
		public void listAll() {		
			FabricanteDAO dao = new FabricanteDAO();
			List<Fabricante>list = dao.list();
			list.forEach(System.out::println);	
		}
		
		//Update
		public void update() {		
			FabricanteDAO dao = new FabricanteDAO();
			Fabricante f = dao.findId(1l);
			f.setDescricacao("Descricao 1");
			dao.edit(f);
		}
		
		// Delete
		@Test
		public void delete() {		
			FabricanteDAO dao = new FabricanteDAO();
			dao.deleteId(1l); 
			System.out.println(dao.findId(1l));
		}
}
