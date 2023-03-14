package com.co.periferia.pedidos.dto;

import lombok.Data;

@Data
public class ArticuloDto {

	private Integer idArticulo;
	private String titulo; 
	private String autor; 	
	private String editorial;	
	private Integer precio;
}
