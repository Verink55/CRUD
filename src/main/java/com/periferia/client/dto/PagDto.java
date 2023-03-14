package com.periferia.client.dto;

import java.util.List;

import lombok.Data;

@Data
public class PagDto {
	
	private List<ClientDto> clientes;
	
	private int totalPag;
	
	private int actualPag;
}
