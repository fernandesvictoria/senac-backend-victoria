drop database if exists exemplos;
create database exemplos;
use exemplos;

CREATE TABLE pessoa (
  `idpessoa` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `data_nascimento` date NOT NULL,
  `sexo` char(1) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `tipo_pessoa` varchar(255) NOT NULL,
  PRIMARY KEY (`idpessoa`),
  UNIQUE KEY `cpf` (`cpf`)
);