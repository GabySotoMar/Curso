--CREA TABLA COMO SI FUERA ORACLE
--PASO 1: ELIMINAR LA TABLA SI YA EXISTE
DROP TABLE IF EXISTS DEPARTAMENTS;

--PASO 2 CREAR TABLA
CREATE TABLE DEPARTAMENTS(
	ID_DEPARTAMENT NUMBER, 
	DEPARTAMENT_NAME NVARCHAR2(150), 
	CONSTRAINT ID_DEPARTAMENT_PK PRIMARY KEY (ID_DEPARTAMENT)
);
