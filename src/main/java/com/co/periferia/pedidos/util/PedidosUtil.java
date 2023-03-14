package com.co.periferia.pedidos.util;

import com.co.periferia.pedidos.dto.RespuestaDto;

import lombok.Data;

public class PedidosUtil {
	
	private PedidosUtil() {
		
	}

	public static final String EXITOSAMENTE = "Respuesta exitosa";

	public static final String ERROR = "Algo fallo";
	
	public static final String ERROR200 = "200";

	public static final String ERROR201 = "201";
	
	public static final String ERROR400 = "400";
	
	public static RespuestaDto respuesta(String codigo, String sms, Object resul, Integer totalPag, Integer actualPag) {
		RespuestaDto resp = new RespuestaDto();
		resp.setCodigo(codigo);
		resp.setMensaje(sms);
		resp.setResultado(resul);
		resp.setTotalPag(totalPag);
		resp.setActualPag(actualPag);
		return resp;
	}
	
	
}
