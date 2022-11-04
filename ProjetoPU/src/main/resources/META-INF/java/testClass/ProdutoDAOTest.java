package testClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import br.com.projetopeu.dao.CategoriaDAO;
import br.com.projetopeu.dao.FabricanteDAO;
import br.com.projetopeu.dao.ProdutoDAO;
import br.com.projetopeu.model.Categoria;
import br.com.projetopeu.model.Fabricante;
import br.com.projetopeu.model.Produto;

public class ProdutoDAOTest {


	public void save() {
		ProdutoDAO dao = new ProdutoDAO();		
		Produto p = new Produto();
		
		CategoriaDAO cdao = new CategoriaDAO();
		Categoria c = cdao.findId(2l);
		
		FabricanteDAO fdao = new FabricanteDAO();
		Fabricante f = fdao.findId(2l);
		
		p.setCategoria(c);
		p.setDataValidade(LocalDate.of(2023, 10, 10));
		p.setFabricante(f);
		p.setNome("Lisador gotas 20ml");
		p.setPreco(BigDecimal.valueOf(10.00));
		p.setQuantidade(10);
		dao.save(p);
	}
	
	// find
	public void findId() {
		ProdutoDAO dao = new ProdutoDAO();
		Produto f = dao.findId(1l);
		System.out.println(f);
	}

	// List
	public void listAll() {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> list = dao.list();
		list.forEach(System.out::println);
	}

	// Update
	public void update() {
		ProdutoDAO dao = new ProdutoDAO();
		Produto p = dao.findId(2l);
		p.setCategoria(new CategoriaDAO().findId(1l));
		dao.edit(p);
	}
	@Test
	// Delete
	public void delete() {		
		ProdutoDAO dao = new ProdutoDAO();
		dao.deleteId(1l); 
		
	}
	
}
