package com.mx.Tienda.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "GESTION_TIENDA")
@Data
public class Tienda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTienda;
	private String nombre;
	private String direccion;
	private Long contacto;

}
/*
 * { "idTienda": 1, "nombre": "OXXO", "direccion": "privada 10 13-b ",
 * "contacto": 2222334455 }
 */
