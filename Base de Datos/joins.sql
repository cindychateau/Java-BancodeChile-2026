-- SELECT: Leer los registros que tenemos en una tabla

SELECT * FROM mascotas; 
SELECT nombre FROM duenos;
SELECT * FROM duenos
WHERE nombre LIKE "%a%";

-- INNER JOIN: unir dos tablas en base a la clave foránea y la clave primaria

-- JOIN 1:1
SELECT * FROM mascotas
INNER JOIN ficha_medica ON mascotas.id_ficha_medica = ficha_medica.id;

SELECT nombre, edad, vacunas FROM mascotas
INNER JOIN ficha_medica ON mascotas.id_ficha_medica = ficha_medica.id;

SELECT nombre, edad, vacunas FROM mascotas
INNER JOIN ficha_medica ON mascotas.id_ficha_medica = ficha_medica.id
WHERE vacunas LIKE "%rabia%";

-- JOIN 1:n
SELECT * FROM mascotas
INNER JOIN duenos ON mascotas.id_dueno = duenos.id;

SELECT mascotas.nombre AS nombre_mascota, edad, duenos.nombre AS nombre_duenos FROM mascotas
INNER JOIN duenos ON mascotas.id_dueno = duenos.id;

SELECT mascotas.nombre AS nombre_mascota, edad, duenos.nombre AS nombre_duenos FROM mascotas
INNER JOIN duenos ON mascotas.id_dueno = duenos.id
WHERE edad > 2;

SELECT mascotas.nombre AS nombre_mascota, edad, duenos.nombre AS nombre_duenos FROM mascotas
INNER JOIN duenos ON mascotas.id_dueno = duenos.id
WHERE edad > 2
ORDER BY edad DESC;

-- JOIN n:m
SELECT * FROM mascotas
INNER JOIN mascotas_trucos ON mascotas.id = mascotas_trucos.id_mascota
INNER JOIN trucos ON trucos.id = mascotas_trucos.id_truco;

SELECT mascotas.nombre, raza, trucos.nombre FROM mascotas
INNER JOIN mascotas_trucos ON mascotas.id = mascotas_trucos.id_mascota
INNER JOIN trucos ON trucos.id = mascotas_trucos.id_truco;

SELECT mascotas.nombre AS nombre_mascota, raza, trucos.nombre AS nombre_truco FROM mascotas
INNER JOIN mascotas_trucos ON mascotas.id = mascotas_trucos.id_mascota
INNER JOIN trucos ON trucos.id = mascotas_trucos.id_truco;