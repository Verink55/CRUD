package com.periferia.todto.service_impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.periferia.todto.dto.CertiDepoMercancia;
import com.periferia.todto.dto.Client;
import com.periferia.todto.dto.ListOficRespo;
import com.periferia.todto.dto.MaterialSapTitulos;
import com.periferia.todto.dto.Mercancia;
import com.periferia.todto.dto.RespuestaDto;
import com.periferia.todto.dto.TipoBodega;
import com.periferia.todto.dto.TipoMercancia;
import com.periferia.todto.dto.TipoOpeTitulo;
import com.periferia.todto.dto.ValorTitulos;
import com.periferia.todto.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	String fecha = "31/10/2021";
	String almac = "Almacenamiento";
	String admin = "admin";
	String peri = "Periferia";
	String fechaHora = "2020-07-07T05:00:00.000+00:00";
	String fechaHora2 = "2020-08-28T22:16:19.878+00:00";
	
	@Override
	public RespuestaDto findAll() {
		Client cliente = new Client();
		cliente.setClieClie(741);
		cliente.setTitulo(2851);
		cliente.setNumeroDeTitulo("C2851");
		cliente.setFechaExpedicion("26/10/2021");
		cliente.setOficinaExpedicion(5);
		cliente.setOficinaResponsable(1);
		cliente.setTipoBodega(2);
		cliente.setBodegaLlegada(2);
		cliente.setBodega(294);
		cliente.setBodeDireccion(null);
		
		cliente.setBodegas(null);
		
		cliente.setCodigoTitulo(null);
		cliente.setDesde(null);
		cliente.setHasta(null);
		cliente.setMercanciaTransito(false);
		cliente.setPoliza(728);
		cliente.setPlazoContratoDeposito(5);
		cliente.setFechaVencimientoContrato(fecha);
		cliente.setPlazoCertificadoDeposito(5);
		cliente.setFechaVencimientoCertificado(fecha);
			
		cliente.setTipoMercancia(tipMerca());
		
		cliente.setCertiDepoMercancia(certi());
		cliente.setBonoPrenda(null);
		cliente.setMercancia(merca());
		
		cliente.setMercanciasWms(null);
		
		cliente.setTipoTitulo(1);
		cliente.setTipoOperacion(1);
		cliente.setEstado("APLICADO");
		cliente.setEstadoNuevo(null);
		cliente.setTarifa(10);
		cliente.setMinima(10);
		cliente.setMaterialSap(4);
		cliente.setCobroErp(null);
		cliente.setLiberacionImpresion(true);
		cliente.setContadorTransito(0);
		cliente.setDivisionIngreso("no");
		cliente.setFlujoExpedicion(null);
		cliente.setCodigoSapOfiResponsable(null);
		cliente.setCodigoSapOfiExpedicion("5678");
		cliente.setIngresoOfiExpedicion(100);
		cliente.setIngresoOfiResponsable(null);
		
		cliente.setValorTitulosCliente(valTilClient());
		cliente.setLstOficinasResponsables(listOfiRepo());
		cliente.setTiposBodegas(tipBodegas());
		cliente.setTipoOperacionTitulo(tipOpeTil());
		cliente.setMaterialSapTitulos(material());
		
		return respuesta("200", "Ok:", cliente );
	}
	
	private TipoMercancia tipMerca(){		
		TipoMercancia tipMercan = new TipoMercancia();
		tipMercan.setTimeCodigo(25);
		tipMercan.setMerma("34");
		tipMercan.setAplicaCondicionCalidad("no");
		tipMercan.setObservaciones("acites");
		tipMercan.setTimeDescripcion("prueba a");
		
		return tipMercan;
	}
	
	private List<CertiDepoMercancia> certi() {

		List<CertiDepoMercancia> certiMerca = new ArrayList<>();

		CertiDepoMercancia cerDepoMer = new CertiDepoMercancia();
		cerDepoMer.setId(566);
		cerDepoMer.setTipointeres("Propiedad");
		cerDepoMer.setFendoso( "12/11/2021");
		cerDepoMer.setCliente(741);
		cerDepoMer.setTitulo(2851);
		cerDepoMer.setEstado("ACT");
		cerDepoMer.setAcreedor(964);
		cerDepoMer.setNit("9004184153");
		cerDepoMer.setNombre("INBIOS S.A.S.");
		cerDepoMer.setDireccion("CR 43 C 7 D 38");
		cerDepoMer.setCiudad("MEDELL�?N");
		cerDepoMer.setCorreo("csuarezz@almaviva.com.co");
			
			certiMerca.add(cerDepoMer);
		return certiMerca;
	}

	private List<Mercancia> merca() {

		List<Mercancia> mercancia = new ArrayList<>();

		Mercancia merca = new Mercancia();
		merca.setId(786);
		merca.setTitulo(2851);
		merca.setDetalleMercancia("prueb");
		merca.setUnidadMedida(44);
		merca.setUnidadMedidaNombre("KILITOS actIn New York City, a bodega is a small owner-operated convenience store. Its name is deriv");
		merca.setUnidadMedidaSuper("33");
		merca.setValorConversion("12");
		merca.setCantidad(3);
		merca.setCantidadInicial(5);
		merca.setValorUnitario(1);
		merca.setValorTotal(8);
		merca.setFechaVencimiento(fecha);
		merca.setObservaciones("vfds");
		merca.setEstado("ACT");
		merca.setIdLiberacion(0);
			
		mercancia.add(merca);
		return mercancia;
	}

	private List<ValorTitulos> valTilClient() {

		List<ValorTitulos> valTil = new ArrayList<>();

		ValorTitulos valorTitulo1 = new ValorTitulos();
		valorTitulo1.setModalidad("Propia");
		valorTitulo1.setValorTotalTitulos(80);
		
		ValorTitulos valorTitulo2 = new ValorTitulos();
		valorTitulo2.setModalidad("Particular");
		valorTitulo2.setValorTotalTitulos((int) 2469106949.4718347);
		
		ValorTitulos valorTitulo3 = new ValorTitulos();
		valorTitulo3.setModalidad("Particular Arrendada");
		valorTitulo3.setValorTotalTitulos(1498294);
		
		ValorTitulos valorTitulo4 = new ValorTitulos();
		valorTitulo4.setModalidad("Transito");
		valorTitulo4.setValorTotalTitulos(125174);
			
		valTil.add(valorTitulo1);
		valTil.add(valorTitulo2);
		valTil.add(valorTitulo3);
		valTil.add(valorTitulo4);
		return valTil;
	}
	
	private List<ListOficRespo> listOfiRepo() {

		List<ListOficRespo> oficinas = new ArrayList<>();

		ListOficRespo ofic1 = new ListOficRespo();
		ofic1.setOficNombre("BOGOTA - AUTOPISTA SUR");
		ofic1.setOficCodigo(617);
		ofic1.setOficMunicipio(1);
		ofic1.setOficDepartamento(3);
		ofic1.setOficPais(92);
		ofic1.setOficEstado("ACT");
		ofic1.setOficUcreacion(peri);
		ofic1.setOficFcreacion(fechaHora);
		ofic1.setOficOfic(5);
		ofic1.setNotificacionOficina(false);
		
		ListOficRespo ofic2 = new ListOficRespo();
		ofic2.setOficNombre("BOGOTA BAT");
		ofic2.setOficCodigo(603);
		ofic2.setOficMunicipio(1);
		ofic2.setOficDepartamento(3);
		ofic2.setOficPais(92);
		ofic2.setOficEstado("ACT");
		ofic2.setOficUcreacion(peri);
		ofic2.setOficFcreacion(fechaHora);
		ofic2.setOficOfic(82);
		ofic2.setNotificacionOficina(false);
		
		ListOficRespo ofic3 = new ListOficRespo();
		ofic3.setOficNombre("DIRECCION GENERAL");
		ofic3.setOficCodigo(761);
		ofic3.setOficMunicipio(1);
		ofic3.setOficDepartamento(11);
		ofic3.setOficPais(92);
		ofic3.setOficEstado("ACT");
		ofic3.setOficUcreacion(peri);
		ofic3.setOficFcreacion(fechaHora);
		ofic3.setOficOfic(1);
		ofic3.setNotificacionOficina(false);
			
		oficinas.add(ofic1);
		oficinas.add(ofic2);
		oficinas.add(ofic3);
		return oficinas;
	}

	private List<TipoBodega> tipBodegas() {

		List<TipoBodega> tipoBod = new ArrayList<>();

		TipoBodega bodega1 = new TipoBodega();
		bodega1.setTiboTibo(1);
		bodega1.setTiboNombre( almac);
		bodega1.setTiboDescripcion("Propia");
		bodega1.setTiboEstado("ACT");
		bodega1.setTiboUcreacion(peri);
		bodega1.setTiboFcreacion(fechaHora2);
		bodega1.setTiboUactualizacion(null);
		bodega1.setTiboFactualizacion("2020-08-28T22:16:33.564+00:00");
		
		TipoBodega bodega2 = new TipoBodega();
		bodega2.setTiboTibo(2);
		bodega2.setTiboNombre(almac);
		bodega2.setTiboDescripcion("Particular");
		bodega2.setTiboEstado("ACT");
		bodega2.setTiboUcreacion(peri);
		bodega2.setTiboFcreacion(fechaHora2);
		bodega2.setTiboUactualizacion(null);
		bodega2.setTiboFactualizacion("2020-08-28T22:17:14.644+00:00");
		
		TipoBodega bodega3 = new TipoBodega();
		bodega3.setTiboTibo(3);
		bodega3.setTiboNombre(almac);
		bodega3.setTiboDescripcion("Particular Arrendada");
		bodega3.setTiboEstado("ACT");
		bodega3.setTiboUcreacion(peri);
		bodega3.setTiboFcreacion(fechaHora2);
		bodega3.setTiboUactualizacion(null);
		bodega3.setTiboFactualizacion("2020-08-28T22:17:14.677+00:00");
		
		TipoBodega bodega4 = new TipoBodega();
		bodega4.setTiboTibo(4);
		bodega4.setTiboNombre(almac);
		bodega4.setTiboDescripcion("Tránsito");
		bodega4.setTiboEstado("ACT");
		bodega4.setTiboUcreacion( peri);
		bodega4.setTiboFcreacion(fechaHora2);
		bodega4.setTiboUactualizacion(null);
		bodega4.setTiboFactualizacion("2020-08-28T22:17:14.741+00:00");
			
		tipoBod.add(bodega1);
		tipoBod.add(bodega2);
		tipoBod.add(bodega3);
		tipoBod.add(bodega4);
		return tipoBod;
	}
	
	private List<TipoOpeTitulo> tipOpeTil() {

		List<TipoOpeTitulo> tipoOpeTil = new ArrayList<>();

		TipoOpeTitulo operaTil1 = new TipoOpeTitulo();
		operaTil1.setTiopeTiope(1);
		operaTil1.setTiopeNombre("Incentivo");
		operaTil1.setTiopeEstado("ACT");
		
		TipoOpeTitulo operaTil2 = new TipoOpeTitulo();
		operaTil2.setTiopeTiope(2);
		operaTil2.setTiopeNombre("REPO");
		operaTil2.setTiopeEstado("ACT");
		
		TipoOpeTitulo operaTil3 = new TipoOpeTitulo();
		operaTil3.setTiopeTiope(3);
		operaTil3.setTiopeNombre("Operación de crédito");
		operaTil3.setTiopeEstado("ACT");
		
		TipoOpeTitulo operaTil4 = new TipoOpeTitulo();
		operaTil4.setTiopeTiope(4);
		operaTil4.setTiopeNombre("Doble propósito");
		operaTil4.setTiopeEstado("ACT");
			
		tipoOpeTil.add(operaTil1);
		tipoOpeTil.add(operaTil2);
		tipoOpeTil.add(operaTil3);
		tipoOpeTil.add(operaTil4);
		return tipoOpeTil;
	}
	
	private List<MaterialSapTitulos> material() {

		List<MaterialSapTitulos> materialSap = new ArrayList<>();

		MaterialSapTitulos sap1 = new MaterialSapTitulos();
		sap1.setMatsaMatsa(1);
		sap1.setMatsaCodigo("123");
		sap1.setMatsaDescripcion("Monkey D Luffy");
		sap1.setMatsaEstado("ACT");
		
		MaterialSapTitulos sap2 = new MaterialSapTitulos();
		sap2.setMatsaMatsa(2);
		sap2.setMatsaCodigo("2123");
		sap2.setMatsaDescripcion("Roronoa Zoro");
		sap2.setMatsaEstado("ACT");
		
		MaterialSapTitulos sap3 = new MaterialSapTitulos();
		sap3.setMatsaMatsa(3);
		sap3.setMatsaCodigo("3151");
		sap3.setMatsaDescripcion("Jinbei");
		sap3.setMatsaEstado("ACT");
		
		MaterialSapTitulos sap4 = new MaterialSapTitulos();
		sap4.setMatsaMatsa(4);
		sap4.setMatsaCodigo("412D2");
		sap4.setMatsaDescripcion("Trafalgar Law");
		sap4.setMatsaEstado("ACT");
		
		MaterialSapTitulos sap5 = new MaterialSapTitulos();
		sap5.setMatsaMatsa(5);
		sap5.setMatsaCodigo("3002188");
		sap5.setMatsaDescripcion("ALMACEN BG PART BONOS PRENDA PROD AGRI");
		sap5.setMatsaEstado("ACT");
		
		MaterialSapTitulos sap6 = new MaterialSapTitulos();
		sap6.setMatsaMatsa(6);
		sap6.setMatsaCodigo("3002189");
		sap6.setMatsaDescripcion("ALMACEN BG PARTICULAR BONOS PRENDA");
		sap6.setMatsaEstado("ACT");
		
		MaterialSapTitulos sap7 = new MaterialSapTitulos();
		sap7.setMatsaMatsa(7);
		sap7.setMatsaCodigo("3002190");
		sap7.setMatsaDescripcion("ALMACEN BG PROP BONOS PRENDA PROD AGRI");
		sap7.setMatsaEstado("ACT");
		

		MaterialSapTitulos sap8 = new MaterialSapTitulos();
		sap8.setMatsaMatsa(8);
		sap8.setMatsaCodigo("3002191");
		sap8.setMatsaDescripcion("ALMACEN BG PROPIA BONOS PRENDA");
		sap8.setMatsaEstado("ACT");
		
		materialSap.add(sap1);
		materialSap.add(sap2);
		materialSap.add(sap3);
		materialSap.add(sap4);
		materialSap.add(sap5);
		materialSap.add(sap6);
		materialSap.add(sap7);
		materialSap.add(sap8);
		return materialSap;
	}
	
	private RespuestaDto respuesta(String codigo, String sms, Object resul) {
		RespuestaDto resp = new RespuestaDto();
		resp.setCodigoEstado(codigo);
		resp.setMensajeEstado(sms);
		resp.setResultado(resul);
		return resp;
	}
}
