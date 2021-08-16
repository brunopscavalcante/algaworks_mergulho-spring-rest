package com.empresa.brunolog.domain.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.brunolog.domain.model.Entrega;
import com.empresa.brunolog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OcorrenciaService {

	private EntregaService entregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = entregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
	}
}
