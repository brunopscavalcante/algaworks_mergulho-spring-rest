package com.empresa.brunolog.domain.model.service;

import org.springframework.stereotype.Service;

import com.empresa.brunolog.domain.model.Entrega;
import com.empresa.brunolog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

	private EntregaRepository entregaRepository;
	private EntregaService entregaService;
	
	public void finalizar(Long entregaId) {
		Entrega entrega = entregaService.buscar(entregaId);
		
		entrega.finalizar();

		entregaRepository.save(entrega);
	}
	
}
