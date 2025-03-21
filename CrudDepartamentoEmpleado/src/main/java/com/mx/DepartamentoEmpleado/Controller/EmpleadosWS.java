package com.mx.DepartamentoEmpleado.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.DepartamentoEmpleado.Entity.Empleados;
import com.mx.DepartamentoEmpleado.Service.EmpleadosServiceImpl;

@RestController 
@RequestMapping("/Empleados")
@CrossOrigin
public class EmpleadosWS {
	@Autowired
	private EmpleadosServiceImpl service;
	
	// CREACION DE ENDPOINTS
	
	// LISTAR
	// http://localhost:8002/Empleados/listar
	@GetMapping("listar")
	public List<Empleados> listar() {

		return service.listar();
	}
	
	// BUSCAR
	// http://localhost:8002/Empleados/buscar
	@PostMapping("buscar")
	public Empleados buscar(@RequestBody Empleados empleados) {
		return service.buscar(empleados);
	}
	
	// GUARDAR
	// http://localhost:8002/Empleados/guardar
	@PostMapping("guardar")
	public Empleados guardar(@RequestBody Empleados empleados) {
		return service.guardar(empleados);
	}
	
	// EDITAR
	// http://localhost:8002/Empleados/editar
	@PutMapping("editar")
	public Empleados editar(@RequestBody Empleados empleados) {
		return service.editar(empleados);
	}
	
	// ELIMINAR
	// http://localhost:8002/Empleados/eliminar
	@DeleteMapping("eliminar")
	public Empleados eliminar(@RequestBody Empleados empleados) {
		return service.eliminar(empleados);
	}
	
	// M E T O D O S P E R S O N A L I Z A D O S

	// BUSCAR POR NOMBRE DE EMPLEADO
	// http://localhost:8002/Empleados/buscarPorNomEmpleado
	@PostMapping("buscarPorNomEmpleado")
	public List<Empleados> buscarEmpleado(@Param("nombre") String nombre) {
		return service.buscarEmpleado(nombre);
	}
	
	// BUSCAR POR NOMBRE DE EMPLEADO
		// http://localhost:8002/Empleados/buscarPorNomEmpleado2/
		@PostMapping("buscarPorNomEmpleado2/{nombre}")
		public List<Empleados> buscarEmpleado2(@PathVariable String nombre) {
			return service.buscarEmpleado2(nombre);
		}
	

}
