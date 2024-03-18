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
  
  
  CREATE TABLE VACINA(
idvacina INT auto_increment NOT NULL PRIMARY KEY,
NOME VARCHAR(100) NOT NULL
,PAIS_ORIGEM VARCHAR(100) NOT NULL
,IDPESQUISADOR INT NOT NULL
,ESTAGIO INT NOT NULL
,DATA_INICIO_PESQUISA DATE NOT NULL
,constraint IDPESQUISADOR foreign key(IDPESQUISADOR)references PESSOA(IDPESSOA)
);

CREATE TABLE APLICACAO_VACINA(
IDAPLICACAO_VACINA INT auto_increment NOT NULL PRIMARY KEY,
IDPESSOA INT NOT NULL,
IDVACINA INT NOT NULL,
DATA_APLICACAO DATE NOT NULL,
AVALIACAO INT NOT NULL,
constraint IDPESSOA foreign key (IDPESSOA)references PESSOA (IDPESSOA),
constraint IDVACINA foreign key (IDVACINA)references VACINA(IDVACINA)
);
  
);