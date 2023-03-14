package com.periferia.client.service_impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.periferia.client.dto.ClientDto;
import com.periferia.client.dto.PagDto;
import com.periferia.client.dto.RespuestaDto;
import com.periferia.client.entity.ClientEntity;
import com.periferia.client.repository.IClientRepository;
import com.periferia.client.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private IClientRepository cliRepo;

	@Override
	public RespuestaDto save(ClientDto clientDto) {
		//Instanciar una la clase entity
		ClientEntity modelo = new ClientEntity();
		modelo.setNombreCliente(clientDto.getNombreCliente());
		modelo.setApellidoCliente(clientDto.getApellidoCliente());
		modelo.setEmailCliente(clientDto.getEmailCliente());
		clientDto.setValidacionNom("null");
		return respuesta("201", "Los usuarios son:", cliRepo.save(modelo));
	}

	@Override
	public RespuestaDto actu(ClientDto cliente) {
		//busca si existe anteriormente un cliente
		ClientEntity existecia = cliRepo.findOneCli(cliente.getIdCliente());
		//valida si existe o no
		if (existecia != null) {
			existecia.setNombreCliente(cliente.getNombreCliente());
			existecia.setApellidoCliente(cliente.getApellidoCliente());
			existecia.setEmailCliente(cliente.getEmailCliente());

			return respuesta("200", "Los usuarios son:", cliRepo.save(existecia));
		} else {
			return respuesta("400", "El usuario no existe:", null);
		}
	}
	
	@Override
	public RespuestaDto findAll(int pag) {
		//Instanciar una la clase dto
		PagDto pagDto = new PagDto();
		int size = 2;
		//llamo a 
		Pageable page = PageRequest.of(pag - 1, size);
		Page<ClientEntity> cliententity = cliRepo.findAll(page);
		int totalPages = cliententity.getTotalPages();
		pagDto.setTotalPag(totalPages);
		pagDto.setActualPag(pag);
		pagDto.setClientes(dto(cliententity.getContent()));
		return respuesta("200", "los usuarios son:", pagDto);
	}

	@Override
	public RespuestaDto uno(Long idCliente) {
		ClientEntity existecia = cliRepo.findOneCli(idCliente);
		if (existecia != null) {
			ClientDto dtoi = new ClientDto();
			
			String nombre = existecia.getNombreCliente();
			dtoi.setIdCliente(existecia.getIdCliente());
			dtoi.setNombreCliente(existecia.getNombreCliente());
			dtoi.setApellidoCliente(existecia.getApellidoCliente());
			dtoi.setEmailCliente(existecia.getEmailCliente());
			final String nombres = "Veronica";
			if (existecia.getNombreCliente().equalsIgnoreCase(nombres)) {
				dtoi.setValidacionNom("Tiene acceso");
			} else {
				dtoi.setValidacionNom("No tiene acceso");
			}
			return respuesta("200", "El usuario es:", dtoi);
		} else {
			return respuesta("400", "El usuario no existe", null);
		}
	}

	@Override
	public RespuestaDto delete(Long idCliente) {
		ClientEntity existecia = cliRepo.findOneCli(idCliente);
		if (existecia != null) {
			cliRepo.deleteById(idCliente);
			return respuesta("204", "usuario eliminado:", null);
		} else {
			return respuesta("400", "El usuario no existe:", null);
		}
	}
	
	private List<ClientDto> dto(List<ClientEntity> entity) {
		//Instancio la lacede clientedto de tipo lista y ArrayList
		List<ClientDto> clientDto = new ArrayList<>();
		//Creo un forEach y lleno un cliente dto en cada array 
		entity.stream().forEach(toDto -> {
			ClientDto dtoi = new ClientDto();
			dtoi.setIdCliente(toDto.getIdCliente());
			dtoi.setNombreCliente(toDto.getNombreCliente());
			dtoi.setApellidoCliente(toDto.getApellidoCliente());
			dtoi.setEmailCliente(toDto.getEmailCliente());
			final String nombres = "Veronica";
			if (toDto.getNombreCliente().equalsIgnoreCase(nombres)) {
				dtoi.setValidacionNom("Tiene acceso");
			} else {
				dtoi.setValidacionNom("No tiene acceso");
			}
			clientDto.add(dtoi);
		});
		return clientDto;
	}

	private RespuestaDto respuesta(String codigo, String sms, Object resul) {
		RespuestaDto resp = new RespuestaDto();
		resp.setCodigo(codigo);
		resp.setMensaje(sms);
		resp.setResultado(resul);
		return resp;
	}

}
