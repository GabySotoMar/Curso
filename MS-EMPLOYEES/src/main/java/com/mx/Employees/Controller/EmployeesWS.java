package com.mx.Employees.Controller;

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

import com.mx.Employees.Entity.Employees;
import com.mx.Employees.Service.EmployeesService;

@RestController
@RequestMapping("/Employees")
public class EmployeesWS {
	@Autowired
	private EmployeesService service;
	// end point
	// http://Localhost:8020/Employees
	
	//----------- LISTAR---------------------
	@GetMapping
	public ResponseEntity<?> listEmployees(){
		List<Employees> employees = service.listar();
		if(employees.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(employees);
		}
	} // END LISTAR
	
	//BUSCAR POR ID EMPLOYEE
	@PostMapping("/{idEmployee}")
	public ResponseEntity<?> getEmployee(@PathVariable Long idEmployee){
		Employees employee = service.buscar(idEmployee);
		if(employee != null) {
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.notFound().build();
		}
	} // END BUSCAR
	
	
	// GUARDAR
	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Employees employee){
		return ResponseEntity.ok(service.guardar(employee));
	} // END GUARDAR
	
	//EDITAR
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employees employee){
		Employees employeeBD = service.buscar(employee.getIdEmployee());
		if(employeeBD != null) {
			return ResponseEntity.ok(service.editar(employee));
		}else {
			return ResponseEntity.notFound().build();
		}
	}// END EDITAR
	
	//ELIMINAR
	@DeleteMapping("/{idEmployee}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long idEmployee){
		Employees employee = service.buscar(idEmployee);
		if (employee != null) {
			service.eliminar(idEmployee);
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.ok(employee);
		}
	}//end eliminar
}
