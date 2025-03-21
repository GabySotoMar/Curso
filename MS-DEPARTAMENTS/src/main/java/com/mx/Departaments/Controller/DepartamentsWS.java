package com.mx.Departaments.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mx.Departaments.Entity.Departaments;
import com.mx.Departaments.Service.DepartamentServiceImpl;

@RestController
@RequestMapping("/Departaments")
@CrossOrigin
public class DepartamentsWS {
	@Autowired
	private DepartamentServiceImpl service;

	// http://localhost:8021/Departaments

	// LISTAR
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Departaments> departaments = service.listar();

		if (departaments.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(departaments);
		}
	}// END LISTAR

	// BUSCAR POR ID DEPARTAMENT
	@PostMapping("/{idDepartament}")
	public ResponseEntity<?> buscardepartament(@PathVariable Long idDepartament) {
		Departaments departament = service.buscar(idDepartament);
		if (departament != null) {
			return ResponseEntity.ok(departament);
		} else {
			return ResponseEntity.notFound().build();

		}
	}// END BUSCAR

	// GUARDAR
	@PostMapping
	public ResponseEntity<?> guardarDepartament(@RequestBody Departaments departament) {
		return ResponseEntity.ok(service.guardar(departament));
	} // END GUARDAR

	// EDITAR
	@PutMapping
	public ResponseEntity<?> editarDepartament(@RequestBody Departaments departament) {
		Departaments departamentBD = service.buscar(departament.getIdDepartament());
		if (departamentBD != null) {
			return ResponseEntity.ok(service.editar(departament));
		} else {
			return ResponseEntity.notFound().build();
		}
	}// END EDITAR

	// ELIMINAR
	@DeleteMapping("/{idDepartament}")
	public ResponseEntity<?> eliminardepartament(@PathVariable Long idDepartament) {
		Departaments departament = service.buscar(idDepartament);
		if (departament != null) {
			service.eliminar(idDepartament);
			return ResponseEntity.ok(departament);
		} else {
			return ResponseEntity.ok(departament);
		}
	}// end eliminar
}
