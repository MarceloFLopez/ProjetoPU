package br.com.projetopeu.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.projetopeu.dao.VendaDAO;
import br.com.projetopeu.exception.DatabaseException;
import br.com.projetopeu.exception.ResourceNotFoundException;
import br.com.projetopeu.model.Venda;
import br.com.projetopeu.util.FacesUtil;
import lombok.Data;

@Named
@ViewScoped
@Data
public class VendaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Venda vendaCadastro;
	private List<Venda> listavendas;
	private List<Venda> listaVendasFiltrado;

	public void novo() {
		vendaCadastro = new Venda();
	}

	public void salvar() throws DatabaseException, ResourceNotFoundException {
		try {
			VendaDAO dao = new VendaDAO();
			dao.save(vendaCadastro);
			novo();
			FacesUtil.addMsgInfo("Venda Salvo com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Venda já esta cadastrado!");
		}
	}

	public void carregar() {
		VendaDAO vendaDAO = new VendaDAO();
		try {
			listavendas = vendaDAO.list();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao carregar a listagem" + e.getMessage());
		}
	}

	public Venda getVendaCadastro() {
		if (vendaCadastro == null) {
			return vendaCadastro = new Venda();
		}
		return vendaCadastro;
	}

	public void setVendaCadastro(Venda vendaCadastro) {
		this.vendaCadastro = vendaCadastro;
	}

}
