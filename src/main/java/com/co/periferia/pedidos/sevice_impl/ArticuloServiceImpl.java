package com.co.periferia.pedidos.sevice_impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.co.periferia.pedidos.dto.ArticuloDto;
import com.co.periferia.pedidos.dto.RespuestaDto;
import com.co.periferia.pedidos.entity.ArticuloEntity;
import com.co.periferia.pedidos.repository.IArticuloRepository;
import com.co.periferia.pedidos.sevice.ArticuloService;
import com.co.periferia.pedidos.util.PedidosUtil;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	private IArticuloRepository articuloRepo;

	
	@Override
	public RespuestaDto saveArt(ArticuloDto articuloDTO) {
		return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, articuloRepo.save(dtoToEntity(articuloDTO, new ArticuloEntity())), null, null);
	}

	@Override
	public RespuestaDto actuArt(Integer idArticulo, ArticuloDto articuloDTO) {
		ArticuloEntity existeArt = articuloRepo.findOneArt(idArticulo);
		if (existeArt != null) {
			return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, articuloRepo.save(dtoToEntity(articuloDTO, existeArt)), null, null);
		}
			return PedidosUtil.respuesta(PedidosUtil.ERROR400, PedidosUtil.ERROR, null, null, null);
	}

	@Override
	public RespuestaDto findAllArt(int pag, int size) {
		Pageable page = PageRequest.of(pag - 1, size);
		Page<ArticuloEntity> entityArt = articuloRepo.findAll(page);
		return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, listDto(entityArt.getContent()), entityArt.getTotalPages(), pag);
	}

	@Override
	public RespuestaDto unoArt(Integer idArticulo) {
		ArticuloEntity existeArt = articuloRepo.findOneArt(idArticulo);
		if (existeArt != null) {
			return PedidosUtil.respuesta(PedidosUtil.ERROR200, PedidosUtil.EXITOSAMENTE, entityToDto(new ArticuloDto(), articuloRepo.findOneArt(idArticulo)), null, null);
		}
			return PedidosUtil.respuesta(PedidosUtil.ERROR400, PedidosUtil.ERROR, null, null, null);
	}

	//!!!!Public o privado
	public List<ArticuloDto> listDto(List<ArticuloEntity> entity) {
		List<ArticuloDto> dtoArt = new ArrayList<>();
		entity.stream().forEach(toDto -> {
			ArticuloDto dtoNew = new ArticuloDto();
			dtoNew.setIdArticulo(toDto.getIdArticulo());
			dtoNew.setTitulo(toDto.getTitulo());
			dtoNew.setAutor(toDto.getAutor());
			dtoNew.setEditorial(toDto.getEditorial());
			dtoNew.setPrecio(toDto.getPrecio());
			dtoArt.add(dtoNew);
		});
		return dtoArt;
	}

	// Tenemos un metodo que resive dos parametros que recibe un dto y una entity
	// La entity se llena con el dto
	private ArticuloEntity dtoToEntity(ArticuloDto articuloDTO, ArticuloEntity entity) {
		entity.setTitulo(articuloDTO.getTitulo());
		entity.setAutor(articuloDTO.getAutor());
		entity.setEditorial(articuloDTO.getEditorial());
		entity.setPrecio(articuloDTO.getPrecio());
		return entity;
	}
	
	private ArticuloDto entityToDto(ArticuloDto articuloDTO, ArticuloEntity entity) {
		articuloDTO.setIdArticulo(entity.getIdArticulo());
		articuloDTO.setTitulo(entity.getTitulo());
		articuloDTO.setAutor(entity.getAutor());
		articuloDTO.setEditorial(entity.getEditorial());
		articuloDTO.setPrecio(entity.getPrecio());
		return articuloDTO;
	}
}
