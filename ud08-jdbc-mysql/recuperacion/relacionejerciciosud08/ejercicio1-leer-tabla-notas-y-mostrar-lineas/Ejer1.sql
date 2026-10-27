CREATE TABLE NOTAS (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    nombre   VARCHAR(100),
    asignatura VARCHAR(50),
    nota     DOUBLE
);

INSERT INTO NOTAS (nombre, asignatura, nota) VALUES ('Laura Montes',  'Programación',   8.5);
INSERT INTO NOTAS (nombre, asignatura, nota) VALUES ('Laura Montes',  'Base de Datos',  9.0);
INSERT INTO NOTAS (nombre, asignatura, nota) VALUES ('Carlos Pérez',  'Programación',   7.2);
INSERT INTO NOTAS (nombre, asignatura, nota) VALUES ('Marta López',   'Base de Datos',  9.1);