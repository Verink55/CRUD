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
@Table(name="cliente")
public class ClienteEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Integer idCliente; 
	
	@Column(name="nombre_cliente")
	private String nombre; 
	
	@Column(name="apellido_cliente")
	private String apellido; 
	
	@Column(name="direccion_cliente")
	private String direccion ; 
	
	@Column(name="departamento_cliente")
	private String departamento; 
	
	@Column(name="mescumpleanos_cliente")
	private String mesCumpleanos;
}
