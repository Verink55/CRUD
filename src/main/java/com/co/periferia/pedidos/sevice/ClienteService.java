package com.co.periferia.pedidos.sevice;

import com.co.periferia.pedidos.dto.ClienteDto;
import com.co.periferia.pedidos.dto.RespuestaDto;

public interface ClienteService {

	public RespuestaDto saveClient(ClienteDto clienteDTO);

	public RespuestaDto actuClient(Integer idCliente,ClienteDto clienteDTO);

	public RespuestaDto findAllClient(int pag, int size);
	
	public RespuestaDto unoClient(Integer idCliente);
	
	public RespuestaDto infoCliente(Integer idPedido);
}
