package testClass;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.projetopeu.dao.FuncionarioDAO;
import br.com.projetopeu.dao.VendaDAO;
import br.com.projetopeu.model.Funcionario;
import br.com.projetopeu.model.Venda;

public class VendaDAOTest {
	
	// save
	public void save() {
		Venda v = new Venda();
		VendaDAO dao = new VendaDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario f = fdao.findId(1l);
		
		v.setFuncionario(f);
		v.setDate(new Date());
		v.setPreco(BigDecimal.valueOf(50.03));
		dao.save(v);		
	}
	
	// find
	public void findId() {
		VendaDAO dao = new VendaDAO();
		Venda f = dao.findId(1l);
		System.out.println(f);
	}
	@Test
	// List
	public void listAll() {
		VendaDAO dao = new VendaDAO();
		List<Venda> list = dao.list();
		list.forEach(System.out::println);
	}

	// Update
	public void update() {
		VendaDAO dao = new VendaDAO();
		Venda f = dao.findId(1l);
		dao.edit(f);
	}

	// Delete

	public void delete() {
		VendaDAO dao = new VendaDAO();
		dao.deleteId(1l);
		System.out.println(dao.findId(1l));
	}
}
