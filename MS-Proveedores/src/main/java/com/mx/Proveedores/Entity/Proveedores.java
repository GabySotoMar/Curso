package com.mx.Proveedores.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "PROVEEDORES")
//@Data
@Data
public class Proveedores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ID_PROV")//SEQ_ID_PRODUCTO
	@SequenceGenerator(name = "S_ID_PROV", sequenceName = "S_ID_PROV", allocationSize = 1)
	
	private Long idProv;
	private String nombre;
	private Long contacto;
	private String empresa;
	private int tiendaId;
}
