package com.periferia.client.controller;

/*
 * Este proyecto es una crud sencilla de un cliente
 * @author: Veronica S. Jimenez M.
 * @version: 18/01/2023/A
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.periferia.client.dto.ClientDto;
import com.periferia.client.dto.RespuestaDto;
import com.periferia.client.service.ClientService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/api/cliente")
public class ClientController {

	@Autowired
	private ClientService cliService;

	@PostMapping(value = "/crear")
	public ResponseEntity<RespuestaDto> crear(@RequestBody ClientDto cliente) {
		return new ResponseEntity<>(cliService.save(cliente), HttpStatus.CREATED);
	}

	@PostMapping("/actualizar")
	public ResponseEntity<RespuestaDto> actualizar(@RequestBody ClientDto cliente) {
		return new ResponseEntity<>(cliService.actu(cliente), HttpStatus.OK);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<RespuestaDto> listar(@RequestHeader(value = "pag", required = true) int pag) {	
		return new ResponseEntity<>(cliService.findAll(pag), HttpStatus.OK);
	}

	@GetMapping("/uno")
	public ResponseEntity<RespuestaDto> unCliente(@RequestHeader(value = "id", required = true) Long idCliente) {
		return new ResponseEntity<>(cliService.uno(idCliente), HttpStatus.OK);

	}
	@DeleteMapping("/eliminar")
	public ResponseEntity<RespuestaDto> eliminar(@RequestHeader(value = "id", required = true) Long idCliente) {
		return new ResponseEntity<>(cliService.delete(idCliente), HttpStatus.OK);
	}

	/*
	 * todos los controladores devuelven una respuesta dto que contiene 
	 * un codigo, un mensaje y un resultado que contiene el servicio 
	 */
	
}
