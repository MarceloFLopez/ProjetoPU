package br.com.projetopeu.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.projetopeu.dao.EditoraDAO;
import br.com.projetopeu.exception.DatabaseException;
import br.com.projetopeu.exception.ResourceNotFoundException;
import br.com.projetopeu.model.Editora;
import br.com.projetopeu.util.FacesUtil;
import lombok.Data;

@Named
@ViewScoped
@Data
public class EditoraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Editora editoraCadastro;
	private List<Editora> listaeditoras;
	private List<Editora> listaEditorasFiltrado;

	public void novo() {
		editoraCadastro = new Editora();
	}

	public void salvar() throws DatabaseException, ResourceNotFoundException {
		try {
			EditoraDAO dao = new EditoraDAO();
			dao.save(editoraCadastro);
			novo();
			FacesUtil.addMsgInfo("Editora Salvo com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Editora já esta cadastrado!");
		}
	}

	public void carregar() {
		EditoraDAO editoraDAO = new EditoraDAO();
		try {
			listaeditoras = editoraDAO.list();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao carregar a listagem" + e.getMessage());
		}
	}

	public Editora getEditoraCadastro() {
		if (editoraCadastro == null) {
			return editoraCadastro = new Editora();
		}
		return editoraCadastro;
	}

	public void setEditoraCadastro(Editora editoraCadastro) {
		this.editoraCadastro = editoraCadastro;
	}

}
