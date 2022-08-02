package br.com.projetopeu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 13, nullable = false,unique = true)
	private String cpf;
	@Column(length = 60, nullable = false)
	private String nome;
}