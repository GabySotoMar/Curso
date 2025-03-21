package com.mx.Jobs.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Jobs.Dao.IJobsDao;
import com.mx.Jobs.Entity.Jobs;

@Service
public class JobsServiceImpl implements IJobsService {
	@Autowired
	private IJobsDao dao;

	@Override
	public Jobs guardar(Jobs job) {
		return dao.save(job);
	}

	@Override
	public Jobs editar(Jobs job) {
		Jobs aux = this.buscar(job.getIdJobTitle());
		if (aux != null) {
			return dao.save(job);
		}
		return null;
	}

	@Override
	public Jobs eliminar(Long idJobTitle) {
		Jobs aux = this.buscar(idJobTitle);
		if (aux != null) {
			dao.deleteById(idJobTitle);
		}
		return aux;
	}

	@Override
	public Jobs buscar(Long idJobTitle) {
		// TODO Auto-generated method stub
		return dao.findById(idJobTitle).orElse(null);
	}

	@Override
	public List<Jobs> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Direction.DESC,"idJobTitle"));
	}

}
