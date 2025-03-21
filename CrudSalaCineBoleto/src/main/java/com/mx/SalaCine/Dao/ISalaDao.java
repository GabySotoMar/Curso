package com.mx.SalaCine.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.SalaCine.Entity.Sala;
@Repository
public interface ISalaDao extends JpaRepository<Sala, Long> {
	//crear metodos personalizados con palabras clave o con la anotacion @Query
	
	//metodo que busque por categoria, lo del value se hizo en Oracle
	@Query(nativeQuery = true,
			value = "SELECT ID_SALA, NO_ASIENTOS, TIPO_PANTALLA, CATEGORIA "
					+ "FROM SALA_CINE "
					+ "WHERE UPPER (CATEGORIA) = UPPER(:categoria)"
					+ "ORDER BY ID_SALA ASC;")
	public List<Sala> findByCategoria(String categoria);
	
	//metodo personalizado conpalabras clave
	public List<Sala> findByCategoriaIgnoringCaseOrderByIdSala(String categoria);
}
