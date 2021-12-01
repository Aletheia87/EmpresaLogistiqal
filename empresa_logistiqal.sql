CREATE DATABASE empresa_logistiqal;

USE empresa_logistiqal;

CREATE TABLE producto (
codigo INT primary key,
nombre VARCHAR(20) UNIQUE, 
precio INT,
stock INT
);

