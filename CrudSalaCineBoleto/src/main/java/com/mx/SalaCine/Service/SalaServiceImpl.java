package com.mx.SalaCine.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.SalaCine.Dao.ISalaDao;
import com.mx.SalaCine.Entity.Sala;

@Service
//@Transactional tambien se puede usar aquí y ya no es necesario en cada uno
//si hay un error va a hacer un rollback automaticamente a la BD
//Asegura la integridad de los datos al manejar transancciones automaticamente

public class SalaServiceImpl implements ISalaService {
	@Autowired
	//inyeccion de dependdencias
	private ISalaDao dao;
	

	@Transactional
	@Override
	public Sala guardar(Sala sala) {
		return dao.save(sala);
	}

	@Transactional
	@Override
	public Sala editar(Sala sala) {
		Sala aux = this.buscar(sala);
		if (aux !=null) {
			dao.save(sala);	
		}
		return null;	
	}

	@Transactional
	@Override
	public Sala eliminar(Sala sala) {
		Sala aux = this.buscar(sala);
		if (aux !=null) {
			dao.delete(sala);
			return aux;
		}
		return null;
	}

	@Override
	public Sala buscar(Sala sala) {
		return dao.findById(sala.getIdSala()).orElse(null);
	}

	@Override
	public List<Sala> listar() {
		return dao.findAll(Sort.by(Direction.ASC, "idSala"));
		//viene ASC de acuerdo al idSala
	}
	
	
	//METODOS PERSONALIZADOS
	public List<Sala> buscarPorCategoria(String categoria){
		return dao.findByCategoria(categoria);
	}
	
	public List<Sala> buscarPorCategoria2(String categoria){
		return dao.findByCategoriaIgnoringCaseOrderByIdSala(categoria);
	}
	

	

}
