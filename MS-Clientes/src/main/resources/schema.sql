--CREA TABLA COMO SI FUERA ORACLE
--PASO 1: ELIMINAR LA TABLA SI YA EXISTE
DROP TABLE IF EXISTS CLIENTES;

--PASO 2 CREAR TABLA
CREATE TABLE CLIENTES(
	ID_CLIENTE NUMBER, 
	NOMBRE NVARCHAR2(100), 
	DIRECCION NVARCHAR2(100), 
	CONTACTO NUMBER, 
	TIENDA_ID NUMBER,
	CONSTRAINT ID_CLIENTE_PK PRIMARY KEY (ID_CLIENTE)
);
