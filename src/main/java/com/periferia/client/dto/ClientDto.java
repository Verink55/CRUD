package com.periferia.client.dto;

import lombok.Data;

@Data
public class ClientDto {

	private Long idCliente;
	
    private String nombreCliente;

    private String apellidoCliente;

    private String emailCliente;
    
    private String validacionNom;
}
