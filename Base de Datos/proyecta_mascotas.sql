DROP DATABASE IF EXISTS proyecto_mascotas;
CREATE DATABASE proyecto_mascotas CHARACTER SET utf8;
USE proyecto_mascotas;

-- -----------------------------------------------------
-- Tabla ficha_medica
-- -----------------------------------------------------
CREATE TABLE ficha_medica (
  id INT NOT NULL AUTO_INCREMENT,
  vacunas VARCHAR(45),
  fecha DATE,
  esterilizacion TINYINT,
  desparasitacion TEXT,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Tabla duenos
-- -----------------------------------------------------
CREATE TABLE duenos (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45),
  foto_perfil TEXT,
  fecha_nacimiento DATE,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Tabla mascotas
-- -----------------------------------------------------
CREATE TABLE mascotas (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45),
  raza VARCHAR(45),
  edad INT,
  color VARCHAR(45),
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_ficha_medica INT NOT NULL,
  id_dueno INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_mascotas_ficha_medica_idx (id_ficha_medica),
  INDEX fk_mascotas_duenos1_idx (id_dueno),
  CONSTRAINT fk_mascotas_ficha_medica
    FOREIGN KEY (id_ficha_medica)
    REFERENCES ficha_medica (id),
  CONSTRAINT fk_mascotas_duenos1
    FOREIGN KEY (id_dueno)
    REFERENCES duenos (id)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Tabla trucos
-- -----------------------------------------------------
CREATE TABLE trucos (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45),
  PRIMARY KEY (id)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Tabla mascotas_trucos
-- -----------------------------------------------------
CREATE TABLE mascotas_trucos (
  id_mascota INT NOT NULL,
  id_truco INT NOT NULL,
  PRIMARY KEY (id_mascota, id_truco),
  INDEX fk_mascotas_has_trucos_trucos1_idx (id_truco),
  INDEX fk_mascotas_has_trucos_mascotas1_idx (id_mascota),
  CONSTRAINT fk_mascotas_has_trucos_mascotas1
    FOREIGN KEY (id_mascota)
    REFERENCES mascotas (id),
  CONSTRAINT fk_mascotas_has_trucos_trucos1
    FOREIGN KEY (id_truco)
    REFERENCES trucos (id)
) ENGINE=InnoDB;

-- =====================================================
-- DATOS DE PRUEBA
-- =====================================================

-- =====================================================
-- DUEÑOS
-- =====================================================

INSERT INTO duenos (nombre, foto_perfil, fecha_nacimiento) VALUES
('Juan Pérez', 'juan.jpg', '1990-05-15'),
('Ana García', 'ana.jpg', '1995-09-22'),
('Carlos López', 'carlos.jpg', '1988-11-03'),
('María Torres', 'maria.jpg', '1992-07-18');

-- =====================================================
-- FICHAS MÉDICAS
-- =====================================================

INSERT INTO ficha_medica (vacunas, fecha, esterilizacion, desparasitacion) VALUES
('Rabia', '2025-01-15', 1, '2025-02-01'),
('Triple Felina', '2025-03-10', 1, '2025-04-01'),
('Rabia y Parvovirus', '2024-11-12', 0, '2025-01-20'),
('Moquillo', '2025-02-18', 1, '2025-03-01'),
('Rabia', '2025-04-25', 0, '2025-05-01'),
('Triple Felina y Rabia', '2025-05-10', 1, '2025-05-15');

-- =====================================================
-- MASCOTAS
-- =====================================================

INSERT INTO mascotas (
    nombre,
    raza,
    edad,
    color,
    id_ficha_medica,
    id_dueno
) VALUES
('Miu', 'Siamés', 3, 'Blanco', 1, 1),
('Michi', 'Criollo', 2, 'Naranja', 2, 2),
('Luna', 'Persa', 4, 'Gris', 3, 2),
('Max', 'Labrador', 5, 'Dorado', 4, 3),
('Rocky', 'Pastor Alemán', 6, 'Negro y café', 5, 4),
('Nala', 'Mestiza', 1, 'Blanca', 6, 1);

-- =====================================================
-- TRUCOS
-- =====================================================

INSERT INTO trucos (nombre) VALUES
('Sentarse'),
('Dar la pata'),
('Rodar'),
('Saltar'),
('Traer la pelota'),
('Acostarse');

-- =====================================================
-- RELACIONES MASCOTA - TRUCO
-- =====================================================

INSERT INTO mascotas_trucos VALUES
(1,1),
(1,2),

(2,1),
(2,3),
(2,4),

(3,1),
(3,6),

(4,1),
(4,2),
(4,5),

(5,2),
(5,5),
(5,6),

(6,1),
(6,3),
(6,4),
(6,5);