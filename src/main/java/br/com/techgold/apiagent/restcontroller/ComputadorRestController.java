package br.com.techgold.apiagent.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techgold.apiagent.dto.DadosComputador;
import br.com.techgold.apiagent.model.Cliente;
import br.com.techgold.apiagent.service.ClienteService;
import br.com.techgold.apiagent.service.ComputadorService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1/computadores")
public class ComputadorRestController {
	
	@Autowired private ComputadorService service;
	@Autowired private ClienteService clienteService;
	
	@PostMapping
	@PreAuthorize("hasRole('AGENT')")					//CADASTRAR COMPUTADOR
	public ResponseEntity<?> registrar(@RequestBody DadosComputador dto, HttpServletRequest request) {	
		
		 String token = recuperarToken(request);
		 Cliente cliente = clienteService.buscaPorToken(token);
		 
		if(service.existePorSerial(dto.uuid(), dto.name()) && cliente != null) {
			service.atualizaComputador(dto, cliente);	//ATUALIZA UM JÀ EXISTENTE
			return ResponseEntity.ok().build();
		}if (cliente != null) {
			service.cadastrarNovo(dto, cliente);		//CADASTRA NOVO
		    return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.ok().build();			//NÂO CADASTRA SEM TOKEN ASSOCIADO
		}
		
	}

	private String recuperarToken(HttpServletRequest request) {
	    String authHeader = request.getHeader("Authorization");
	    if (authHeader != null && authHeader.startsWith("Bearer ")) {
	        return authHeader.substring(7); 
	    }
	    return null;
	}

}
