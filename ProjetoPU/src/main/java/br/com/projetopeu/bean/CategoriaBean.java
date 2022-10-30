package br.com.projetopeu.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.projetopeu.dao.CategoriaDAO;
import br.com.projetopeu.model.Categoria;
import lombok.Data;

@Named
@ViewScoped
@Data
public class CategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Categoria categoria;
	private CategoriaDAO categoriaDAO;
	private List<Categoria> categorias;

	@PostConstruct
	public void iniciar() {
		clean();
	}

	public void salvar() {
		categoriaDAO.save(categoria);
		Messages.addGlobalInfo("Categoria salva com sucesso!");
		clean();
	}

	public void clean() {
		categoria = new Categoria();
		categoriaDAO = new CategoriaDAO();
		categorias = categoriaDAO.list();
	}

	public void selecionar(Categoria categoriaSelecionado) {
		categoria = categoriaSelecionado;
	}

	public void editar() {
		categoriaDAO.edit(categoria);
		clean();
		Messages.addGlobalInfo("Categoria editado com sucesso!");
	}

}
