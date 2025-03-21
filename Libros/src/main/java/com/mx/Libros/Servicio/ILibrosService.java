package com.mx.Libros.Servicio;

import java.util.List;

import com.mx.Libros.Dominio.Libros;

public interface ILibrosService {
	public void guardar(Libros libro);
	public void editar(Libros libro);
	public void eliminar(int idLibro);
	public Libros buscar(int idLibro);
	
	public List<Libros> listar();
	

}
