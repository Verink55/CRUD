package com.co.periferia.pedidos.dto;

import java.util.List;
import lombok.Data;

@Data
public class ClienteDto {

	private Integer idCliente; 	
	private String nombre; 	
	private String apellido; 	
	private String direccion ; 	
	private String departamento; 	
	private String mesCumpleanos;	
	private List<PedidoDto> pedido;
}
