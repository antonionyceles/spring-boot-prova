package br.com.meta.prova.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.meta.prova.model.Veiculo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VeiculoDTO {

	private Long id;

	private String placa;

	private Boolean ativo;

	private String anoFabricacao;

	private String modelo;

	private String anoModelo;

	private String chassis;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtCadastro;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtDesativacao;

	private String cor;

	private Double consumo;

	private Integer qtPassageiro;
	
	
	public VeiculoDTO(Veiculo veiculo) {
		this.id=veiculo.getId();
		this.placa=veiculo.getPlaca();
		this.ativo=veiculo.getAtivo();
		this.anoFabricacao=veiculo.getAnoFabricacao();
		this.modelo=veiculo.getModelo().getNome();
		this.anoModelo=veiculo.getAnoModelo();
		this.chassis=veiculo.getChassis();
		this.dtCadastro=veiculo.getDtCadastro();
		this.dtDesativacao=veiculo.getDtDesativacao();
		this.cor=veiculo.getCor();
		this.consumo=veiculo.getConsumo();
		this.qtPassageiro=veiculo.getQtPassageiro();
	}

}
