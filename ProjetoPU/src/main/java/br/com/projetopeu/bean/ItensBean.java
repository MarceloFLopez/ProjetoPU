package br.com.projetopeu.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.projetopeu.dao.ItensDAO;
import br.com.projetopeu.exception.DatabaseException;
import br.com.projetopeu.exception.ResourceNotFoundException;
import br.com.projetopeu.model.Itens;
import br.com.projetopeu.util.FacesUtil;
import lombok.Data;

@Named
@ViewScoped
@Data
public class ItensBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Itens itensCadastro;
	private List<Itens> listaitenss;
	private List<Itens> listaItenssFiltrado;

	public void novo() {
		itensCadastro = new Itens();
	}

	public void salvar() throws DatabaseException, ResourceNotFoundException {
		try {
			ItensDAO dao = new ItensDAO();
			dao.save(itensCadastro);
			novo();
			FacesUtil.addMsgInfo("Itens Salvo com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Itens já esta cadastrado!");
		}
	}

	public void carregar() {
		ItensDAO itensDAO = new ItensDAO();
		try {
			listaitenss = itensDAO.list();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao carregar a listagem" + e.getMessage());
		}
	}

	public Itens getItensCadastro() {
		if (itensCadastro == null) {
			return itensCadastro = new Itens();
		}
		return itensCadastro;
	}

	public void setItensCadastro(Itens itensCadastro) {
		this.itensCadastro = itensCadastro;
	}

}
