package com.co.periferia.pedidos.sevice_impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.co.periferia.pedidos.dto.PedidoDto;
import com.co.periferia.pedidos.dto.RespuestaDto;
import com.co.periferia.pedidos.entity.ArticuloEntity;
import com.co.periferia.pedidos.entity.ClienteEntity;
import com.co.periferia.pedidos.entity.PedidoEntity;
import com.co.periferia.pedidos.repository.IArticuloRepository;
import com.co.periferia.pedidos.repository.IClienteRepository;
import com.co.periferia.pedidos.repository.IPedidoRepository;
import com.co.periferia.pedidos.sevice.PedidoService;
import com.co.periferia.pedidos.util.PedidosUtil;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private IClienteRepository clienteRepo;

	@Autowired
	private IArticuloRepository articuloRepo;

	@Autowired
	private IPedidoRepository pedidoRepo;

	@Override
	public RespuestaDto savePedido(Integer idCliente, Integer idArticulo, PedidoDto pedidoDTO) {
		ClienteEntity existeCli = clienteRepo.findOneCli(idCliente);
		if (existeCli != null) {
			ArticuloEntity existeArt = articuloRepo.findOneArt(idArticulo);
			if (existeArt != null) {
				return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, pedidoRepo.save(dtoToEntity(pedidoDTO, new PedidoEntity())), null, null);
			}
			return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, null, null, null);
		} else
			return PedidosUtil.respuesta(PedidosUtil.ERROR400, PedidosUtil.ERROR, null, null, null);
	}

	@Override
	public RespuestaDto actuPedido(Integer idPedido, PedidoDto pedidoDTO) {
		PedidoEntity existePed = pedidoRepo.findOnePed(idPedido);
		if (existePed != null) {
			return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, pedidoRepo.save(dtoToEntity(pedidoDTO, existePed)), null, null);
		} else {
			return PedidosUtil.respuesta(PedidosUtil.ERROR400, PedidosUtil.ERROR, null, null, null);
		}
	}

	@Override
	public RespuestaDto findAllPedido(int pag, int size) {
		Pageable page = PageRequest.of(pag - 1, size);
		Page<PedidoEntity> entityPed = pedidoRepo.findAll(page);
		return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, listDto(entityPed.getContent()), entityPed.getTotalPages(), pag);
	}

	@Override
	public RespuestaDto unoPedido(Integer idPedido) {
		PedidoEntity existePed = pedidoRepo.findOnePed(idPedido);
		if (existePed != null) {
			return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, entityToDto(new PedidoDto(), pedidoRepo.findOnePed(idPedido)), null, null);
		} 
			return PedidosUtil.respuesta(PedidosUtil.ERROR400, PedidosUtil.ERROR, null, null, null);
	}

	private List<PedidoDto> listDto(List<PedidoEntity> entity) {
		List<PedidoDto> dtoPed = new ArrayList<>();
		entity.stream().forEach(toDto -> {
			PedidoDto dtoNew = new PedidoDto();
			ArticuloEntity existeArt = articuloRepo.findOneArt(toDto.getIdArticulo());
			dtoNew.setIdPedido(toDto.getIdPedido());
			dtoNew.setIdCliente(toDto.getIdCliente());
			dtoNew.setIdArticulo(toDto.getIdArticulo());
			dtoNew.setFecha(toDto.getFecha());
			dtoNew.setCantidad(toDto.getCantidad());
			dtoNew.setTotal(existeArt.getPrecio() * toDto.getCantidad());

			dtoPed.add(dtoNew);
		});
		return dtoPed;
	}

	// Tenemos un metodo que resive dos parametros que recibe un dto y una entity
	// La entity se llena con el dto
	private PedidoEntity dtoToEntity(PedidoDto pedidoDTO, PedidoEntity entity) {
		entity.setIdCliente(pedidoDTO.getIdCliente());
		entity.setIdArticulo(pedidoDTO.getIdArticulo());
		entity.setFecha(pedidoDTO.getFecha());
		entity.setCantidad(pedidoDTO.getCantidad());
		return entity;
	}

	private PedidoDto entityToDto(PedidoDto pedidoDTO, PedidoEntity entity) {
		ArticuloEntity existeArt = articuloRepo.findOneArt(entity.getIdArticulo());
		pedidoDTO.setIdPedido(entity.getIdPedido());
		pedidoDTO.setIdCliente(entity.getIdCliente());
		pedidoDTO.setIdArticulo(entity.getIdArticulo());
		pedidoDTO.setFecha(entity.getFecha());
		pedidoDTO.setCantidad(entity.getCantidad());
		pedidoDTO.setTotal(existeArt.getPrecio() * entity.getCantidad());
		return pedidoDTO;
	}

}
