-- Añadir una columna nueva en la tabla countries
ALTER TABLE countries ADD COLUMN currency VARCHAR(255);

-- Actualizar datos iniciales, si es necesario
UPDATE countries SET currency = 'EUR' WHERE country_code2 = 'ES';
