package com.mx.Jobs.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Jobs.Entity.Jobs;

public interface IJobsDao extends JpaRepository<Jobs, Long> {

}
