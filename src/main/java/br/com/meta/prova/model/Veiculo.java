package br.com.meta.prova.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.meta.prova.dto.VeiculoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Veiculo implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 10, max = 10)
	@NotNull
	private String placa;
	@NotNull
	private Boolean ativo = true;
	@Size(min = 4, max = 4)
	@NotNull
	private String anoFabricacao;
	@NotNull
	@ManyToOne
	@JoinColumn(columnDefinition = "modelo_id")
	private Modelo modelo;
	@Size(min = 4, max = 4)
	@NotNull
	private String anoModelo;
	@Size(min = 40, max = 40)
	@NotNull
	private String chassis;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dtCadastro;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dtDesativacao;
	@Size(min = 1, max = 20)
	private String cor;
	@NotNull
	private Double consumo;
	@NotNull
	private Integer qtPassageiro = 4;
	
	
	public Veiculo(VeiculoDTO veiculoDTO) {
		// TODO Auto-generated constructor stub
	}

}
