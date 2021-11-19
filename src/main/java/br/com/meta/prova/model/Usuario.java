package br.com.meta.prova.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Usuario implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 4,max=12, message = "O Login não pode ter menos que 4 e mais que 12 caracteres")
	private String login;
	@NotNull
	@Size(min = 6,max=12, message = "A Senha não pode ter menos que 6 e mais que 12 caracteres")
	private String senha;
	
	
	public Usuario(String login2, String senha2) {
		this.login = login2;
		this.senha = senha2;
	}
}
