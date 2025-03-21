package com.mx.Jobs.Controller;

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

import com.mx.Jobs.Entity.Jobs;
import com.mx.Jobs.Service.JobsServiceImpl;

@RestController
@RequestMapping("/Jobs")
@CrossOrigin
public class JobsWS {
	@Autowired
	private JobsServiceImpl service;

	// http://localhost:8022/Jobs
	// LISTAR
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Jobs> jobs = service.listar();

		if (jobs.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(jobs);
		}
	}// END LISTAR

	// BUSCAR POR ID
	@PostMapping("/{idJobTitle}")
	public ResponseEntity<?> buscarJob(@PathVariable Long idJobTitle) {
		Jobs job = service.buscar(idJobTitle);
		if (job != null) {
			return ResponseEntity.ok(job);
		} else {
			return ResponseEntity.notFound().build();

		}
	}// END BUSCAR

	// GUARDAR
	@PostMapping
	public ResponseEntity<?> guardarJob(@RequestBody Jobs job) {
		return ResponseEntity.ok(service.guardar(job));
	} // END GUARDAR

	// EDITAR
	@PutMapping
	public ResponseEntity<?> editarJob(@RequestBody Jobs job) {
		Jobs jobBD = service.buscar(job.getIdJobTitle());
		if (jobBD != null) {
			return ResponseEntity.ok(service.editar(job));
		} else {
			return ResponseEntity.notFound().build();
		}
	}// END EDITAR

	// ELIMINAR
	@DeleteMapping("/{idJobTitle}")
	public ResponseEntity<?> eliminarJob(@PathVariable Long idJobTitle) {
		Jobs job = service.buscar(idJobTitle);
		if (job != null) {
			service.eliminar(idJobTitle);
			return ResponseEntity.ok(job);
		} else {
			return ResponseEntity.ok(job);
		}
	}// end eliminar

}
