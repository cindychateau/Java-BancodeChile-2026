-- CRUD: Create Read Update Delete -> Crear, Leer, Actualizar y Borrar
-- Consultas de tipo SELECT: SELECCIONAR información de mis tablas. Leer/Read

-- SELECT * FROM <tabla>; -> Selecciona todas las columnas de una tabla en específico.
SELECT * FROM usuarios;

-- SELECT columna1, columna2, columna3 FROM <tabla>; Seleccionando columnas específicas a mostrar
SELECT nombre, edad FROM usuarios;

-- SELECT columna1, columna2 FROM <tabla> WHERE <condicional>; "Filtrando" los registros que quiero que se muestren
SELECT nombre, edad FROM usuarios WHERE id = 2;

SELECT * FROM usuarios WHERE edad > 20; -- > < >= <= = !=

SELECT * FROM usuarios WHERE edad < 20;

SELECT * FROM usuarios WHERE nombre LIKE "aureLiaNo"; -- Indistinto a Mayúsculas/Minúsculas

SELECT nombre FROM usuarios WHERE nombre LIKE "Al%"; -- % comodin: cualquier caracter

SELECT nombre FROM usuarios WHERE nombre LIKE "%o";

SELECT nombre FROM usuarios WHERE nombre LIKE "%m%";

-- AND: Ambas condiciones se cumplan
SELECT * FROM usuarios WHERE nombre LIKE "%o" AND edad > 23;

-- OR: Una u otra condicional debe de cumplirse
SELECT nombre, edad FROM usuarios WHERE nombre LIKE "Al%" OR edad > 30;

SELECT * FROM usuarios WHERE edad > 25 ORDER BY nombre ASC; -- Defecto: ASC (A-Z) o DESC (Z-A)
SELECT * FROM usuarios WHERE edad > 25 ORDER BY nombre DESC;

SELECT * FROM usuarios WHERE edad > 25 ORDER BY edad ASC; -- ASC: menor a mayor. DESC: mayor a menor

SELECT * FROM usuarios;
SELECT * FROM usuarios LIMIT 2, 4; -- LIMIT inicio, cantidad

-- SELECT columna1, columna2, columna3, * FROM <tabla>
-- WHERE <condicional> AND OR <condicional>
-- ORDER BY columna1 ASC/DESC
-- LIMIT inicio, cantidad

