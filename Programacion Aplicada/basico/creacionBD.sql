DROP DATABASE Editorial;

CREATE DATABASE Editorial;

USE Editorial;

CREATE TABLE SUCURSAL(
	id_Sucursal INT not null auto_increment,
    PRIMARY KEY (id_Sucursal),
    provincia VARCHAR(50) not null,   
    ciudad VARCHAR(25),
    telefono INT
);

CREATE TABLE EMPLEADO(
	id_Empleado INT not null auto_increment,
    PRIMARY KEY (id_Empleado),
    cedula VARCHAR(15) not null,
    nombre VARCHAR(50) not null,
    apellido VARCHAR(50) not null,
    telefono INT, 
    id_Sucursal INT,
    CONSTRAINT FK_id_SucursalEmpleado FOREIGN KEY (id_Sucursal) REFERENCES Sucursal(id_Sucursal) ON DELETE CASCADE
);

CREATE TABLE REVISTA(
	id_Revista INT not null auto_increment, 
    PRIMARY KEY (id_Revista),
    titulo VARCHAR(50),
    numero_Registro INT, 
    periodicidad VARCHAR(50),
    tipo VARCHAR(50)
);

CREATE TABLE PUBLICACION(
	id_Publicacion INT not null auto_increment,
    PRIMARY KEY (id_Publicacion),
    id_Sucursal INT,
    CONSTRAINT FK_id_SucursalPublicacion FOREIGN KEY (id_Sucursal) REFERENCES Sucursal(id_Sucursal) ON DELETE CASCADE,
    id_Revista INT,
    CONSTRAINT FK_id_RevistaPulicacion FOREIGN KEY (id_Revista) REFERENCES Revista(id_Revista)
);

CREATE TABLE ESPECIALIDAD(
	id_Especialidad INT not null auto_increment,
    PRIMARY KEY (id_Especialidad),
    descripcion VARCHAR(50)
);

CREATE TABLE SECCION(
	id_Seccion INT not null auto_increment,
    PRIMARY KEY (id_Seccion),
    titulo VARCHAR(50),
    extension INT,
    id_Revista INT,
    CONSTRAINT FK_id_RevistaSeccion FOREIGN KEY (id_Revista) REFERENCES Revista(id_Revista)
);

CREATE TABLE PERIODISTA_REVISTA(
	id_PeriodistaRevista INT not null auto_increment,
    PRIMARY KEY (id_PeriodistaRevista),
    id_Revista INT,
    id_Periodista INT
);

CREATE TABLE PERIODISTA(
	id_Periodista INT not null auto_increment,
    PRIMARY KEY (id_Periodista),
    cedula VARCHAR(15),
    nombre VARCHAR(50) not null,
    apellido VARCHAR(50) not null,
    telefono INT,
    id_Especialidad INT
);

ALTER TABLE PERIODISTA
ADD CONSTRAINT FK_id_EspecialidadPeriodista FOREIGN KEY (id_Especialidad) REFERENCES Especialidad(id_Especialidad);

Alter TABLE PERIODISTA_REVISTA
ADD CONSTRAINT FK_RevistaPER FOREIGN KEY (id_Revista) 
REFERENCES Revista(id_Revista),
ADD CONSTRAINT FK_PeriodistaPER FOREIGN KEY (id_Periodista) 
REFERENCES Periodista(id_Periodista);

CREATE TABLE EJEMPLAR(
	id_Ejemplar INT not null auto_increment,
    PRIMARY KEY (id_Ejemplar),
    fecha VARCHAR(50),
    numPaginas INT not null,
    numVendidos INT not null,
    id_Revista INT,
    CONSTRAINT FK_id_RevistaEjemplar FOREIGN KEY (id_Revista) REFERENCES Revista(id_Revista)
);
