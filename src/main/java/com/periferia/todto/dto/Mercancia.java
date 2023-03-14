package com.periferia.todto.dto;

import lombok.Data;

@Data
public class Mercancia {

	private int id;
	
    private int titulo;
    private String detalleMercancia;
    private int unidadMedida;
    private String unidadMedidaNombre;
    private String unidadMedidaSuper;
    private String valorConversion;
    private int cantidad;
    private int cantidadInicial;
    private int valorUnitario;
    private int valorTotal;
    private String fechaVencimiento;
    private String observaciones;
    private String estado;
    private int idLiberacion;
}
