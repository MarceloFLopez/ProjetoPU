package br.com.projetopeu.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Revista implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate prazoEntrega;

	@Column(length = 50, nullable = false, unique = true)
	private String titulo;
	
	@Column(nullable = false)
	private Integer edicao;
	
	@Column(length = 20, nullable = false)
	private String chamadaPrincipal;
	
	@Column(length = 150, nullable = false)
	private String descricao;
	
	@Column(length = 20, nullable = false)
	private String palavraChave;
	
	@Column(length = 20, nullable = false)
	@Min(value = 0, message = "O número de páginas informada deve ser mair que 0!")
	private Integer numerPaginas;
	
	@Column(nullable = false, unique = true)
	private Long codigoBarras;
	
	@Column(nullable = false, unique = true)
	private Long eanDigital;
	
	@Column(nullable = false)
	private Long isbn;
	
	@Column(nullable = false)
	private Long codigBisac;
	
	@Column(length = 50, nullable = false)
	private String descricaoBisac;
	
	@Column(scale = 2, precision = 5,nullable = false)
	private BigDecimal precoCapa;
	
	@Column(length = 50, nullable = false)
	private String periodicidade;
	
	@Column(length = 3, nullable = false)
	private String epub;
	
	@Column(length = 3, nullable = false)
	private String arquivoPdf;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;

}
