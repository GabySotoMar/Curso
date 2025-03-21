package com.mx.Jobs.Service;

import java.util.List;

import com.mx.Jobs.Entity.Jobs;

public interface IJobsService {

	public Jobs guardar(Jobs job);

	public Jobs editar(Jobs job);

	public Jobs eliminar(Long idJob);

	public Jobs buscar(Long idJobTitle);

	public List<Jobs> listar();

}
