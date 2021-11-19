package br.com.meta.prova.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.meta.prova.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class FuncionarioDTO {
	
	
	private Long id;
	private String cpf;
	private String nome;
	private String sobrenome;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtNascimento;
	private String login;
	private String senha;
	
	
	public static FuncionarioDTO fromEntity(Funcionario func) {
		return new FuncionarioDTO(func);
	}
	
	public FuncionarioDTO(Funcionario func) {
		this.id = func.getId();
		this.cpf = func.getCpf();
		this.nome = func.getNome();
		this.sobrenome = func.getSobrenome();
		this.dtNascimento = func.getDtNascimento();
		this.login = func.getUsuario().getLogin();
	}

}
