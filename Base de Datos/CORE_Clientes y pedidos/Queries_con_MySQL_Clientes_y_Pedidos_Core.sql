-- Inserta al menos cinco nuevos clientes en la tabla «clientes».
INSERT INTO clientes (nombre, direccion, telefono) VALUES
("Edward Elric", "Resembool 1, Región del Este", "+56912345678"),
('Roy Mustang', 'Cuartel Central, Ciudad Central','+56922222222'),
('Winry Rockbell', 'Rush Valley 45, Región del Este','+56933333333'),
('Alphonse Elric', 'Resembool 1, Región del Este',   '+56944444444'),
('Riza Hawkeye', 'Cuartel Central, Ciudad Central','+56955555555'),
('Alex Louis Armstrong', 'Cuartel Central, Ciudad Central','+56966666666');


-- Inserta al menos diez nuevos pedidos en la tabla «pedidos». 
INSERT INTO pedidos (id_cliente, total) VALUES
(1, 15990),
(1, 20590),
(1, 13200),
(2, 10000),
(2, 50990),
(3, 14200),
(3, 30190),
(3, 12000),
(4, 17650),
(4, 7990),
(5, 209000);

-- Proyecta todos los clientes de la tabla «clientes» y sus respectivos pedidos.
SELECT c.id_cliente AS id_cliente,
	c.nombre,
	p.id_pedido AS id_pedido,
	p.fecha_pedido,
	p.total
FROM clientes c LEFT JOIN pedidos p ON c.id_cliente = p.id_cliente
ORDER BY c.id_cliente;

-- Proyecta todos los pedidos realizados por un cliente específico, utilizando su ID.
SELECT c.nombre,
	p.id_pedido AS id_pedido,
    p.fecha_pedido,
    p.total
FROM clientes c
INNER JOIN pedidos p ON c.id_cliente = p.id_cliente
WHERE c.id_cliente = 1;

-- Calcula el total de todos los pedidos para cada cliente.
SELECT c.id_cliente,
	c.nombre,
    SUM(p.total) AS total_gastado
FROM clientes c
LEFT JOIN pedidos p ON c.id_cliente = p.id_cliente
GROUP BY c.id_cliente, c.nombre
ORDER BY total_gastado DESC;
    
    
-- Elimina un cliente específico de la tabla «clientes» y todos sus pedidos asociados de la tabla «pedidos».
DELETE FROM pedidos WHERE id_cliente = 2;
DELETE FROM clientes WHERE id_cliente = 2;


-- Proyecta los tres clientes que han realizado más pedidos, ordenados de forma descendente por el número de pedidos.
SELECT c.id_cliente,
	c.nombre,
    COUNT(p.id_pedido) AS cantidad_pedidos
FROM clientes c
INNER JOIN pedidos p ON c.id_cliente = p.id_cliente
GROUP BY c.id_cliente, c.nombre
ORDER BY cantidad_pedidos DESC
LIMIT 3;
