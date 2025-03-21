package com.mx.Libros.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Libros.Dominio.Libros;
import com.mx.Libros.Repository.ILibrosRepository;

@Service
public class LibrosServiceImpl implements ILibrosService {
	
	@Autowired
	private ILibrosRepository repository;
	

	@Override
	public void guardar(Libros libro) {
		repository.save(libro);
		
	}

	@Override
	public void editar(Libros libro) {
		repository.save(libro);
		
	}

	@Override
	public void eliminar(int idLibro) {
		repository.deleteById(idLibro);
	}

	@Override
	public Libros buscar(int idLibro) {
		return repository.findById(idLibro).orElse(null);
	}

	@Override
	public List<Libros> listar() {
		
		return (List<Libros>) repository.findAll();
	}
	
	

}
