package com.co.periferia.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.periferia.pedidos.entity.PedidoEntity;


public interface IPedidoRepository extends JpaRepository<PedidoEntity, Integer>{

	@Query(value = "SELECT ped FROM PedidoEntity ped WHERE ped.idPedido = :idPedido")
	public PedidoEntity findOnePed(@Param("idPedido") Integer idPedido);	

	@Query(value = "SELECT ped FROM ClienteEntity cli INNER JOIN PedidoEntity ped ON cli.idCliente = ped.idCliente WHERE cli.idCliente = :idCliente ")
	public List<PedidoEntity> reportePed (@Param("idCliente") Integer idCliente);	
}
