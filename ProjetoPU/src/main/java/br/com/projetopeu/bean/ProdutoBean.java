package br.com.projetopeu.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.projetopeu.dao.CategoriaDAO;
import br.com.projetopeu.dao.FabricanteDAO;
import br.com.projetopeu.dao.ProdutoDAO;
import br.com.projetopeu.model.Categoria;
import br.com.projetopeu.model.Fabricante;
import br.com.projetopeu.model.Produto;
import lombok.Data;

@Named
@ViewScoped
@Data
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto;
	private List<Categoria> categorias;
	private List<Produto> produtos;
	private List<Fabricante> fabricantes;
	private ProdutoDAO produtoDAO;
	private CategoriaDAO categoriaDAO;
	private FabricanteDAO fabricanteDAO;

	@PostConstruct
	public void iniciar() {
		clean();
	}

	public void salvar() {
		produtoDAO.save(produto);
		clean();
		Messages.addGlobalInfo("Produto salvo com sucesso!");
	}

	public void selecionar(Produto produtoSelecionado) {
		produto = produtoSelecionado;
	}

	public void editar() {
		produtoDAO.edit(produto);
		clean();
		Messages.addGlobalInfo("Produto editado com sucesso!");
	}

	public void clean() {
		categoriaDAO = new CategoriaDAO();
		produtoDAO = new ProdutoDAO();
		produto = new Produto();
		categorias = categoriaDAO.list();
		produtos = produtoDAO.list();
	}

}
