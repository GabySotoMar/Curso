package com.mx.Tienda.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Productos;



@FeignClient(
		name= "MS-PRODUCTOS",
		url = "http://localhost:8010",
		path = "/Productos"
		)

public interface IProductosFeign {
	
	
	
	@PostMapping
	public Productos saveProducto(@RequestBody Productos producto);

	@GetMapping("/buscarTienda/{tiendaId}")
	public List<Productos> getProductosByTiendaId(@PathVariable int tiendaId);

}
