package testClass;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import br.com.projetopeu.dao.ItensDAO;
import br.com.projetopeu.dao.ProdutoDAO;
import br.com.projetopeu.dao.VendaDAO;
import br.com.projetopeu.model.Itens;

public class ItenDAOTest {

	@Test
	public void save() {
		Itens i = new Itens();
		ItensDAO dao = new ItensDAO();

		i.setProduto(new ProdutoDAO().findId(2l));
		i.setQuantidade(10);
		i.setVavlor_parcial(BigDecimal.valueOf(32.45));
		i.setVenda(new VendaDAO().findId(3l));
		dao.save(i);
	}

	// find
	public void findId() {
		ItensDAO dao = new ItensDAO();
		Itens f = dao.findId(1l);
		System.out.println(f);
	}

	// List
	public void listAll() {
		ItensDAO dao = new ItensDAO();
		List<Itens> list = dao.list();
		list.forEach(System.out::println);
	}

	// Update
	public void update() {
		ItensDAO dao = new ItensDAO();
		Itens f = dao.findId(1l);
		dao.edit(f);
	}

	// Delete
	public void delete() {
		ItensDAO dao = new ItensDAO();
		dao.deleteId(1l);
		System.out.println(dao.findId(1l));
	}
}
