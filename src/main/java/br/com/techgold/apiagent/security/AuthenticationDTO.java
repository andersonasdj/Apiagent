package br.com.techgold.apiagent.security;

public record AuthenticationDTO(
		String username, 
		String password) {
}
