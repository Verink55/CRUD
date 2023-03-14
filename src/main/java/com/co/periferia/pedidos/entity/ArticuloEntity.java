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
@Table(name="articulo")
public class ArticuloEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_articulo")
	private Integer idArticulo;
	
	@Column(name="titulo_articulo")
	private String titulo; 
	
	@Column(name="autor_articulo")
	private String autor; 
	
	@Column(name="editorial_articulo")
	private String editorial; 
	
	@Column(name="precio_articulo")
	private Integer precio;
}

