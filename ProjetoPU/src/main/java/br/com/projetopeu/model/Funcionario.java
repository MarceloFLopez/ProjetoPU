package br.com.projetopeu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	@NotBlank(message = "O campo nome é obrigatório!")
	private String nome;
	
	@Column(length = 11, nullable = false,unique = true)
	@NotBlank(message = "O campo nome é obrigatório!")
	private String cpf;
	
	@Column(length = 32, nullable = false)
	@NotBlank(message = "O campo nome é obrigatório!")
	private String senha;
	
	@Column(length = 50, nullable = false)
	@NotBlank(message = "O campo nome é obrigatório!")
	private String funcaao;
}
