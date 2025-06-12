package br.com.techgold.apiagent.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.techgold.apiagent.service.FuncionarioService;

@Service
public class AuthorizationService implements UserDetailsService{
	
	@Autowired
	FuncionarioService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = service.buscaPorUserDetails(username.toLowerCase());
		if(user == null) {
			throw new Error("User does not exists!");
		}else {
			return user;
		}
	}

}
