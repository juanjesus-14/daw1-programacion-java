CREATE TABLE Alumnos (
    idAlumno  INT AUTO_INCREMENT PRIMARY KEY,
    nombre    VARCHAR(100),
    apellidos VARCHAR(100),
    email     VARCHAR(100)
);

CREATE TABLE Calificaciones (
    idCalificacion INT AUTO_INCREMENT PRIMARY KEY,
    idAlumno       INT,
    asignatura     VARCHAR(50),
    nota           DOUBLE,
    FOREIGN KEY (idAlumno) REFERENCES Alumnos(idAlumno)
);

INSERT INTO Alumnos (nombre, apellidos, email)
VALUES ('Laura','Montes','laura@iessalduba.es');
INSERT INTO Alumnos (nombre, apellidos, email)
VALUES ('Carlos','Pérez','carlos@iessalduba.es');
INSERT INTO Alumnos (nombre, apellidos, email)
VALUES ('Marta','López','marta@iessalduba.es');

INSERT INTO Calificaciones (idAlumno, asignatura, nota) VALUES (1,'Programación',8.5);
INSERT INTO Calificaciones (idAlumno, asignatura, nota) VALUES (1,'Base de Datos',9.0);
INSERT INTO Calificaciones (idAlumno, asignatura, nota) VALUES (2,'Programación',7.2);
INSERT INTO Calificaciones (idAlumno, asignatura, nota) VALUES (3,'Base de Datos',9.1);