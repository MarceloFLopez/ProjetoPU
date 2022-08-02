package br.com.projetopeu.bean;

import javax.faces.bean.ManagedBean;

import lombok.Data;

@SuppressWarnings("deprecation")
@ManagedBean(name = "ola")
@Data
public class OlaBean {

	private String nome;
	private String sobrenome;
	private String nomeCompleto;

	public void dizerOla() {
		this.nomeCompleto = this.nome.toUpperCase() + " " + this.sobrenome;
	}

}
