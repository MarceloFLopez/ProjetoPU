package br.com.projetopeu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

import lombok.Data;

@SuppressWarnings("deprecation")
@ManagedBean
@Data
@SessionScoped
public class NomesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private List<String> nomes = new ArrayList<>();

	private HtmlInputText inputNome;
	private HtmlCommandButton botaoAdicionar;

	public void adicionar() {
		this.nomes.add(nome);

		if (this.nomes.size() > 3) {
			this.inputNome.setDisabled(true);
			this.botaoAdicionar.setDisabled(true);
			this.botaoAdicionar.setValue("Muitos nomes adicionados...");
		}

	}

}
