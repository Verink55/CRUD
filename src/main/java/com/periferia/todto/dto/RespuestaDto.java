package com.periferia.todto.dto;

import lombok.Data;

@Data
public class RespuestaDto {

	private String codigoEstado;
	private String mensajeEstado;
    private Object resultado;
}
