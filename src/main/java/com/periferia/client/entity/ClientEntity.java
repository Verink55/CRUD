package com.periferia.client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class ClientEntity {

	@Id
	@Column(name = "idCliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
	
	@Column(name = "nombre")
    private String nombreCliente;

	@Column(name = "apellido")
    private String apellidoCliente;

	@Column(name = "email")
    private String emailCliente;
}
