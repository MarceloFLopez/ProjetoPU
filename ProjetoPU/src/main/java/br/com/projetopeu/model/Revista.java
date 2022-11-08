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

	@Column(length = 50, unique = true)
	private String titulo;
	
	@Column(nullable = true)
	private Integer edicao;
	
	@Column(length = 20)
	private String chamadaPrincipal;
	
	@Column(nullable = true, length = 1024)
	private String descricao;
	
	@Column(length = 50)
	private String palavraChave;

	@Column(length = 20)
	@Min(value = 0, message = "O número de páginas informada deve ser mair que 0!")
	private Integer numerPaginas;

	@Column( unique = true)
	private Long codigoBarras;
	
	@Column(unique = true)
	private Long eanDigital;
	
	@Column()
	private Long isbn;
	
	@Column()
	private Long issn;
	
	@Column(length = 20)
	private String codigBisac;
	
	@Column(length = 150)
	private String descricaoBisac;
	
	@Column(scale = 2, precision = 5)
	private BigDecimal precoCapa;
	
	@Column(length = 20)
	private String periodicidade;
	
	@Column(length = 3)
	private String epub;
	
	@Column(length = 3)
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
