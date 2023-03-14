package com.periferia.todto.dto;

import lombok.Data;

@Data
public class ListOficRespo {

	private String oficNombre; 
    private int oficCodigo; 
    private int oficMunicipio; 
    private int oficDepartamento; 
    private int oficPais; 
    private String oficEstado; 
    private String oficUcreacion; 
    private String oficFcreacion; 
    private int oficOfic; 
    private boolean notificacionOficina;
}
