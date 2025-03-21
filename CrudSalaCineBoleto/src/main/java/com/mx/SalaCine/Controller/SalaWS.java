package com.mx.SalaCine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.SalaCine.Entity.Sala;
import com.mx.SalaCine.Service.SalaServiceImpl;

@RestController //indicamos que la clase es un controlador y recibe solicitudes HTTP y devuelve una respuesta 
@RequestMapping("/Sala")
@CrossOrigin //evita que tengamos acceso denegado al solicitar informacion al servidor

public class SalaWS {
	@Autowired
	
	private SalaServiceImpl service;
	
	//CREACION DE ENDPOINTS
	
	//LISTAR
	//http://localhost:8002/Sala/listar
	@GetMapping("listar")
	public List<Sala> listar(){
		return service.listar();
	}
	
	//BUSCAR 
		//http://localhost:8002/Sala/buscar
	@PostMapping("buscar")
	public Sala buscar(@RequestBody Sala sala) {
		return service.buscar(sala);
	}
	
	//GUARDAR
	//http://localhost:8002/Sala/guardar
	@PostMapping("guardar")
	public Sala guardar(@RequestBody Sala sala) {
		return service.guardar(sala);
		
	}
	
	//editar
	//http://localhost:8002/Sala/editar

	@PutMapping("editar")
	public Sala editar(@RequestBody Sala sala) {
		return service.editar(sala);
	}
	
	// eliminar
	// http://localhost:8002/Sala/eliminar
	@DeleteMapping("eliminar")
	public Sala eliminar(@RequestBody Sala sala) {
		return service.eliminar(sala);
	}
	
	//METODOS PERSONALIZADOS
	
	//BUSCAR POR CATEGORIA 1
	//http://localhost:8002/Sala/buscarPorCategoria?categoria=B15
	@PostMapping("buscarPorCategoria")
	public List<Sala> buscarPorCategoria(@Param("categoria") String categoria){
		return service.buscarPorCategoria(categoria);
	
	}
	
	// BUSCAR POR CATEGORIA 2
	// http://localhost:8002/Sala/buscarPorCategoria2?categoria=B15
	@PostMapping("buscarPorCategoria2")
	public List<Sala> buscarPorCategoria2(@Param("categoria") String categoria) {
		return service.buscarPorCategoria2(categoria);

	}
	
}
