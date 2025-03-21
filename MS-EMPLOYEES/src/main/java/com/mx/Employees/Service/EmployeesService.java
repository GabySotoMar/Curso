package com.mx.Employees.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Employees.Dao.IEmployeesDao;
import com.mx.Employees.Entity.Employees;

@Service
public class EmployeesService implements IEmployeesService{
	@Autowired
	private IEmployeesDao dao;
	
	@Override
	public Employees guardar(Employees employee) {
		return dao.save(employee);
	}

	@Override
	public Employees editar(Employees employee) {
		Employees aux = this.buscar(employee.getIdEmployee());
		if(aux != null) {
			return dao.save(employee);
		}
		return null;
	}

	@Override
	public Employees eliminar(Long idEmployee) {
		Employees aux= this.buscar(idEmployee);
		if(aux!=null) {
			dao.deleteById(idEmployee);
		}
		return aux;
	}

	@Override
	public Employees buscar(Long idEmployee) {
		
		return dao.findById(idEmployee).orElse(null);
	}

	@Override
	public List<Employees> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Direction.DESC, "idEmployee"));
	}


}
