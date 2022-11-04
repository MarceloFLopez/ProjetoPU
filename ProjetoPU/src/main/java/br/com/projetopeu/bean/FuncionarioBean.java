package br.com.projetopeu.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.projetopeu.util.FacesUtil;
import lombok.Data;

@Named
@ViewScoped
@ManagedBean
@Data
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public void salvar() {
		FacesUtil.addMsgInfo("Funcionario Salvo com sucesso!");
	}


}
