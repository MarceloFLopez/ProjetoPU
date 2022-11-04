package testClass;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import br.com.projetopeu.dao.FuncionarioDAO;
import br.com.projetopeu.model.Funcionario;

public class FuncionarioDAOTest {


	public void save() {
		Funcionario f = new Funcionario();
		FuncionarioDAO dao = new  FuncionarioDAO();
		f.setNome("Edilene Ferreira de Lima");
		f.setCpf("24544244867");
		f.setDataNascimento(LocalDate.of(1984, 10, 13));
		f.setFuncao("Balconista");
		f.setSenha("0023");
		f.setTelefone("964232516");
		dao.save(f);
	}
	

	// find
	public void findId() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f = dao.findId(1l);
		System.out.println(f);
	}
	@Test
	// List
	public void listAll() {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> list = dao.list();
		list.forEach(System.out::println);
	}
	
	// Update
	public void update() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f = dao.findId(1l);
		f.setNome("Helena Linda");
//		f.setCpf("12345678901");
//		f.setDataNascimento(LocalDate.of(2017, 10, 3));
//		f.setFuncao("APRENDIZ");
//		f.setSenha("nena");
//		f.setTelefone("xxxyyyyy");
		dao.edit(f);
	}

	// Delete

	public void delete() {
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.deleteId(2l);
		System.out.println(dao.findId(2l));
	}
}
