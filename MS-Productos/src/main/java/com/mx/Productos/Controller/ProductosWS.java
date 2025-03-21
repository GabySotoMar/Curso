package com.mx.Productos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Productos.Entity.Productos;
import com.mx.Productos.Service.ProductosServiceImpl;

@RestController
@RequestMapping("/Productos")
public class ProductosWS {
	@Autowired
	private ProductosServiceImpl service;

	// end point
	// http://Localhost:8010/Productos
	// LISTAR
	@GetMapping
	public ResponseEntity<?> listarProductos() {
		List<Productos> productos = service.listar();

		if (productos.isEmpty()) {
			return ResponseEntity.noContent().build();
			// genera una respuesta---de no content--construye una respuesta
		} else {
			return ResponseEntity.ok(productos);
		}
	}

	// ENDPOINT BUSCAR
	@PostMapping("/{idProducto}")
	public ResponseEntity<?> obtenerProducto(@PathVariable Long idProducto) {
		Productos producto = service.buscar(idProducto);
		if (producto != null) {
			return ResponseEntity.ok(producto);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// ENDPOINT GUARDAR
	@PostMapping
	public ResponseEntity<?> guardarProducto(@RequestBody Productos producto) {
		return ResponseEntity.ok(service.guardar(producto));

	}

	// ENDPOINT EDITAR
	@PutMapping
	public ResponseEntity<?> actualizarProducto(@RequestBody Productos producto) {
		Productos productoBD = service.buscar(producto.getIdProducto());
		if (productoBD != null) {
			return ResponseEntity.ok(service.editar(producto));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// ENDPOINT eliminar
	@DeleteMapping("/{idProducto}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long idProducto) {
		Productos producto = service.buscar(idProducto);
		if (producto != null) {
			service.eliminar(idProducto);
			return ResponseEntity.ok(producto);
		} else {
			return ResponseEntity.ok(producto);
		}

	}
	
	@GetMapping("/buscarTienda/{tiendaId}")
	public ResponseEntity<?> getProductosByTiendaId(@PathVariable int tiendaId ) {
		List<Productos> productos = service.buscarTienda(tiendaId);
		if (productos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
		return ResponseEntity.status(HttpStatus.OK).body(productos);
	}
}
