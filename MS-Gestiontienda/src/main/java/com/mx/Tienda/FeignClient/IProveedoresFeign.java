package com.mx.Tienda.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Proveedores;

@FeignClient(
		name= "MS-PROVEEDORES",
		url = "http://localhost:8011",
		path = "/Proveedores"
		)
public interface IProveedoresFeign {
	
	//BUSCAR POR ID DE TIENDA
	@PostMapping("/buscarTienda/{tiendaId}")
	public List<Proveedores> getProveedoresBytiendaId(@PathVariable int tiendaId);

	@PostMapping
	public Proveedores saveProveedores(@RequestBody Proveedores proveedor);
	//es como un metodo abstracto que solo vamos a llamar aqui
	
	
}

