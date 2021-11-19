package br.com.meta.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meta.prova.model.Usuario;
import br.com.meta.prova.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Usuario findByLogin(String login) {
		// TODO Auto-generated method stub
		return repository.findByLogin(login);
	}
	

}
