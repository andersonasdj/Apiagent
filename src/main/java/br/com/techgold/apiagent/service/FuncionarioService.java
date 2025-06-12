package br.com.techgold.apiagent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.techgold.apiagent.model.Funcionario;
import br.com.techgold.apiagent.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository repository;
	
	@Cacheable(value="idFuncionariosAtivos")
	public List<String> listarIdFuncionariosAtivos() {
		return repository.listarIdFuncionarios();
	}
	
	public int existeFuncionarios() {
		return repository.existsFuncionarios();
	}
	
	public Boolean existePorNomeFuncionario(String nome) {
		return repository.existsByNomeFuncionario(nome);
	}
	
	public String buscaNomeFuncionarioPorId(Long id) {
		return repository.buscarNomePorId(id);
	}
	
	public Funcionario buscaPorNome(String nome) {
		return repository.findBynomeFuncionario(nome);
	}
	
	public UserDetails buscaPorUserDetails(String nome) {
		return repository.findByUsername(nome);
	}

	public List<String> listarNomesCliente() {
		return repository.listarNomesFuncionarios();
	}
	
	public List<Long> listarIdFuncionarosLong() {
		return repository.listarIdFuncionariosLong();
	}

	public Boolean exigeTrocaDeSenha(Long id) {
		return repository.exigeTrocaDeSenha(id);
	}

}
