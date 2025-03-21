package com.mx.Tienda.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Proveedores;
import com.mx.Tienda.Service.TiendaServiceImpl;

@RestController
@RequestMapping("/Tienda")
@CrossOrigin("*")
public class TiendaWS {
	@Autowired
	private TiendaServiceImpl service;

	// http://Localhost:8014/Tienda
	// L I S T A R
	@GetMapping
	public List<Tienda> listar() {
		return service.listar();
	}

	// B U S C A R
	@PostMapping("/{idTienda}")
	public Tienda buscar(@PathVariable int idTienda) {
		return service.buscar(idTienda);
	}

	// G U A R D A R
	@PostMapping
	public void guardar(@RequestBody Tienda tienda) {
		service.guardar(tienda);
	}

	// E D I T A R
	@PutMapping
	public void editar(@RequestBody Tienda tienda) {
		service.editar(tienda);
	}

	// E L I M I N A R
	@DeleteMapping("/{idTienda}")
	public void eliminar(@PathVariable int idTienda) {
		service.eliminar(idTienda);
	}
//----------------------------CLIENTES

	// END POINT GUARDAR CLIENTE
	// http://localhost:8014/Tienda/Clientes
	@PostMapping("/Clientes")
	public ResponseEntity<?> guardarCliente(@RequestBody Clientes cliente) {
		Clientes nuevoCliente = service.saveClientes(cliente);
		if (nuevoCliente == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
	}
	// http://localhost:8014/Tienda/Clientes/
	@GetMapping("Clientes/{tiendaId}")
	public ResponseEntity<?> obtenerClientes(@PathVariable int tiendaId) {
		List<Clientes> clientes = service.getClientes(tiendaId);
		if (clientes.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(clientes);

	}

	// ----------------------------PRODUCTOS
	// http://localhost:8014/Tienda/Productos
	@PostMapping("/Productos")
	public ResponseEntity<?> guardarProductos(@RequestBody Productos producto) {
		Productos nuevoProducto = service.saveProductos(producto);
		if (nuevoProducto == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
	}
	// http://localhost:8014/Tienda/Productos/
	@GetMapping("Productos/{tiendaId}")
	public ResponseEntity<?> obtenerProductos(@PathVariable int tiendaId) {
		List<Productos> producto = service.getProductos(tiendaId);
		if (producto.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(producto);
	}

	// ----------------------------PROVEEDORES
	// http://localhost:8014/Tienda/Proveedores
	@PostMapping("/Proveedores")
	public ResponseEntity<?> guardarProveedores(@RequestBody Proveedores proveedor) {
		Proveedores nuevoProveedor = service.saveProveedores(proveedor);
		if (nuevoProveedor == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
	}

	@GetMapping("Proveedores/{tiendaId}")
	public ResponseEntity<?> obtenerProveedores(@PathVariable int tiendaId) {
		List<Proveedores> proveedor = service.getProveedores(tiendaId);
		if (proveedor.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(proveedor);

	}
	
	// ------------------------------------------------------------------------------------
	// relacion de la tienda y sus modulos
	//http://localhost:8014/Tienda/todo/
	// ------------------------------------------------------------------------------------
	@GetMapping("/todo/{tiendaId}")
	public ResponseEntity<?> obtenerTodoslosModulos(@PathVariable int tiendaId){
		Map<String, Object> modulos= service.obtenerTodosLosModulos(tiendaId);
		return ResponseEntity.status(HttpStatus.OK).body(modulos);
	}
}
