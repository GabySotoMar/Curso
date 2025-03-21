package com.mx.Proveedores.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Proveedores.Entity.Proveedores;
import com.mx.Proveedores.Service.ProveedoresServiceImpl;

@RestController
@RequestMapping("/Proveedores")
public class ProveedoresWS {
	@Autowired
	private ProveedoresServiceImpl service;

	// end point
	// http://Localhost:8011/Proveedores
	// LISTAR
	@GetMapping
	public ResponseEntity<?> listarProveedores() {
		List<Proveedores> proveedores = service.listar();
		if (proveedores.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(proveedores);
		}
	}

	// ENDPOINT BUSCAR
	@PostMapping("/{idProv}")
	public ResponseEntity<?> obtenerProveedor(@PathVariable Long idProv) {
		Proveedores proveedor = service.buscar(idProv);
		if (proveedor != null) {
			return ResponseEntity.ok(proveedor);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// ENDPOINT GUARDAR
	@PostMapping
	public ResponseEntity<?> guardarProveedor(@RequestBody Proveedores proveedor) {
		return ResponseEntity.ok(service.guardar(proveedor));

	}

	// ENDPOINT EDITAR
	@PutMapping
	public ResponseEntity<?> actualizarProveedor(@RequestBody Proveedores proveedor) {
		Proveedores proveedorBD = service.buscar(proveedor.getIdProv());
		if (proveedorBD != null) {
			return ResponseEntity.ok(service.editar(proveedor));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// ENDPOINT eliminar
	@DeleteMapping("/{idProv}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long idProv) {
		Proveedores proveedor = service.buscar(idProv);
		if (proveedor != null) {
			service.eliminar(idProv);
			return ResponseEntity.ok(proveedor);
		} else {
			return ResponseEntity.ok(proveedor);
		}

	}
	//http://Localhost:8011/Proveedores/buscarTienda/
	@PostMapping("/buscarTienda/{tiendaId}")
	public List<Proveedores> buscarTienda(@PathVariable int tiendaId){
		return service.buscarTienda(tiendaId);
	}

}// end
