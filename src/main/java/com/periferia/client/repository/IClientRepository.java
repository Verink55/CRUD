package com.periferia.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.periferia.client.entity.ClientEntity;

public interface IClientRepository extends JpaRepository<ClientEntity, Object>{
	
	//Creo una sentencia en la que llamo a una sola entidad mediante un id
	@Query(value = "SELECT cli FROM ClientEntity cli WHERE cli.idCliente = :idCliente")
	public ClientEntity findOneCli(@Param("idCliente") Object idCliente);
		 
}
