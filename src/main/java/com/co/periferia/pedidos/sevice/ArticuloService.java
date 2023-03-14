package com.co.periferia.pedidos.sevice;

import com.co.periferia.pedidos.dto.ArticuloDto;
import com.co.periferia.pedidos.dto.RespuestaDto;

public interface ArticuloService {

	public RespuestaDto saveArt(ArticuloDto articuloDTO);

	public RespuestaDto actuArt(Integer idArticulo, ArticuloDto articuloDTO);

	public RespuestaDto findAllArt(int pag, int size);
	
	public RespuestaDto unoArt(Integer idArticulo);
}
