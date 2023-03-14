package com.co.periferia.pedidos.sevice_impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.co.periferia.pedidos.dto.ClienteDto;
import com.co.periferia.pedidos.dto.PedidoDto;
import com.co.periferia.pedidos.dto.RespuestaDto;
import com.co.periferia.pedidos.entity.ArticuloEntity;
import com.co.periferia.pedidos.entity.ClienteEntity;
import com.co.periferia.pedidos.entity.PedidoEntity;
import com.co.periferia.pedidos.repository.IArticuloRepository;
import com.co.periferia.pedidos.repository.IClienteRepository;
import com.co.periferia.pedidos.repository.IPedidoRepository;
import com.co.periferia.pedidos.sevice.ClienteService;
import com.co.periferia.pedidos.util.PedidosUtil;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private IClienteRepository clienteRepo;

	@Autowired
	private IPedidoRepository pedidoRepo;

	@Autowired
	private IArticuloRepository articuloRepo;
	
	@Autowired
	private ArticuloServiceImpl articuloSI;

	@Override
	public RespuestaDto saveClient(ClienteDto clienteDTO) {
		return PedidosUtil.respuesta(PedidosUtil.ERROR201, PedidosUtil.EXITOSAMENTE,
				clienteRepo.save(dtoToEntity(clienteDTO, new ClienteEntity())), null, null);
	}

	@Override
	public RespuestaDto actuClient(Integer idCliente, ClienteDto clienteDTO) {
		ClienteEntity existeCli = clienteRepo.findOneCli(idCliente);
		if (existeCli != null) {
			return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE,
					clienteRepo.save(dtoToEntity(clienteDTO, existeCli)), null, null);
		}
			return PedidosUtil.respuesta(PedidosUtil.ERROR400, PedidosUtil.ERROR, null, null, null);
	}

	@Override
	public RespuestaDto findAllClient(int pag, int size) {
		Pageable page = PageRequest.of(pag - 1, size);
		Page<ClienteEntity> entityCli = clienteRepo.findAll(page);
		return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, listDto(entityCli.getContent()),
				entityCli.getTotalPages(), pag);
	}

	@Override
	public RespuestaDto unoClient(Integer idCliente) {
		ClienteEntity existeCli = clienteRepo.findOneCli(idCliente);
		if (existeCli != null) {
			return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE,
					entityToDto(new ClienteDto(), clienteRepo.findOneCli(idCliente)), null, null);
		}
			return PedidosUtil.respuesta(PedidosUtil.ERROR400, PedidosUtil.ERROR, null, null, null);
	}

	@Override
	public RespuestaDto infoCliente(Integer idPedido) {
		ClienteEntity entityCli = clienteRepo.findOneCli(idPedido);
		ClienteDto dtoNew = new ClienteDto();
		dtoNew.setIdCliente(entityCli.getIdCliente());
		dtoNew.setNombre(entityCli.getNombre());
		dtoNew.setApellido(entityCli.getApellido());
		dtoNew.setDireccion(entityCli.getDireccion());
		dtoNew.setDepartamento(entityCli.getDepartamento());
		dtoNew.setMesCumpleanos(entityCli.getMesCumpleanos());

		List<PedidoEntity> entityPed = pedidoRepo.reportePed(idPedido);
		dtoNew.setPedido(dtoPed(entityPed));
		return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, dtoNew, null, null);
	}

	private List<ClienteDto> listDto(List<ClienteEntity> entity) {
		List<ClienteDto> dtoCli = new ArrayList<>();
		entity.stream().filter(nombre -> nombre.getNombre() == "Veronica").forEach(toDto -> {
			ClienteDto dtoNew = new ClienteDto();
			dtoNew.setIdCliente(toDto.getIdCliente());
			dtoNew.setNombre(toDto.getNombre());
			dtoNew.setApellido(toDto.getApellido());
			dtoNew.setDireccion(toDto.getDireccion());
			dtoNew.setDepartamento(toDto.getDepartamento());
			dtoNew.setMesCumpleanos(toDto.getMesCumpleanos());
			dtoCli.add(dtoNew);
		});
		return dtoCli;
	}

	private List<PedidoDto> dtoPed(List<PedidoEntity> entity) {
		List<PedidoDto> dtoPed = new ArrayList<>();
		entity.stream().forEach(toDto -> {
			PedidoDto dtoNew = new PedidoDto();
			dtoNew.setIdPedido(toDto.getIdPedido());
			dtoNew.setIdCliente(toDto.getIdCliente());
			dtoNew.setIdArticulo(toDto.getIdArticulo());
			dtoNew.setFecha(toDto.getFecha());
			dtoNew.setCantidad(toDto.getCantidad());

			ArticuloEntity articulo = articuloRepo.findOneArt(toDto.getIdArticulo());
			dtoNew.setTotal(articulo.getPrecio() * toDto.getCantidad());

			List<ArticuloEntity> entityArt = articuloRepo.reporteArt(toDto.getIdArticulo());
			dtoNew.setArticulo(articuloSI.listDto(entityArt));
			dtoPed.add(dtoNew);
		});
		return dtoPed;
	}

	private ClienteEntity dtoToEntity(ClienteDto clienteDTO, ClienteEntity entity) {
		entity.setNombre(clienteDTO.getNombre());
		entity.setApellido(clienteDTO.getApellido());
		entity.setDireccion(clienteDTO.getDireccion());
		entity.setDepartamento(clienteDTO.getDepartamento());
		entity.setMesCumpleanos(clienteDTO.getMesCumpleanos());
		return entity;
	}

	private ClienteDto entityToDto(ClienteDto clienteDTO, ClienteEntity entity) {
		clienteDTO.setIdCliente(entity.getIdCliente());
		clienteDTO.setNombre(entity.getNombre());
		clienteDTO.setApellido(entity.getApellido());
		clienteDTO.setDireccion(entity.getDireccion());
		clienteDTO.setDepartamento(entity.getDepartamento());
		clienteDTO.setMesCumpleanos(entity.getMesCumpleanos());
		return clienteDTO;
	}

}
