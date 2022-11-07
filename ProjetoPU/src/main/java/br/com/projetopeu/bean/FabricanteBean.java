package br.com.projetopeu.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.projetopeu.dao.FabricanteDAO;
import br.com.projetopeu.exception.DatabaseException;
import br.com.projetopeu.exception.ResourceNotFoundException;
import br.com.projetopeu.model.Fabricante;
import br.com.projetopeu.util.FacesUtil;
import lombok.Data;

@Named
@ViewScoped
@Data
public class FabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Fabricante fabricanteCadastro;
	private List<Fabricante> listafabricantes;
	private List<Fabricante> listaFabricantesFiltrado = null;
	
	public void novo() {
		fabricanteCadastro = new Fabricante();
	}

	public void salvar() throws DatabaseException, ResourceNotFoundException {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.save(fabricanteCadastro);
			novo();
			FacesUtil.addMsgInfo("Fabricante Salvo com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Fabricante já esta cadastrado!"+e.getMessage());
		}
	}
	
	public void carregar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		try {
			listafabricantes = fabricanteDAO.list();
		}catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao carregar a listagem"+e.getMessage());
		}
	}

	public Fabricante getFabricanteCadastro() {
		if (fabricanteCadastro == null) {
			return fabricanteCadastro = new Fabricante();
		}
		return fabricanteCadastro;
	}

	public void setFabricanteCadastro(Fabricante fabricanteCadastro) {
		this.fabricanteCadastro = fabricanteCadastro;
	}

}
