package com.co.periferia.pedidos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="pedido")
public class PedidoEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private Integer idPedido;
	
	@Column(name="id_cliente")
	private Integer idCliente; 
	
	@Column(name="id_articulo")
	private Integer idArticulo; 
	
	@Column(name="cantidad_pedido")
	private Integer cantidad; 
	
	@Column(name="fecha_pedido")
	private String fecha;
}
