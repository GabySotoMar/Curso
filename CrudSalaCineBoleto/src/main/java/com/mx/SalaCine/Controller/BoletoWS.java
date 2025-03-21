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

import com.mx.SalaCine.Entity.Boleto;
import com.mx.SalaCine.Service.BoletoServiceImpl;

@RestController //indicamos que la clase es un controlador y recibe solicitudes HTTP y devuelve una respuesta
@RequestMapping("/Boleto")
@CrossOrigin //evita que tengamos acceso denegado al solicitar informacion al servidor

public class BoletoWS {
	@Autowired
	private BoletoServiceImpl service;
	
	// CREACION DE ENDPOINTS

	// LISTAR
	// http://localhost:8002/Boleto/listar
	@GetMapping("listar")
	public List<Boleto> listar(){
		return service.listar();
	}
	
	// BUUSCAR
	// http://localhost:8002/Boleto/buscar
	@PostMapping("buscar")
	public Boleto buscar(@RequestBody Boleto boleto) {
		return service.buscar(boleto) ;
	}
	
	// guardar
	// http://localhost:8002/Boleto/guardar
	@PostMapping("guardar")
	public Boleto guardar(@RequestBody Boleto boleto) {
		return service.guardar(boleto);
	}

	// editar
	// http://localhost:8002/Boleto/editar
	@PutMapping("editar")
	public Boleto editar(@RequestBody Boleto boleto) {
		return service.editar(boleto);
	}

	// eliminar
	// http://localhost:8002/Boleto/eliminar
	@DeleteMapping("eliminar")
	public Boleto eliminar(@RequestBody Boleto boleto) {
		return service.eliminar(boleto);
	}
	
	//METODOS PERSONALIZDOS
	
	//BUSCAR POR NOMBRE DE PELICULA
	// http://localhost:8002/Boleto/buscarPorPelicula?nomPelicula=Transformers
	@PostMapping("buscarPorPelicula")
	public List<Boleto> buscarPelicula(@Param("nomPelicula") String pelicula){
		return service.buscarPelicula(pelicula);
	}
	
	
	// BUSCAR POR CLASIFICACION
	// http://localhost:8002/Boleto/buscarPorClasificacion?clasificacion=b15

	@PostMapping("buscarPorClasificacion")
	public List<Boleto> buscarClasificacion(@Param("clasificacion") String clasificacion) {
		return service.buscarClasificacin(clasificacion);
	}
		

	
}//final principal
