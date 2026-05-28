SELECT * FROM usuarios;

-- CRUD: Create/Crear
-- INSERT INTO <tabla> (columna1, columna2, columna3) VALUES (valor1, valor2, valor3);
INSERT INTO usuarios (nombre, edad, direccion_id) VALUES("Juana", 30, 2);

-- CRUD: Update/Actualizar
-- UPDATE <tabla> SET columna1 = valor1 WHERE id = NUM;
UPDATE usuarios SET edad = 31 WHERE id = 8;

UPDATE usuarios SET nombre = "Peter", edad = 33 WHERE id = 9;

-- CRUD: Delete/Borrar
-- DELETE FROM <tabla> WHERE id = NUM;
DELETE FROM usuarios WHERE id = 9;

-- TRUNCATE TABLE <tabla>; Borra los registros de mi tabla. Conserva la tabla y columnas, pero borra filas.
-- DROP TABLE <tabla>; ELIMINAR POR COMPLETO la tabla
