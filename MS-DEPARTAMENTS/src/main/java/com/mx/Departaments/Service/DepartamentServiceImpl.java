package com.mx.Departaments.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Departaments.Dao.IDepartamentsDao;
import com.mx.Departaments.Entity.Departaments;
@Service
public class DepartamentServiceImpl implements IDepartamentsService {

	@Autowired
	private IDepartamentsDao dao;
	
	@Override
	public Departaments guardar(Departaments departament) {
		
		return dao.save(departament);
	}

	@Override
	public Departaments editar(Departaments departament) {
		Departaments aux= this.buscar(departament.getIdDepartament());
		if(aux!=null) {
			return dao.save(departament);
		}
		return null;
	}

	@Override
	public Departaments eliminar(Long idDepartament) {
		Departaments aux= this.buscar(idDepartament);
		if(aux!=null) {
			dao.deleteById(idDepartament);
		}
		return aux;
	}

	@Override
	public Departaments buscar(Long idDepartament) {
		// TODO Auto-generated method stub
		return dao.findById(idDepartament).orElse(null);
	}

	@Override
	public List<Departaments> listar() {
		
		return dao.findAll(Sort.by(Direction.DESC,"idDepartament"));
	}

}
