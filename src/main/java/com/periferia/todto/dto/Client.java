package com.periferia.todto.dto;

import java.util.List;

import lombok.Data;

@Data
public class Client {

	private int clieClie;

	private int titulo;
	private String numeroDeTitulo;
	private String fechaExpedicion;
	private int oficinaExpedicion;
	private int oficinaResponsable;
	private int tipoBodega;
	private int bodegaLlegada;
	private int bodega;
	private String bodeDireccion;

	private String [][]bodegas;

	private String codigoTitulo;
	private String desde;
	private String hasta;
	private boolean mercanciaTransito;
	private int poliza;
	private int plazoContratoDeposito;
	private String fechaVencimientoContrato;
	private int plazoCertificadoDeposito;
	private String fechaVencimientoCertificado;

	private TipoMercancia tipoMercancia;
	private List<CertiDepoMercancia> certiDepoMercancia;
	private String [][] bonoPrenda;
	private List<Mercancia> mercancia;

	private String [][]mercanciasWms;
	private int tipoTitulo;
	private int tipoOperacion;
	private String estado;
	private String estadoNuevo;
	private int tarifa;
	private int minima;
	private int materialSap;
	private String cobroErp;
	private boolean liberacionImpresion;
	private int contadorTransito;
	private String divisionIngreso;
	private String flujoExpedicion;
	private String codigoSapOfiResponsable;
	private String codigoSapOfiExpedicion;
	private int ingresoOfiExpedicion;
	private String ingresoOfiResponsable;

	private List<ValorTitulos> valorTitulosCliente;
	private List<ListOficRespo> lstOficinasResponsables;
	private List<TipoBodega> tiposBodegas;
	private List<TipoOpeTitulo> tipoOperacionTitulo;
	private List<MaterialSapTitulos> materialSapTitulos;

	private boolean wmsManual;
}
