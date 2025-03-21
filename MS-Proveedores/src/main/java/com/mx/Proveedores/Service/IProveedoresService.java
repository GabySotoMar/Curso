package com.mx.Proveedores.Service;

import java.util.List;

import com.mx.Proveedores.Entity.Proveedores;

public interface IProveedoresService {
	
	public Proveedores guardar(Proveedores proveedor);

	public Proveedores editar(Proveedores proveedor);

	public Proveedores eliminar(Long idProv);

	public Proveedores buscar(Long idProv);

	public List<Proveedores> listar();

}
