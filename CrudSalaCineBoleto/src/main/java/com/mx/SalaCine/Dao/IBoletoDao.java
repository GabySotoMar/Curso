package com.mx.SalaCine.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.SalaCine.Entity.Boleto;

@Repository
public interface IBoletoDao extends JpaRepository<Boleto, Long>{
	
	//consultar los boletos por el nombre de la pelicula
	@Query(nativeQuery = true,
			value = "SELECT ID_BOLETO, PELICULA, CLASIFICACION, NO_ASIENTO, FECHA, SALA_ID "
					+ "FROM BOLETO "
					+ "WHERE UPPER(PELICULA) LIKE '%' || UPPER(?)|| '%'")
	public List<Boleto> findByPelicula(@Param("pelicula") String pelicula);

	@Query(nativeQuery = true,
			value = "SELECT ID_BOLETO, PELICULA, CLASIFICACION, NO_ASIENTO, FECHA, SALA_ID "
					+ "FROM BOLETO "
					+ "WHERE UPPER(CLASIFICACION) = UPPER(:clasificacion)")
	public List<Boleto> findByClasificacin(@Param("clasificacion") String clasificacion);
	
}
