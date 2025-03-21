package com.mx.DepartamentoEmpleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.DepartamentoEmpleado.Dao.IEmpleadosDao;
import com.mx.DepartamentoEmpleado.Entity.Empleados;

@Service
@Transactional
public class EmpleadosServiceImpl implements IEmpleadosService {
	@Autowired
	
	private IEmpleadosDao dao;
	
	
	@Override
	public Empleados guardar(Empleados empleados) {
		return dao.save(empleados);
	}

	@Override
	public Empleados editar(Empleados empleados) {
		Empleados aux =this.buscar(empleados);
		if(aux != null) {
			return dao.save(empleados);
		}
		return null;
	}

	@Override
	public Empleados eliminar(Empleados empleados) {
		Empleados aux =this.buscar(empleados);
		if(aux != null) {
			dao.delete(empleados);
			return aux;
		}
		return null;
	}

	
	@Override
	public List<Empleados> listar() {
		
		return dao.findAll(Sort.by(Direction.ASC, "depCod"));
	}

	@Override
	public Empleados buscar(Empleados empleados) {
		// TODO Auto-generated method stub
		//return null;
		return dao.findById(empleados.getCodEmpleado()).orElse(null);
	}
	
	// M E T O D O S   P E R S O N A L I Z A D O S 
	public List<Empleados> buscarEmpleado(String empleado){
		return dao.findByNombre(empleado);
	}
	
	//buscar empleado
	
	public List<Empleados> buscarEmpleado2(String empleado){
		return dao.findByNombreContainingIgnoringCase(empleado);
	}

}
