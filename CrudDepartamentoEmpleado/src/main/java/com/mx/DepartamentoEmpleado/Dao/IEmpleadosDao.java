package com.mx.DepartamentoEmpleado.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.DepartamentoEmpleado.Entity.Empleados;

@Repository
public interface IEmpleadosDao extends JpaRepository<Empleados, Long> {
	
	//M E T O D O S  P ER S O N A L IZ A D O S 

	// METODO PARA BUSCAR POR NOMBRE DEL EMPLEADO CON QUE TENGA UNA PARTE DEL NOMBRE
	@Query(nativeQuery = true,
			value = "SELECT COD_EMPLEADO, NOMBRE, APELLIDOS, EDAD, DEP_COD "
					+ "FROM EMPLEADOS "
					+ "WHERE UPPER(NOMBRE) LIKE '%'|| UPPER(?)|| '%'")
	public List<Empleados> findByNombre(@Param ("nombre") String nombre);

	
	
	public List<Empleados> findByNombreContainingIgnoringCase(String nombre);
}
