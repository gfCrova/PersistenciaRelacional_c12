DROP DATABASE IF EXISTS qatar2022;

CREATE DATABASE qatar2022;

USE Qatar2022;

DROP TABLE IF EXISTS empleados;

CREATE TABLE empleados(
  id_empleados INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(55) NOT NULL,
  apellido VARCHAR(55) NOT NULL,
  dni INT NOT NULL UNIQUE,
  nacionalidad VARCHAR(55) NOT NULL,
  dpto_id INT,
  PRIMARY KEY (id_empleados)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE departamentos (
  id_departamento INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(55) NOT NULL,
  presupuesto BIGINT NULL,
  PRIMARY KEY (id_departamento)
  )  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
  
SELECT * FROM empleados;
SELECT * FROM departamentos;

ALTER TABLE empleados ADD CONSTRAINT FOREIGN KEY (dpto_id) REFERENCES departamentos (id_departamento) ON DELETE CASCADE;
  
INSERT INTO departamentos(nombre, presupuesto) VALUES
	( "Logística", 2599000), 
    ( "Sistemas", 3465999), 
    ( "Compras", 1999999),
    ( "Distribución", 34333232);
  
INSERT INTO empleados(nombre, apellido, dni, nacionalidad, dpto_id) VALUES
	( "Diego Alejandro", "Fredes", 42346752, "Uruguay", 1), 
    ( "Micaela", "Velazquez", 22656734, "Argentina", 2), 
    ( "María Josefina", "Gamarra", 35670654, "Perú", 1), 
    ( "Tairon", "Moreira", 38635113, "Colombia", 4),
    ( "Victoria", "Pérez", 26008341, "Argentina", 2),
    ( "Lara Isabella", "Muñoz", 21904022, "Chile", 3
);