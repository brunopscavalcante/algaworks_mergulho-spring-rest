package com.empresa.brunolog.api.model.input;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaModel {
	
	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;

}
