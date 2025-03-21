package com.mx.Employees.Service;

import java.util.List;

import com.mx.Employees.Entity.Employees;

public interface IEmployeesService {
	
	public Employees guardar(Employees employee);

	public Employees editar(Employees employee);

	public Employees eliminar(Long idEmployee);

	public Employees buscar(Long idEmployee);
	
	public List<Employees> listar();

}
