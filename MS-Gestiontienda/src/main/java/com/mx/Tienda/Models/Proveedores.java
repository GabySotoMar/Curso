package com.mx.Tienda.Models;

import lombok.Data;



@Data
public class Proveedores {
		
	private Long idProv;
	private String nombre;
	private Long contacto;
	private String empresa;
	private int tiendaId;
}
