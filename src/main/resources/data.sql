INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('AR','ARGENTINA', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('BR','BRASIL', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('UY','URUGUAY', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('CH','CHILE', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO persona (apellido, cc, nombre, dtype, rut) 
VALUES ('PIEROTTI', 1234, 'SANTIAGO', 'PersonaFisica', 1);

INSERT INTO persona (anio_fundacion, razon_social, dtype, rut) 
VALUES (2015, 'EMPRESA DE PRUEBA', 'PersonaJuridica', 2);

INSERT INTO moneda (id, descripcion, descubierto) 
VALUES (1, 'PESOS', 1000.00);

INSERT INTO moneda (id, descripcion, descubierto) 
VALUES (2, 'DOLARES', 300.00);

INSERT INTO moneda (id, descripcion, descubierto) 
VALUES (3, 'EUROS', 150.00);

INSERT INTO cuenta_corriente (nro_cuenta, saldo, moneda_id, titular_id)
VALUES (1, 1500.00, 1, 1);

INSERT INTO cuenta_corriente (nro_cuenta, saldo, moneda_id, titular_id)
VALUES (2, 0.00, 2, 2);