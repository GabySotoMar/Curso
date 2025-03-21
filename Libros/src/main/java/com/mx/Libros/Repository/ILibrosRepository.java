package com.mx.Libros.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Libros.Dominio.Libros;

@Repository

public interface ILibrosRepository extends CrudRepository<Libros, Integer>{
	

}
