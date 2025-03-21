package com.mx.Bicleta.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BICICLETA")

public class Bicicleta {

	/*
	 * CREATE TABLE BICICLETA( ID_BICI NUMBER, 
	 * MARCA NVARCHAR2(50), 
	 * MODELO
	 * NVARCHAR2(50), 
	 * TIPO NVARCHAR2(30), 
	 * COLOR NVARCHAR2(30), 
	 * RODAD NUMBER,
	 * MATERIAL NVARCHAR2(30), 
	 * PRECIO NUMBER(10,2), 
	 * 
	 * CONSTRAINT ID_BICI_PK PRIMARY KEY (ID_BICI) );
	 * 
	 * @Entity marcar una clase  como entidad de base de datos
	 * @Table se utiliza para mapear una entidad Java a una tabla en una base de datos relacional
	 * 
	 * @Id es una anotación en JPA (Java Persistence API) que se utiliza para marcar un atributo de una entidad 
	 * Java como la clave primaria de la tabla correspondiente en una base de datos relacional
	 * 
	 * @Column permite especificar el nombre de la columna 
	 * correspondiente al atributo en la tabla de la base de datos relacional, 
	 * así como otras propiedades de la columna
	 * 
	 */
	@Id
	@Column(name = "ID_BICI", columnDefinition = "NUMBER")
	private int idBici;
	@Column(name = "MARCA", columnDefinition = "NVARCHAR2(50)")
	private String marca;
	@Column(name = "MODELO", columnDefinition = "NVARCHAR2(50)")
	private String modelo;
	@Column(name = "TIPO", columnDefinition = "NVARCHAR2(30)")
	private String tipo;
	@Column(name = "COLOR", columnDefinition = "NVARCHAR2(30)")
	private String color;
	@Column(name = "RODAD", columnDefinition = "NUMBER")
	private int rodad;
	@Column(name = "MATERIAL", columnDefinition = "NVARCHAR2(30)")
	private String material;
	@Column(name = "PRECIO", columnDefinition = "NUMBER(10,2)")
	private double precio;

	public Bicicleta() {
		super();
	}

	public Bicicleta(int idBici, String marca, String modelo, String tipo, String color, int rodad, String material,
			double precio) {
		super();
		this.idBici = idBici;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.color = color;
		this.rodad = rodad;
		this.material = material;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Bicicleta [idBici=" + idBici + ", marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", color="
				+ color + ", rodad=" + rodad + ", material=" + material + ", precio=" + precio + "]";
	}

	public int getIdBici() {
		return idBici;
	}

	public void setIdBici(int idBici) {
		this.idBici = idBici;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRodad() {
		return rodad;
	}

	public void setRodad(int rodad) {
		this.rodad = rodad;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
