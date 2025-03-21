package com.mx.SalaCine.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
//@Table  si lo omito da por entendido que la tabla se llama como mi clase Boleto en este caso
public class Boleto {
	/*
	 * CREATE TABLE BOLETO( 
	 * ID_BOLETO NUMBER, 
	 * PELICULA NVARCHAR2(100), 
	 * CLASIFICACION NVARCHAR2(50), 
	 * NO_ASIENTO NVARCHAR2(5), 
	 * FECHA DATE, 
	 * SALA_ID NUMBER,
	 * CONSTRAINT ID_BOLETO_PK PRIMARY KEY (ID_BOLETO), CONSTRAINT SALA_ID_FK
	 * FOREIGN KEY (SALA_ID) REFERENCES SALA_CINE(ID_SALA) );
	 */
	
	@Id
	@Column
	private Long idBoleto;
	@Column
	private String pelicula;
	@Column
	private String clasificacion;
	@Column
	private String noAsiento;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd" )
	private Date fecha;
	
	
	//esta ultima es la union con la otra tabla
	//FetchType muestra los datos de forma conjunta tanto la de boleto como de sala 
	//con eager carga en conjunto la informacion
	//SALA_ID es el que hace referencia con la otra tabla
	@ManyToOne(fetch = FetchType.EAGER) //EAGER = carga inmediata 
	@JoinColumn(name ="SALA_ID")
	private Sala salaId; // va ser de tipo sala para hacer referencia con la clase sala

	public Boleto() {
		
	}

	public Boleto(Long idBoleto, String pelicula, String clasificacion, String noAsiento, Date fecha, Sala salaId) {
		super();
		this.idBoleto = idBoleto;
		this.pelicula = pelicula;
		this.clasificacion = clasificacion;
		this.noAsiento = noAsiento;
		this.fecha = fecha;
		this.salaId = salaId;
	}

	@Override
	public String toString() {
		return "Boleto [idBoleto=" + idBoleto + ", pelicula=" + pelicula + ", clasificacion=" + clasificacion
				+ ", noAsiento=" + noAsiento + ", fecha=" + fecha + ", salaId=" + salaId + "]";
	}

	public Long getIdBoleto() {
		return idBoleto;
	}

	public void setIdBoleto(Long idBoleto) {
		this.idBoleto = idBoleto;
	}

	public String getPelicula() {
		return pelicula;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getNoAsiento() {
		return noAsiento;
	}

	public void setNoAsiento(String noAsiento) {
		this.noAsiento = noAsiento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Sala getSalaId() {
		return salaId;
	}

	public void setSalaId(Sala salaId) {
		this.salaId = salaId;
	}

}
