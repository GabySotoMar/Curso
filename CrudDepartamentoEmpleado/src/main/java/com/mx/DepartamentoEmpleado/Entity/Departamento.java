package com.mx.DepartamentoEmpleado.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTO")

public class Departamento {
	
	/*
	 * CREATE TABLE DEPARTAMENTOS( 
	 * COD_DEP NUMBER, 
	 * DEPARTAMENTO NVARCHAR2(50),
	 * NO_TURNOS NUMBER, 
	 * CONSTRAINT COD_DEP_PK PRIMARY KEY (COD_DEP)
	 */
	
	//DECLARACION DE LOS ATRIBUTOS
	@Id
	@Column (name = "COD_DEP", columnDefinition = "NUMBER")
	private Long codDep;
	@Column (name = "DEPARTAMENTO", columnDefinition = "NVARCHAR2(50)")
	private String departamento;
	@Column (name = "NO_TURNOS", columnDefinition = "NVARCHAR2(50)")
	private int noTurnos;
	
	//REFERNECIA QUE CREA LA UNION CON LA OTRA TABLA
	@OneToMany(mappedBy = "depCod", cascade = CascadeType.ALL)
	List<Empleados> lista = new ArrayList<>();
	
	
	public Departamento() {
	}
	public Departamento(Long codDep, String departamento, int noTurnos) {
		this.codDep = codDep;
		this.departamento = departamento;
		this.noTurnos = noTurnos;
	}
	@Override
	public String toString() {
		return "Departamento [codDep=" + codDep + ", departamento=" + departamento + ", noTurnos=" + noTurnos + "]";
	}
	public Long getCodDep() {
		return codDep;
	}
	public void setCodDep(Long codDep) {
		this.codDep = codDep;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public int getNoTurnos() {
		return noTurnos;
	}
	public void setNoTurnos(int noTurnos) {
		this.noTurnos = noTurnos;
	}
	
	
	

}//cierre clase
