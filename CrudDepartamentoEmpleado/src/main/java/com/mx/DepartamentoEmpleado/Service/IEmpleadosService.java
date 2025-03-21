package com.mx.DepartamentoEmpleado.Service;

import java.util.List;

import com.mx.DepartamentoEmpleado.Entity.Empleados;

public interface IEmpleadosService {
	
	
	public Empleados guardar(Empleados empleados);
	public Empleados editar(Empleados empleados);
	public Empleados eliminar(Empleados empleados);
	public Empleados buscar(Empleados empleados);
	
	public List<Empleados> listar();

}
