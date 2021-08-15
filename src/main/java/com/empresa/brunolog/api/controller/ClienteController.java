package com.empresa.brunolog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.brunolog.domain.model.Cliente;
import com.empresa.brunolog.domain.repository.ClienteRepository;

//@AllArgsConstructor //alternativa ao @Autowired
@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
//		return clienteRepository.findAll();
//		return clienteRepository.queryByNome("Bru");
//		return clienteRepository.findByNome("Bruno Pereira");
		return clienteRepository.findByNomeContaining("Bruno");
	}

}
