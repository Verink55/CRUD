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

import com.co.periferia.pedidos.dto.ArticuloDto;
import com.co.periferia.pedidos.dto.RespuestaDto;
import com.co.periferia.pedidos.sevice.ArticuloService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/articulo")
public class ArticuloController {

	@Autowired
	private ArticuloService articuloService;

	@PostMapping(value = "/crear")
	public ResponseEntity<RespuestaDto> crear(
			@RequestBody ArticuloDto articuloDto) {
		return new ResponseEntity<>(articuloService.saveArt(articuloDto), HttpStatus.CREATED);
	}

	@PostMapping("/actualizar")
	public ResponseEntity<RespuestaDto> actualizar(
			@RequestHeader(value = "id", required = true) Integer idArticulo,
			@RequestBody ArticuloDto articuloDto) {
		return new ResponseEntity<>(articuloService.actuArt(idArticulo, articuloDto), HttpStatus.OK);
	}

	@GetMapping("/todos")
	public ResponseEntity<RespuestaDto> listar(
			@RequestHeader(value = "pag", required = true) int pag,
			@RequestHeader(value = "size", required = true) int size) {
		return new ResponseEntity<>(articuloService.findAllArt(pag, size), HttpStatus.OK);
	}

	@GetMapping("/uno")
	public ResponseEntity<RespuestaDto> unArticulo(
			@RequestHeader(value = "id", required = true) Integer idArticulo) {
		return new ResponseEntity<>(articuloService.unoArt(idArticulo), HttpStatus.OK);
	}

}
