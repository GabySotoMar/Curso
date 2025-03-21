package com.mx.DepartamentoEmpleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.DepartamentoEmpleado.Dao.IDepartamentoDao;
import com.mx.DepartamentoEmpleado.Entity.Departamento;

@Service
@Transactional
public class DepartamentoServiceImpl implements IDepartamentoService {
	
	@Autowired
	private IDepartamentoDao dao;

	@Override
	public Departamento guardar(Departamento departamento) {
		return dao.save(departamento);
	}

	@Override
	public Departamento editar(Departamento departamento) {
		Departamento aux = this.buscar(departamento);
		if(aux != null) {
			dao.save(departamento);
		}
		return null;
	}

	@Override
	public Departamento eliminar(Departamento departamento) {
		Departamento aux = this.buscar(departamento);
		if(aux != null) {
			dao.delete(departamento);
			return aux;
		}
		return null;
	}

	@Override
	public Departamento buscar(Departamento departamento) {
		return dao.findById(departamento.getCodDep()).orElse(null);
	}

	@Override
	public List<Departamento> listar() {
		return dao.findAll(Sort.by(Direction.ASC, "codDep"));
	}
	
	
	// M E T O D O S   P E R S O N A L I Z A D O S 
	
	public List<Departamento> buscarPorDepartamento1(String departamento){
		return dao.findByDepartamento(departamento);
	}
	
	public List<Departamento> buscarPorDepartamento2(String departamento){
		return dao.findByDepartamentoIgnoringCaseOrderByCodDep(departamento);
	}

}//end de la clase de implementacion
