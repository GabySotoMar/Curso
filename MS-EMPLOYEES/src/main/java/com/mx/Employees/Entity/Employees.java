package com.mx.Employees.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "EMPLOYEES")
@Data
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ID_EMPLOYEE")//SEQ_ID_PRODUCTO
	@SequenceGenerator(name = "S_ID_EMPLOYEE", sequenceName = "S_ID_EMPLOYEE", allocationSize = 1)
	private Long idEmployee;
	private String firstName;
	private String lastName;
	private String email;
	@Column(name="PHONE_NUMBER", columnDefinition = "NUMBER")
	private String phoneNumber;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") 
	private Date hireDate;
	private Double salary;
	private int idDepartament;
	private int idJobTitle;	
	
	
	/*
	 * ID_EMPLOYEE NUMBER,
    FIRST_NAME NVARCHAR2(100),
    LAST_NAME NVARCHAR2(200),
    EMAIL NVARCHAR2(200),
    PHONE_NUMBER NUMBER,
    HIRE_DATE DATE,
    SALARY NUMBER,
    ID_DEPARTAMENT NUMBER,
    ID_JOB_TITLE NUMBER,
    {
  
    "firstName": "GABRIELA", 
    "lastName": "SOTO MARQUEZ",
	"email": "gabys.10@hotmail.com", 
    "phoneNumber": 22224092530
    "hireDate": "10/07/2023",
	"salary": 3630, 
    "idDepartament": 1
    "idJobTitle": 1
}
	 */

}
