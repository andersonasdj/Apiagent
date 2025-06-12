package br.com.techgold.apiagent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.techgold.apiagent.model.Cliente;
import br.com.techgold.apiagent.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired ClienteRepository repository;
	
	
	public Cliente buscaPorToken(String token) {
		return repository.findByToken(token);
	}
	
}
