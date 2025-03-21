package com.mx.DepartamentoEmpleado.Controller;

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

import com.mx.DepartamentoEmpleado.Entity.Departamento;
import com.mx.DepartamentoEmpleado.Service.DepartamentoServiceImpl;

@RestController 
@RequestMapping("/Departamento")
@CrossOrigin

public class DepartamentoWS {
	@Autowired
	
	private DepartamentoServiceImpl service;
	
	//creacion endpoint
	
	// LISTAR
	// http://localhost:8002/Departamento/listar
	@GetMapping("listar")
	public List<Departamento> listar() {
		return service.listar();
	}
	
	// BUSCAR
	// http://localhost:8002/Departamento/buscar
	@PostMapping("buscar")
	public Departamento buscar(@RequestBody Departamento departamento) {
		return service.buscar(departamento);
	}
	
	// GUARDAR
	// http://localhost:8002/Departamento/guardar
	@PostMapping("guardar")
	public Departamento guardar(@RequestBody Departamento departamento) {
		return service.guardar(departamento);
	}
	
	// EDITAR
	// http://localhost:8002/Departamento/editar
	@PutMapping("editar")
	public Departamento editar(@RequestBody Departamento departamento) {
		return service.editar(departamento);
	}
	
	
	// ELIMINAR
	// http://localhost:8002/Departamento/eliminar
	@DeleteMapping("eliminar")
	public Departamento eliminar(@RequestBody Departamento departamento) {
		return service.eliminar(departamento);
	}
	
	//METODOS PERSONALIZADOS
	
	
	// BUSCAR POR DEPARTAMENTO 1
	// http://localhost:8002/Departamento/buscarPorDepartamento
	@PostMapping("buscarPorDepartamento")
	public List<Departamento> buscarPorDepartamento1(@Param("departamento") String departamento) {
		return service.buscarPorDepartamento1(departamento);
	}
		
	// BUSCAR POR DEPARTAMENTO 2
	// http://localhost:8002/buscarPorDepartamento2
	@PostMapping("buscarPorDepartamento2")
	public List<Departamento> buscarPorDepartamento2(@Param("departamento2") String departamento) {
		return service.buscarPorDepartamento2(departamento);
	}
	

}//end clase
