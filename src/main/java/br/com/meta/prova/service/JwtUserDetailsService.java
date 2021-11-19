package br.com.meta.prova.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.meta.prova.model.Usuario;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioService userService;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario user = userService.findByLogin(login);

		if (user.getLogin().equals(login)) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			return new User(login, encoder.encode(user.getSenha()), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with email: " + login);
		}
	}
}