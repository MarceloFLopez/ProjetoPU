package br.com.projetopeu.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Itens implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotNull(message = "O campo quantidade é orbiratório!")
	@Min(value = 0, message = "A quantidade informada deve ser mair que 0 ou maior ou igual a 100")
	@Max(value = 100, message = "A quantidade informada deve ser menor ou igual a 100")
	private Integer quantidade;

	@Column(scale = 2, precision = 5, nullable = false)
	private BigDecimal vavlor_parcial;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "venda_id", nullable = false)
	private Venda venda;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
}
