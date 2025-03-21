package com.mx.Automovil.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Automovil.Dao.IAutomovilDao;
import com.mx.Automovil.Entity.Automovil;

@Service
@Transactional
public class AutomovilServiceImpl implements IAutomovilService{
	
	@Autowired
	private IAutomovilDao dao;

	@Override
	public Automovil guardar(Automovil auto) {

		return dao.save(auto);
	}//CIERRE GUARDAR

	@Override
	public Automovil editar(Automovil auto) {
		Automovil aux = this.buscar(auto.getIdAuto());
		if (aux != null) {
			return dao.save(auto);
		}

		return null;
	}//CIERRE EDITAR

	@Override
	public Automovil eliminar(Automovil auto) {
		Automovil aux = this.buscar(auto.getIdAuto());
		if (aux != null) {
			dao.delete(auto);
			return aux;
		}

		return null;
	}//CIERRE ELIMINAR
	
	@Override
	public Automovil buscar(Long idAuto) {
		return dao.findById(idAuto).orElse(null);
	}//CIERRE BUSCAR

	@Override
	public List<Automovil> listar() {
		
		return dao.findAll(Sort.by(Direction.ASC, "idAuto"));
	}//CIERRE LISTAR

	//M E T O D O S   P E R S O N A L I Z A D O
	public List<Automovil> buscarPormarca(String marca){
		return dao.findByMarca(marca);
	}
	
	
}//CIERRE CLASE
