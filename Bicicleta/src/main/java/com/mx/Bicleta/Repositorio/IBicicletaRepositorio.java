package com.mx.Bicleta.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Bicleta.Dominio.Bicicleta;

@Repository
public interface IBicicletaRepositorio extends CrudRepository<Bicicleta, Integer> {

}
