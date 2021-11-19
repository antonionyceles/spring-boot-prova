CREATE SCHEMA IF NOT EXISTS prova;


-- prova.marca definition

-- Drop table

-- DROP TABLE prova.marca;

CREATE TABLE IF NOT EXISTS prova.marca (
	id bigserial NOT NULL,
	nome varchar(255) NULL,
	CONSTRAINT marca_pkey PRIMARY KEY (id)
);


-- prova.usuario definition

-- Drop table

-- DROP TABLE prova.usuario;

CREATE TABLE IF NOT EXISTS prova.usuario (
	id bigserial NOT NULL,
	login varchar(255) NULL,
	senha varchar(255) NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);


-- prova.modelo definition

-- Drop table

-- DROP TABLE prova.modelo;

CREATE TABLE IF NOT EXISTS prova.modelo (
	id bigserial NOT NULL,
	nome varchar(255) NULL,
	marca_id int8 NULL,
	CONSTRAINT modelo_pkey PRIMARY KEY (id),
	CONSTRAINT fkllxq2dldvhxvb5q9csar7vdfy FOREIGN KEY (marca_id) REFERENCES prova.marca(id)
);


-- prova.veiculo definition

-- Drop table

-- DROP TABLE prova.veiculo;

CREATE TABLE IF NOT EXISTS prova.veiculo (
	id bigserial NOT NULL,
	ano_fabricacao varchar(255) NULL,
	ano_modelo varchar(255) NULL,
	ativo bool NULL,
	chassis varchar(255) NULL,
	consumo float8 NULL,
	cor varchar(255) NULL,
	dt_cadastro date NULL,
	dt_desativacao date NULL,
	placa varchar(255) NULL,
	qt_passageiro int4 NULL,
	modelo_id int8 NULL,
	CONSTRAINT veiculo_pkey PRIMARY KEY (id),
	CONSTRAINT fkg66qhh2d26iq69v6fhhifnfu6 FOREIGN KEY (modelo_id) REFERENCES prova.modelo(id)
);


CREATE TABLE IF NOT EXISTS prova.funcionario (
	id bigserial NOT NULL,
	cpf varchar(255) NULL,
	dt_nascimento timestamp NULL,
	nome varchar(255) NULL,
	sobrenome varchar(255) NULL,
	usuario_id int8 NULL,
	CONSTRAINT funcionario_pkey PRIMARY KEY (id)
);


-- prova.funcionario foreign keys

ALTER TABLE prova.funcionario ADD CONSTRAINT fkwnmqfjh318guaklwmtu9nnma FOREIGN KEY (usuario_id) REFERENCES prova.usuario(id);

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public 
TO dbprova;

INSERT INTO prova.usuario
(id, login, senha)
VALUES(1, 'admin', '123456');
