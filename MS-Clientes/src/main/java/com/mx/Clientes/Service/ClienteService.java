package com.mx.Clientes.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Clientes.Dao.IClientesDao;
import com.mx.Clientes.Entity.Clientes;

@Service
public class ClienteService implements IClientesService {

	@Autowired
	private IClientesDao dao;

	@Override
	public Clientes guardar(Clientes cliente) {
		// TODO Auto-generated method stub
		return dao.save(cliente);
	}

	@Override
	public Clientes editar(Clientes cliente) {
		Clientes aux = this.buscar(cliente.getIdCliente());
		if(aux!=null) {
			return dao.save(cliente);
		}
		return null;
	}

	@Override
	public Clientes eliminar(Long idCliente) {
		Clientes aux = this.buscar(idCliente);
		if(aux!=null) {
			dao.deleteById(idCliente);
			
		}
		return aux;
	}

	@Override
	public Clientes buscar(Long idCliente) {
		// TODO Auto-generated method stub
		return dao.findById(idCliente).orElse(null);
	}

	@Override
	public List<Clientes> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Direction.DESC,"idCliente"));
	}
	
	//METODO PERSONALIZADO BUSCAR POR TIENDA
	public List<Clientes> buscartiendaId(int tiendaId){
		return dao.findByTiendaId(tiendaId);
	}

}
