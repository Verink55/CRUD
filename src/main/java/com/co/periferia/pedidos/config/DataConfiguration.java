package com.co.periferia.pedidos.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.co.periferia.pedidos.dto.SecretDbDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.co.periferia.pedidos.repository", entityManagerFactoryRef = "sqlEntityManagerFactory", transactionManagerRef = "sqlTransactionManager")
public class DataConfiguration {

	//@Autowired
	//private Environment env;

    @Primary
    @Bean(name = "readDataSource")
    DataSource readDatasource() {
        log.info("INGRESO A CONEXION A LA BASE DE DATOS");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        //
		SecretDbDto secretDB = new SecretDbDto();
		secretDB.setHost("localhost");
		secretDB.setNameDb("crud_pedido?useSSL=false");
		secretDB.setPassword("2005");
		secretDB.setPort("2000");
		secretDB.setUser("root");

        dataSource.setUrl("jdbc:mysql://localhost/crud_pedido");
        dataSource.setUsername(secretDB.getUser());
        dataSource.setPassword(secretDB.getPassword());
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        log.info("SE CONECTO! " + dataSource.getUrl());
        log.info("SALIO DE LA CONEXION", Thread.currentThread().getStackTrace()[1].getMethodName());
        return dataSource;        
    }

	@Primary
	@Bean(name = "sqlEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		log.info("ENTRO A CONECTAR A LAS ENTIDADES", Thread.currentThread().getStackTrace()[1].getMethodName());
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(readDatasource());
		em.setPackagesToScan("com.co.periferia.pedidos.entity");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		return em;
	}

	@Primary
	@Bean(name = "sqlTransactionManager")
	PlatformTransactionManager transactionManager() {
		log.info("ENTRO A CONECTAR LA TRANSACCION", Thread.currentThread().getStackTrace()[1].getMethodName());
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		log.info("Recurso de base de datos de sql server cargado correctamente");
		log.info("SALIO DE LA CONEXION", Thread.currentThread().getStackTrace()[1].getMethodName());
		return transactionManager;
	}

}
