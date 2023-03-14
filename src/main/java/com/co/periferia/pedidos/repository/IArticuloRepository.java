package com.co.periferia.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.periferia.pedidos.entity.ArticuloEntity;

public interface IArticuloRepository extends JpaRepository<ArticuloEntity, Integer> {
	
	@Query(value = "SELECT art FROM ArticuloEntity art WHERE art.idArticulo = :idArticulo")
	public ArticuloEntity findOneArt(@Param("idArticulo") Integer idArticulo); 

	@Query(value = "SELECT art FROM PedidoEntity ped INNER JOIN ArticuloEntity art ON ped.idArticulo = art.idArticulo WHERE art.idArticulo = :idArticulo ")
	public List<ArticuloEntity> reporteArt (@Param("idArticulo") Integer idArticulo);	
}
