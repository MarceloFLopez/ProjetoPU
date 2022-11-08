package br.com.projetopeu.util.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import br.com.projetopeu.dao.AutorDAO;
import br.com.projetopeu.dao.CategoriaDAO;
import br.com.projetopeu.dao.EditoraDAO;
import br.com.projetopeu.dao.RevistaDAO;
import br.com.projetopeu.model.Revista;

public class RevistaDAOTest {

	EditoraDAO edao = new EditoraDAO();
	RevistaDAO rdao = new RevistaDAO();
	AutorDAO adao = new AutorDAO();
	CategoriaDAO cdao = new CategoriaDAO();


	public void test() {
		Revista re = new Revista();
		re.setArquivoPdf("sim");
		re.setAutor(null);
		re.setCategoria(null);
		re.setChamadaPrincipal("Amor de Verdade");
		re.setCodigBisac("LAN008003");
		re.setCodigoBarras(9788599791349l);
		re.setDescricao("Você tem a impressão de sofrer no amor? Aprenda a seguir os passos para ser apaixonada por você mesmo. O amor próprio é a saída para grandes sofrimentos. Saiba como deixar a pessoa ir quando ela quiser e não se humilhar por isso. Aprenda que o amor deve ser leve, compartilhado a dois, da melhor maneira. Se dói e existe sofrimento, não é amor. Veja como sair de casos assim, se amando e percebendo suas próprias qualidades, a cada dia.");
		re.setDescricaoBisac("LANGUAGE ARTS & DISCIPLINES / Journalism LANGUAGE ARTS & DISCIPLINES / Journalism");
		re.setEanDigital(7908182043583l);
		re.setEdicao(196);
		re.setEditora(null);
		re.setEpub("sim");
		re.setIsbn(9788584170159l);
		re.setIssn(null);
		re.setNumerPaginas(65);
		re.setPalavraChave("amor, se ame, amor próprio, valor, amor saudável");
		re.setPeriodicidade("semanal");
		re.setPrazoEntrega(LocalDate.of(2023, 10, 3));
		re.setPrecoCapa(BigDecimal.valueOf(25.55));
		re.setTitulo("10 passos para um amor de verdade");
		rdao.save(re);
	}
	
	public void findId() {
	Revista r =	rdao.findId(1l);
	System.out.println(r);
	}
	

	public void list() {
		List<Revista>list = rdao.list();
		System.out.println(list );
	}
	@Test
	public void update() {
		Revista r =	rdao.findId(1l);
		r.setAutor(adao.findId(1l));
		r.setCategoria(cdao.findId(2l));
		r.setEditora(edao.findId(3l));
		rdao.edit(r);
	}
}
