package com.mx.DepartamentoEmpleado.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.DepartamentoEmpleado.Entity.Departamento;

@Repository
public interface IDepartamentoDao extends JpaRepository<Departamento, Long> {
	//M E T O D O S  P ER S O N A L IZ A D O S 

	//METODO PARA BUSCAR POR DEPARTAMENTO
	//con Query
	@Query(nativeQuery = true,
			value = "SELECT COD_DEP, DEPARTAMENTO, NO_TURNOS "
					+ "FROM DEPARTAMENTO "
					+ "WHERE UPPER(DEPARTAMENTO) = UPPER(:departamento) "
					+ "ORDER BY COD_DEP ASC")
	public List<Departamento> findByDepartamento(String departamento);
	
	//METODO PARA BUSCAR POR DEPARTAMENTO 2 
	//con palabras clave
	public List<Departamento>findByDepartamentoIgnoringCaseOrderByCodDep(String departamento);
}
