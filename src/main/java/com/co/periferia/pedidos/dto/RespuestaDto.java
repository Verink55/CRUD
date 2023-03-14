package com.co.periferia.pedidos.dto;

import lombok.Data;

@Data
public class RespuestaDto {

	private String mensaje;	
	private String codigo;	
	private Object resultado;	
	private Integer totalPag;	
	private Integer actualPag;
}
