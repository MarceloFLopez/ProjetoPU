package br.com.projetopeu.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.projetopeu.dao.RevistaDAO;
import br.com.projetopeu.exception.DatabaseException;
import br.com.projetopeu.exception.LogExceptions;
import br.com.projetopeu.exception.ResourceNotFoundException;
import br.com.projetopeu.model.Revista;
import br.com.projetopeu.util.FacesUtil;
import lombok.Data;

@Named
@ViewScoped
@Data
public class RevistaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Revista revistaCadastro;
	private List<Revista> listarevistas;
	private List<Revista> listaRevistasFiltrado;

	public void novo() {
		revistaCadastro = new Revista();
	}

	public void salvar() throws  ResourceNotFoundException, LogExceptions, DatabaseException ,IndexOutOfBoundsException, LogExceptions {
		try {
			RevistaDAO dao = new RevistaDAO();
			dao.save(revistaCadastro);
			novo();
			FacesUtil.addMsgInfo("Revista Salvo com sucesso!");
		} catch (RuntimeException e) {		
			FacesUtil.addMsgError("Revista já esta cadastrado!");
		} catch (Exception ex) {
			throw new LogExceptions(""+ex.getMessage());
		}
	}
	// teste

	public void carregar() {
		RevistaDAO revistaDAO = new RevistaDAO();
		try {
			listarevistas = revistaDAO.list();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao carregar a listagem" + e.getMessage());
		}
	}

	public Revista getRevistaCadastro() {
		if (revistaCadastro == null) {
			return revistaCadastro = new Revista();
		}
		return revistaCadastro;
	}

	public void setRevistaCadastro(Revista revistaCadastro) {
		this.revistaCadastro = revistaCadastro;
	}

}
