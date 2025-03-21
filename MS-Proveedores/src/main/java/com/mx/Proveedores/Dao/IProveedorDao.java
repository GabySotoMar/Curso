package com.mx.Proveedores.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Proveedores.Entity.Proveedores;

public interface IProveedorDao extends JpaRepository<Proveedores, Long> {
	public List<Proveedores> findBytiendaId(int tiendaId);
	
	

}
