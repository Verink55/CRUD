package com.periferia.todto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.periferia.todto.dto.RespuestaDto;
import com.periferia.todto.service.ClientService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/api/cliente")
public class ClientCotroller {

	@Autowired
	private ClientService cliService;
	
	@GetMapping("/todos")
	public ResponseEntity<RespuestaDto> listar() {	
		return new ResponseEntity<>(cliService.findAll(), HttpStatus.OK);
	}
}
