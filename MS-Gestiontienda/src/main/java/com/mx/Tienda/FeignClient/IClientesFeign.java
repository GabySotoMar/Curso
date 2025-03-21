package com.mx.Tienda.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Clientes;

@FeignClient(
		name= "MS-CLIENTES",
		url = "http://localhost:8013",
		path = "/Clientes"
		)
public interface IClientesFeign {
	//DECLARACION DE LOS CONTROLADORES DEL MICROSERVICIO MS-CLIENTES
	@PostMapping
	public Clientes save(@RequestBody Clientes cliente);
	//es como un metodo abstracto que solo vamos a llamar aqui
	
	@PostMapping("/tienda/{tiendaId}")
	public List<Clientes> getClientesByTiendaId(@PathVariable int tiendaId);
}
