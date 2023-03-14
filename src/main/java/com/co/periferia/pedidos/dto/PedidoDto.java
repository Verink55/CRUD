package com.co.periferia.pedidos.dto;

import java.util.List;

import lombok.Data;

@Data
public class PedidoDto {

	private Integer idPedido;	
	private Integer idCliente;	
	private Integer idArticulo;	
	private Integer cantidad; 	
	private String fecha;	
	private Integer total;	
	private List<ArticuloDto> articulo;
	
}
