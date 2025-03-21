package com.mx.Employees.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Employees.Entity.Employees;

public interface IEmployeesDao extends JpaRepository<Employees, Long>{

}
