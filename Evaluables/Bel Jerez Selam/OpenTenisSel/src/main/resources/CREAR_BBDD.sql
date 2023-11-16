CREATE DATABASE OpenTenis;

USE OpenTenis;

CREATE TABLE tenista (
  codigo UUID NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  nacionalidad VARCHAR(50) NOT NULL,
  PRIMARY KEY (codigo)
);


CREATE TABLE torneo (
  codigo UUID NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  puntos INT NOT NULL,
  premio DOUBLE NOT NULL,
  PRIMARY KEY (codigo)
);

CREATE TABLE sponsor (
  codigo INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (codigo)
);

CREATE TABLE contrato (
  codigo UUID NOT NULL,
  fechaInicio DATE NOT NULL,
  fechaFin DATE NOT NULL,
  saldo DOUBLE NOT NULL,
  codSponsor INT,
  PRIMARY KEY (codigo)
);

CREATE TABLE tenistacontrato (
  codTenista UUID NOT NULL,
  codContrato UUID NOT NULL,
  PRIMARY KEY (codTenista, codContrato)
);

CREATE TABLE torneoganado (
  codTenista UUID NOT NULL,
  codTorneo UUID NOT NULL,
  PRIMARY KEY (codTenista, codTorneo)
);


-- RESTRICCIONES

ALTER TABLE torneoganado
ADD CONSTRAINT fk_torneo_tg
FOREIGN KEY (codTorneo) REFERENCES torneo (codigo);

ALTER TABLE torneoganado
ADD CONSTRAINT fk_tenista_tg
FOREIGN KEY (codTenista) REFERENCES tenista (codigo);

ALTER TABLE contrato
ADD CONSTRAINT fk_sponsor_cs
FOREIGN KEY (codSponsor) REFERENCES sponsor (codigo);

ALTER TABLE tenistacontrato
ADD CONSTRAINT fk_tenista
FOREIGN KEY (codTenista) REFERENCES tenista (codigo);

ALTER TABLE tenistacontrato
ADD CONSTRAINT fk_contrato
FOREIGN KEY (codContrato) REFERENCES contrato (codigo);

