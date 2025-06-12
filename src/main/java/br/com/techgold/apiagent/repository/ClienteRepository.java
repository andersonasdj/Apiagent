package br.com.techgold.apiagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.techgold.apiagent.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByToken(String token);

}
