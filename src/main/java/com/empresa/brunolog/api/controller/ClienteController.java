package com.empresa.brunolog.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.brunolog.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return new ArrayList<Cliente>(Arrays.asList(
				new Cliente(1L, "Bruno", "bruno@email.com", "9999-8888"),
				new Cliente(2L, "Ari", "ari@email.com", "9999-7777")));
	}

}
