package com.mx.Departaments.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DEPARTAMENTS")
@Data
public class Departaments {
	@Id
	private Long idDepartament;
	private String departamentName;

	/*
	 * { "idDepartament": 2, "nameDepartament": "VENTAS" }
	 * 
	 */

}
