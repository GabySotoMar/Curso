package com.mx.Bicleta.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Bicleta.Dominio.Bicicleta;
import com.mx.Bicleta.Repositorio.IBicicletaRepositorio;
/*
 * se de porner  @Service  no olvidar si no no levanta el servicio
 */
@Service
public class BicicletaServiceImpl implements IBicicletaService{

	//inyeccion de dependencias
	/*
	 * La anotación @Autowired es una anotación en Spring que se utiliza
	 *  para inyectar automáticamente una dependencia en un componente
	 *   de la aplicación
	 */
	
	@Autowired
	private IBicicletaRepositorio repository;
	
	@Override
	public void guardar(Bicicleta bici) {
		repository.save(bici);
		
	}

	@Override
	public void editar(Bicicleta bici) {
		repository.save(bici);
		
	}

	@Override
	public void eliminar(int idBici) {
		repository.deleteById(idBici);
		
	}

	@Override
	public Bicicleta buscar(int idBici) {
		
		return repository.findById(idBici).orElse(null);
	}

	@Override
	public List<Bicicleta> listar() {
		
		return (List<Bicicleta>) repository.findAll();
	}

}
