package com.mx.Departaments.Service;

import java.util.List;

import com.mx.Departaments.Entity.Departaments;

public interface IDepartamentsService {

	public Departaments guardar(Departaments departament);

	public Departaments editar(Departaments departament);

	public Departaments eliminar(Long idDepartament);

	public Departaments buscar(Long idDepartament);

	public List<Departaments> listar();

}
