package br.com.projetopeu.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.projetopeu.model.Funcionario;
import br.com.projetopeu.util.FacesUtil;
import lombok.Data;

@Named
@ViewScoped
@ManagedBean
@Data
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Funcionario funcionarioCadastro;

	public void salvar() {
		try {
			FacesUtil.addMsgInfo("Funcionario Salvo com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao salvar o funcionário!");
		}

	}

	public Funcionario getFuncionarioCadastro() {
		if (funcionarioCadastro == null) {
			return funcionarioCadastro = new Funcionario();
		}
		return funcionarioCadastro;
	}

	public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
		this.funcionarioCadastro = funcionarioCadastro;
	}

}
