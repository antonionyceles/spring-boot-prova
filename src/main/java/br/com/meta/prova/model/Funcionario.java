package br.com.meta.prova.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.meta.prova.dto.FuncionarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Funcionario implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 14, max = 14, message = "O CPF não pode ter mais que 11 dígitos")
	@Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
	private String cpf;
	@NotNull
	@Size(min = 5, max = 40, message = "O Nome não pode ter menos que 5 e mais que 40 dígitos")
	private String nome;
	@NotNull
	@Size(min = 5, max = 40, message = "O Sobrenome não pode ter menos que 5 e mais que 40 dígitos")
	private String sobrenome;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dtNascimento;
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	
	public Funcionario(FuncionarioDTO func) {
		this.cpf = func.getCpf();
		this.nome = func.getNome();
		this.sobrenome = func.getSobrenome();
		this.dtNascimento = func.getDtNascimento();
		this.usuario = new Usuario(func.getLogin(),func.getSenha());
	
	}

}
