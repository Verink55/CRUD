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

import com.co.periferia.pedidos.dto.PedidoDto;
import com.co.periferia.pedidos.dto.RespuestaDto;
import com.co.periferia.pedidos.sevice.PedidoService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping(value = "/crear")
	public ResponseEntity<RespuestaDto> crear(
			@RequestHeader(value = "idCli", required = true) Integer idCliente,
			@RequestHeader(value = "idArt", required = true) Integer idArticulo, 
			@RequestBody PedidoDto pedidoDto) {
		return new ResponseEntity<>(pedidoService.savePedido(idCliente, idArticulo, pedidoDto), HttpStatus.CREATED);
	}

	@PostMapping("/actualizar")
	public ResponseEntity<RespuestaDto> actualizar(
			@RequestHeader(value = "id", required = true) Integer idPedido,
			@RequestBody PedidoDto pedidoDto) {
		return new ResponseEntity<>(pedidoService.actuPedido(idPedido, pedidoDto), HttpStatus.OK);
	}

	@GetMapping("/todos")
	public ResponseEntity<RespuestaDto> listar(
			@RequestHeader(value = "pag", required = true) int pag,
			@RequestHeader(value = "size", required = true) int size) {
		return new ResponseEntity<>(pedidoService.findAllPedido(pag, size), HttpStatus.OK);
	}

	@GetMapping("/uno")
	public ResponseEntity<RespuestaDto> unCliente(
			@RequestHeader(value = "id", required = true) Integer idPedido) {
		return new ResponseEntity<>(pedidoService.unoPedido(idPedido), HttpStatus.OK);

	}

}
