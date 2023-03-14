package com.periferia.client.service;

import com.periferia.client.dto.ClientDto;
import com.periferia.client.dto.RespuestaDto;

public interface ClientService {

	public RespuestaDto save(ClientDto cliente);

	public RespuestaDto actu(ClientDto cliente);

	public RespuestaDto findAll(int pag);
	
	public RespuestaDto uno(Long idCliente);

	public RespuestaDto delete(Long idCliente);
	
}
