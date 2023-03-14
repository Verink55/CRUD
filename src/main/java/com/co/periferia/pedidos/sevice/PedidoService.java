package com.co.periferia.pedidos.sevice;

import com.co.periferia.pedidos.dto.PedidoDto;
import com.co.periferia.pedidos.dto.RespuestaDto;

public interface PedidoService {

	public RespuestaDto savePedido(Integer idCliente, Integer idArticulo, PedidoDto pedidoDTO);

	public RespuestaDto actuPedido(Integer idPedido, PedidoDto pedidoDTO);

	public RespuestaDto findAllPedido(int pag, int size);
	
	public RespuestaDto unoPedido(Integer idCliente);
	
}
