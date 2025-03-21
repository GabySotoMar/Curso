package com.mx.Libros.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mx.Libros.Dominio.Libros;
import com.mx.Libros.Servicio.LibrosServiceImpl;
@RestController
@RequestMapping(path = "/api/v1/libros")

public class LibrosWS {
	//NO OLVIDAR ESTO SI NO, NO LEVANTA EL SERVICIO, INYECCION DE DEPENDENCIAS AL SERVICE
	@Autowired
	private LibrosServiceImpl service;

	// Enpoint: "Listar"
	// URL: http://localhost:8001/api/v1/libros/List
	@GetMapping(value = "List")
	public List<Libros> listar() {
		return service.listar();
	}

	// Enpoint: "Buscar"
	// URL: http://localhost:8001/api/v1/libros/buscar/{1}

	@PostMapping(value = "buscar/{idLibro}")
	public Libros buscar(@PathVariable int idLibro) {
		return service.buscar(idLibro);
	}

	// Enpoint: "Guardar"
	// URL: http://localhost:8001/api/v1/libros/guardar
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Libros libro) {
		// @RequestBody sirve para desealizar el doc JSON y convertirlo en un objeto
		// Java
		service.guardar(libro);
	}

	// Enpoint: "Editar"
	// URL: http://localhost:800/api/v1/libros/editar
	@PutMapping(value = "editar")
	public void editar(@RequestBody Libros libro) {
		service.editar(libro);
	}

	// Enpoint: "Eliminar"
	// URL: http://localhost:8080/api/v1/libros/eliminar/{1}
	@DeleteMapping(value = "eliminar/{idLibro}")
	public void eliminar(@PathVariable int idLibro) {
		service.eliminar(idLibro);
	}

}
