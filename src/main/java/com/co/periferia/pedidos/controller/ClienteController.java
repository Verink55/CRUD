package com.co.periferia.pedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.periferia.pedidos.dto.ClienteDto;
import com.co.periferia.pedidos.dto.RespuestaDto;
import com.co.periferia.pedidos.sevice.ClienteService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping(value = "/crear")
	public ResponseEntity<RespuestaDto> crear(
			@RequestBody ClienteDto clienteDto) {
		return new ResponseEntity<>(clienteService.saveClient(clienteDto), HttpStatus.CREATED);
	}

	@PostMapping("/actualizar")
	public ResponseEntity<RespuestaDto> actualizar(
			@RequestHeader(value = "id", required = true) Integer idCliente,
			@RequestBody ClienteDto clienteDto) {
		return new ResponseEntity<>(clienteService.actuClient(idCliente, clienteDto), HttpStatus.OK);
	}

	@GetMapping("/todos")
	public ResponseEntity<RespuestaDto> listar(
			@RequestHeader(value = "pag", required = true) int pag,
			@RequestHeader(value = "size", required = true) int size) {
		return new ResponseEntity<>(clienteService.findAllClient(pag, size), HttpStatus.OK);
	}

	@GetMapping("/uno")
	public ResponseEntity<RespuestaDto> unCliente(
			@RequestHeader(value = "id", required = true) Integer idCliente) {
		return new ResponseEntity<>(clienteService.unoClient(idCliente), HttpStatus.OK);

	}

	@GetMapping("/info")
	public ResponseEntity<RespuestaDto> info(
			@RequestHeader(value = "id", required = true) Integer idPedido) {
		return new ResponseEntity<>(clienteService.infoCliente(idPedido), HttpStatus.OK);

	}
}
