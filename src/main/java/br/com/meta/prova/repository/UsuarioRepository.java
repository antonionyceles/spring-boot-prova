package br.com.meta.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meta.prova.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);

}
