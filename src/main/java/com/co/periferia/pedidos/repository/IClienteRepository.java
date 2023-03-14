package com.co.periferia.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.periferia.pedidos.entity.ClienteEntity;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Integer>{

	@Query(value = "SELECT cli FROM ClienteEntity cli WHERE cli.idCliente = :idCliente")
	public ClienteEntity findOneCli(@Param("idCliente") Integer idCliente);
}
