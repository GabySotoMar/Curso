package com.mx.Denominacion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Denominacion.Entity.Denominacion;

public interface IDenominacionRepository extends JpaRepository<Denominacion, Long> {
    Denominacion findByDenominacion(Double denominacion); 

}
