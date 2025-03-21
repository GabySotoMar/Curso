package com.mx.Proveedores.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Proveedores.Dao.IProveedorDao;
import com.mx.Proveedores.Entity.Proveedores;

@Service
public class ProveedoresServiceImpl implements IProveedoresService{

	@Autowired
	private IProveedorDao dao;
	
	@Override
	public Proveedores guardar(Proveedores proveedor) {
		// TODO Auto-generated method stub
		return dao.save(proveedor);
	}

	@Override
	public Proveedores editar(Proveedores proveedor) {
		Proveedores aux= this.buscar(proveedor.getIdProv());
		if(aux != null) {
			return dao.save(proveedor);
		}
		return null;
	}

	@Override
	public Proveedores eliminar(Long idProv) {
		Proveedores aux = this.buscar(idProv);
		if(aux!=null) {
			dao.deleteById(idProv);
		}
		// TODO Auto-generated method stub
		return aux;
	}

	@Override
	public Proveedores buscar(Long idProv) {
		// TODO Auto-generated method stub
		return dao.findById(idProv).orElse(null);
	}

	@Override
	public List<Proveedores> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Direction.DESC,"idProv"));
	}
	
	public List<Proveedores> buscarTienda(int tiendaId) {
		return dao.findBytiendaId(tiendaId);
	}

}
