package com.mx.Denominacion.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DENOMINACIONES")
public class Denominacion {
	
	@Id
    private Long id;
    private String tipo;
    private Double denominacion;
    private Integer cantidad;
    
	public Denominacion() {
	}
	public Denominacion(Long id, String tipo, Double denominacion, Integer cantidad) {
		this.id = id;
		this.tipo = tipo;
		this.denominacion = denominacion;
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Denominacion [id=" + id + ", tipo=" + tipo + ", denominacion=" + denominacion + ", cantidad=" + cantidad
				+ "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(Double denominacion) {
		this.denominacion = denominacion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

    
}
