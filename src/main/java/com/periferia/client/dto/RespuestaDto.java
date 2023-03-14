package com.periferia.client.dto;

import lombok.Data;

@Data
public class RespuestaDto {
	
	private String mensaje;
	
	private String codigo;
	
	private Object resultado;
}
