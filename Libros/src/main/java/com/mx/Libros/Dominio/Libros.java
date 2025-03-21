package com.mx.Libros.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="LIBROS")

public class Libros {
	@Id
	@Column(name = "ID_LIBRO", columnDefinition = "NUMBER")
	private int idLibro;
	@Column(name = "TITULO", columnDefinition = "NVARCHAR2(20)")
	private String titulo;
	@Column(name = "AUTOR", columnDefinition = "NVARCHAR2(15)")
	private String autor;
	@Column(name = "EDITORIAL", columnDefinition = "NVARCHAR2(10)")
	private String editorial;
	@Column(name = "PRECIO", columnDefinition = "NUMBER(6,2)")
	private double precio;
	
	public Libros() {
		super();
	}

	public Libros(int idLibro, String titulo, String autor, String editorial, double precio) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libros [idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", precio=" + precio + "]";
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	

}
