package br.com.projetopeu.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.projetopeu.dao.FabricanteDAO;
import br.com.projetopeu.model.Fabricante;
import lombok.Data;

@Named
@ViewScoped
@Data
public class FabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Fabricante fabricante;
	private FabricanteDAO fabricanteDAO;
	private List<Fabricante> fabricantes;

	@PostConstruct
	public void iniciar() {
		clean();
	}

	public void salvar() {
		fabricanteDAO.save(fabricante);
		Messages.addGlobalInfo("Fabricante salvo com sucesso!");
		clean();
	}

	public void clean() {
		fabricante = new Fabricante();
		fabricanteDAO = new FabricanteDAO();
		fabricantes = fabricanteDAO.list();
	}

	public void selecionar(Fabricante fabricanteSelecionado) {
		fabricante = fabricanteSelecionado;
	}

	public void editar() {
		fabricanteDAO.edit(fabricante);
		clean();
		Messages.addGlobalInfo("Fabricante editado com sucesso!");
	}
	

}
