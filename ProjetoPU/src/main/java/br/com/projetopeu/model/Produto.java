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
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false,unique = true)
//	@NotBlank(message = "O campo nome é obrigatório!")
	private String nome;
	
	@Column(nullable = false)
//	@NotNull(message = "O campo quantidade é orbiratório!")
//	@Min(value = 0, message = "A quantidade informada deve ser mair que 0 ou maior ou igual a 100")
//	@Max(value = 100, message = "A quantidade informada deve ser menor ou igual a 100")
	private Integer quantidade;
	
	@Column(scale = 2,precision = 5)
//	@NotNull(message = "O campo preço é orbiratório!")
//	@DecimalMin(value = "0.05",message = "O preço deve ser maior que 0.05")
//	@DecimalMax(value = "150.00",message = "O preço deve ser maior que 150.00")
	private BigDecimal preco;
	
//	@NotNull(message = "O campo data de válidade é obrigatório!")
	private LocalDate dataValidade;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
//	@NotNull(message = "O campo categoria é obrigatório!")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "fabricante_id")
	@NotNull(message = "O campo categoria é obrigatório!")
	private Fabricante fabricante;

}
