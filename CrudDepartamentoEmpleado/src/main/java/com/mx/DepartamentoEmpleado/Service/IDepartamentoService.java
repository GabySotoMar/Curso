package com.mx.DepartamentoEmpleado.Service;

import java.util.List;

import com.mx.DepartamentoEmpleado.Entity.Departamento;

public interface IDepartamentoService {
	
	public Departamento guardar(Departamento departamento);
	public Departamento editar(Departamento departamento);
	public Departamento eliminar(Departamento departamento);
	public Departamento buscar(Departamento departamento);
	
	public List<Departamento> listar();

}
