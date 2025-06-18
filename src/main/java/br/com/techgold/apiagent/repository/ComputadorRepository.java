package br.com.techgold.apiagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.techgold.apiagent.model.Computador;

public interface ComputadorRepository extends JpaRepository<Computador, Long>{
	
	public boolean existsBySerial(String serial);

	public Computador findBySerial(String serial);

	public boolean existsBySerialAndName(String serial, String name);

}
