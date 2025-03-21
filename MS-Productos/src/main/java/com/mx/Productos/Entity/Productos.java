package com.mx.Productos.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "PRODUCTOS")
@Data

public class Productos {
	/*
	 * CREATE TABLE PRODUCTOS( ID_PRODUCTO NUMBER, NOMBRE NVARCHAR2(100),
	 * DESCRIPCION NVARCHAR2(150), PRECIO NUMBER(12,2), STOCK NUMBER, FECHA_CREACION
	 * DATE, CONSTRAINT ID_PRODUCTO_PK PRIMARY KEY(ID_PRODUCTO) );
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ID_PRODUCTO")//SEQ_ID_PRODUCTO
	@SequenceGenerator(name = "S_ID_PRODUCTO", sequenceName = "S_ID_PRODUCTO", allocationSize = 1) //SEQ_ID_PRODUCTO EN EL NAME
	private Long idProducto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private int stock;
	//@Column(name="FECHA_CREACION", columnDefinition =  "DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") 
	//si es este ya no se debe hacer el getter como esta aqui al final
	private Date fechaCreacion;
	private int tiendaId;
	
	/*{ "idProducto": 1, "nombre": "COCA-COLA", "descripcion": "250ml",
		 * "precio": 15,  "stock": 10, "fechaCreacion": "13/03/2025","tiendaId": 1}

	*/
	
}
