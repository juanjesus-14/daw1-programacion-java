insert into clientes(dni, nombre, apellidos) values
('12345678A','Irene', 'Moreno Ruiz'),
('87654321B','Ana', 'Álvarez Gómez'),
('88776655K','Lucas', 'Martin'),
('11223344J','José', 'López Gámez');

insert into cuentas(numCuenta, nombreBanco, dniCliente) values('ES1234', 'IberCaja','12345678A');
insert into cuentas(numCuenta, nombreBanco, dniCliente) values('ES2345', 'BBVA','12345678A');

select * from clientes;
select * from cuentas;



CREATE TABLE parejas(
dni VARCHAR(15) PRIMAR Y KEY,
nombre VARCHAR(50),
apellidos VARCHAR(100)
);

CREATE TABLE empleados(
numeroEmpleado INT AUTO_INCREMENT PRIMARY KEY,
dni VARCHAR(15),
nombre VARCHAR(50),
apellidos VARCHAR(100),
email VARCHAR(100),
dniPareja  VARCHAR(15),
FOREIGN KEY (dniPareja) REFERENCES parejas(dni)
);

INSERT INTO parejas (dni, nombre, apellidos) VALUES ('11111111A','Ana', 'López');
INSERT INTO parejas (dni, nombre, apellidos) VALUES ('22222222A','María', 'García');
INSERT INTO parejas (dni, nombre, apellidos) VALUES ('66666666A','Pedro', 'Gil');

INSERT INTO empleados (numeroEmpleado, dni, nombre, apellidos, email, dniPareja)
VALUES (1,'12345678A','Juan','Pérez','juan@empresa.com','11111111A');
INSERT INTO empleados (numeroEmpleado, dni, nombre, apellidos, email, dniPareja)
VALUES (2,'87654321B','Luis','Martín','luis@empresa.com','22222222A');
INSERT INTO empleados (numeroEmpleado, dni, nombre, apellidos, email, dniPareja)
VALUES (3,'33333333C','Carla','Ruiz','carla@empresa.com','66666666A');
INSERT INTO empleados (numeroEmpleado, dni, nombre, apellidos, email, dniPareja)
VALUES (4,'44444444C','Juan','Ruiz','juan@empresa.com',null);
INSERT INTO empleados (numeroEmpleado, dni, nombre, apellidos, email)
VALUES (5,'55555555C','Jordi','Gil','jordi@empresa.com');

select * from empleados;
select * from parejas;

