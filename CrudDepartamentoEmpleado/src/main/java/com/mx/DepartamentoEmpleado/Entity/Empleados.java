package com.mx.DepartamentoEmpleado.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Empleados {
	/*
	 * CREATE TABLE EMPLEADOS( COD_EMPLEADO NUMBER, 
	 * NOMBRE NVARCHAR2(50), 
	 * APELLIDOS NVARCHAR2(100), 
	 * EDAD NUMBER, 
	 * DEP_COD NUMBER, 
	 * CONSTRAINT COD_EMPLEADO_PK
	 * PRIMARY KEY (COD_EMPLEADO), 
	 * CONSTRAINT DEP_COD FOREIGN KEY (DEP_COD)
	 * REFERENCES DEPARTAMENTOS(COD_DEP) );
	 */
	
	//(name = "", columnDefinition = "") ESTO IRIA SI
	//LA COLUMNA NO COINCIDE
	@Id
	@Column (name = "COD_EMPLEADO", columnDefinition = "NUMBER")
	private Long codEmpleado;
	@Column (name = "NOMBRE", columnDefinition = "NVARCHAR2(50)")
	private String nombre;
	@Column (name = "APELLIDOS", columnDefinition = "NVARCHAR2(100)")
	private String apellidos;
	@Column (name = "EDAD", columnDefinition = "NUMBER")
	private int edad;
	
	//UNION CON LA TABLA PADRE
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name = "DEP_COD", columnDefinition = "NUMBER")
	
	private Departamento depCod;

	public Empleados() {
	}

	public Empleados(Long codEmpleado, String nombre, String apellidos, int edad, Departamento depCod) {
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.depCod = depCod;
	}

	@Override
	public String toString() {
		return "Empleados [codEmpleado=" + codEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad="
				+ edad + ", depCod=" + depCod + "]";
	}

	public Long getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(Long codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Departamento getDepCod() {
		return depCod;
	}

	public void setDepCod(Departamento depCod) {
		this.depCod = depCod;
	}
	
	
	


}//cierre clase
