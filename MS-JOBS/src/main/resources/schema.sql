--CREA TABLA COMO SI FUERA ORACLE
--PASO 1: ELIMINAR LA TABLA SI YA EXISTE
DROP TABLE IF EXISTS JOBS;

--PASO 2 CREAR TABLA
CREATE TABLE JOBS(
	ID_JOB NUMBER, 
	JOB_TITLE NVARCHAR2(150), 
	CONSTRAINT ID_JOB_PK PRIMARY KEY (ID_JOB)
);
