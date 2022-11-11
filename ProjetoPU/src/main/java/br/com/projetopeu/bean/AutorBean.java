package br.com.projetopeu.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.projetopeu.dao.AutorDAO;
import br.com.projetopeu.exception.DatabaseException;
import br.com.projetopeu.exception.LogExceptions;
import br.com.projetopeu.exception.ResourceNotFoundException;
import br.com.projetopeu.model.Autor;
import br.com.projetopeu.util.FacesUtil;
import lombok.Data;

@Named
@ViewScoped
@Data
public class AutorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Autor autorCadastro;
	private List<Autor> listaautors;
	private List<Autor> listaAutorsFiltrado;

	public void novo() {
		autorCadastro = new Autor();
	}

	public void salvar() throws DatabaseException, ResourceNotFoundException,IndexOutOfBoundsException, LogExceptions {
		try {
			AutorDAO dao = new AutorDAO();
			dao.save(autorCadastro);
			novo();
			FacesUtil.addMsgInfo("Autor Salvo com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Autor já esta cadastrado!");
		}
	}

	public void carregar() {
		AutorDAO autorDAO = new AutorDAO();
		try {
			listaautors = autorDAO.list();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao carregar a listagem" + e.getMessage());
		}
	}

	public Autor getAutorCadastro() {
		if (autorCadastro == null) {
			return autorCadastro = new Autor();
		}
		return autorCadastro;
	}

	public void setAutorCadastro(Autor autorCadastro) {
		this.autorCadastro = autorCadastro;
	}

}
