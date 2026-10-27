CREATE TABLE Usuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(50) UNIQUE,   -- no puede haber dos iguales
    password  VARCHAR(50),
    tipo      VARCHAR(10)           -- 'admin' o 'normal'
);

INSERT INTO Usuarios (username, password, tipo) VALUES ('admin',  '1234', 'admin');
INSERT INTO Usuarios (username, password, tipo) VALUES ('juan',   'abcd', 'normal');
INSERT INTO Usuarios (username, password, tipo) VALUES ('maria',  'abcd', 'normal');