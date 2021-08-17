package com.empresa.brunolog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.brunolog.api.assembler.EntregaAssembler;
import com.empresa.brunolog.api.model.EntregaModel;
import com.empresa.brunolog.api.model.input.EntregaInput;
import com.empresa.brunolog.domain.model.service.EntregaService;
import com.empresa.brunolog.domain.model.service.FinalizacaoEntregaService;
import com.empresa.brunolog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaRepository entregaRepository;
	private EntregaService entregaService;
	private FinalizacaoEntregaService finalizacaoEntregaService;
	private EntregaAssembler entregaAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		return entregaAssembler.toModel(entregaService.solicitar(entregaAssembler.toEntity(entregaInput)));
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizacao(@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}

	@GetMapping
	public List<EntregaModel> listar() {
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
