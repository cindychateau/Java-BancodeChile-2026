-- INSERT INTO <tabla> (columna1, columna2, columna3) 
-- VALUES (valor1, valor2, valor3);
INSERT INTO estudiantes (nombre, edad) VALUES
("Juana de Arco", 18),
("Elena de Troya", 22),
("Angeles Mastreta", 50),
("Han Kan", 30),
("Mariana Treviño", 41);

INSERT INTO cursos (nombre, duracion) VALUES
("Fullstack Java", "9 semanas"),
("Fullstack Python", "9 semanas"),
("IA Lab", "32 horas"),
("Data Analytics", "12 semanas");

SELECT * FROM estudiantes; -- 1-5
SELECT * FROM cursos; -- 1-4

INSERT INTO inscripciones (id_estudiante, id_curso) VALUES
(1, 4),
(1, 2),
(2, 3),
(2, 4),
(3, 1),
(3, 3),
(4, 2),
(4, 1),
(5, 1),
(5, 3);

SELECT * FROM estudiantes
INNER JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
INNER JOIN cursos ON cursos.id = inscripciones.id_curso;

SELECT * FROM estudiantes
INNER JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
INNER JOIN cursos ON cursos.id = inscripciones.id_curso
WHERE cursos.nombre = "IA Lab";

SELECT * FROM estudiantes
INNER JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
INNER JOIN cursos ON cursos.id = inscripciones.id_curso
WHERE estudiantes.nombre = "Elena de Troya";

SELECT nombre AS curso, COUNT(id_estudiante) AS total_estudiantes
FROM cursos
INNER JOIN inscripciones ON cursos.id = inscripciones.id_curso
GROUP BY cursos.nombre;

SELECT * FROM estudiantes
LEFT JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
WHERE id_estudiante IS NULL;



