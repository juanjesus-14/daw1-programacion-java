# Programación en Java — 1.º DAW

Ejercicios y prácticas del módulo de **Programación** de 1.º de DAW (curso 2025-2026). Van desde las sentencias de control hasta el acceso a bases de datos con JDBC, organizados por unidad didáctica.

> 💡 El proyecto web de la unidad 9 tiene su propio repositorio: **[java-web-equipo-futbol](https://github.com/juanjesus-14/java-web-equipo-futbol)** (Servlets + JSP + MySQL).

## Tecnologías

- Java (proyectos Ant de NetBeans en UD1–UD7 y proyectos Maven en UD8)
- JDBC + MySQL (UD8)
- Ficheros de texto con `BufferedReader` / `FileWriter` (UD7)
- IDE: Apache NetBeans

## Índice

| Unidad | Contenido |
|---|---|
| [`ud01-sentencias-control`](ud01-sentencias-control) | Variables, entrada/salida, condicionales y bucles: relación 2 de ejercicios (29, 30, 31, 39…), factorial, `tiendaapp`, repaso de la unidad |
| [`ud02-funciones-recursividad`](ud02-funciones-recursividad) | Funciones y recursividad (factorial recursivo), `muestraAsignatura`, `NotasDaw` |
| [`ud03-arrays-matrices`](ud03-arrays-matrices) | Relación de 28 ejercicios de arrays y matrices (tres en raya, alfil, tesoro, rotar, diagonal…), `ArrayList`, matrices dinámicas, gestión de inventario de una tienda de videojuegos con matrices y una serie de ejercicios "Casa" de recuperación |
| [`ud04-clases-objetos`](ud04-clases-objetos) | Clases y objetos: 14 ejercicios (piloto de F1, caballo, ventana, alumno, vivienda en alquiler, equipo de baloncesto…) y prácticas `Main*` (bicicleta, coche, ordenador, cuenta, carrera, equipo de fútbol) |
| [`ud06-herencia-interfaces`](ud06-herencia-interfaces) | Herencia, clases abstractas e interfaces: animales, geometría, inventario IT, personas, selección de fútbol, vivienda y una relación de ejercicios (empleados, cuenta, videoclub, concesionario, profesores) |
| [`ud07-ficheros`](ud07-ficheros) | Lectura y escritura de ficheros de texto: clientes/cuentas, equipo de fútbol, relación de 12 ejercicios voluntarios |
| [`ud08-jdbc-mysql`](ud08-jdbc-mysql) | Acceso a MySQL con JDBC: relación de 4 ejercicios (lectura de tablas, dos tablas relacionadas, menú de inserción, login + CRUD de usuarios), equipo de fútbol con BD, script SQL de práctica |
| UD9 — Web con Java | Está en su propio repositorio: [java-web-equipo-futbol](https://github.com/juanjesus-14/java-web-equipo-futbol) |
| [`tarea-refuerzo-mejora`](tarea-refuerzo-mejora) | Tarea de refuerzo en dos versiones: `v1-ficheros` (personas y mascotas en ficheros) y `v2-base-de-datos` (la misma tarea con MySQL) |
| [`examenes`](examenes) | Mi código en exámenes y simulacros de UD1, UD3, UD6, UD7 y UD8 (sin los enunciados) |

> La UD5 no tiene proyectos propios guardados.

## Cómo ejecutar los ejercicios

**Proyectos Ant (UD1–UD7, carpetas con `nbproject/`):** ábrelos en NetBeans (*File → Open Project*) y ejecuta con *Run*. También se puede compilar a mano:

```bash
cd ud04-clases-objetos/maincoche
javac -d out src/maincoche/*.java
java -cp out maincoche.MainCoche
```

**Proyectos Maven (UD8, carpetas con `pom.xml`):** ábrelos en NetBeans o ejecútalos con Maven indicando la clase principal:

```bash
mvn compile exec:java -Dexec.mainClass="<paquete>.<ClasePrincipal>"
```

Los proyectos con base de datos necesitan MySQL en local. Tienes que cambiar `CAMBIA_ESTA_PASSWORD` en la clase `Conexion` / `ConexionBD` y revisar el puerto (unos proyectos usan `3306` y otros `3307`).

## Notas

- Algunos ejercicios de ficheros usan **rutas absolutas** del equipo donde se hicieron (`D:\workspace\...`, `F:\workspace\...`). Para ejecutarlos hay que cambiar la ruta.
- Varias carpetas son **iteraciones del mismo ejercicio** (por ejemplo `mainordenador`, `mainordenador-2-5`, `mainordenador-3-5`). Se han conservado para mostrar la evolución.
- No se incluyen los enunciados ni el material del profesorado.

## Autor

**Juan Jesús Díaz Garrido** — [github.com/juanjesus-14](https://github.com/juanjesus-14)
