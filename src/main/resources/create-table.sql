DROP DATABASE IF EXISTS exemplos;
CREATE DATABASE exemplos;
USE exemplos;
 
 CREATE TABLE PAIS (
    IDPAIS INT AUTO_INCREMENT NOT NULL,
    NOME VARCHAR(255) NOT NULL,
    SIGLA VARCHAR(2) NOT NULL,
    CONSTRAINT PAIS_PK PRIMARY KEY (IDPAIS)
);
 
 
CREATE TABLE pessoa (
    idpessoa INTEGER AUTO_INCREMENT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    tipo_pessoa VARCHAR(255) NOT NULL,
    idpais INT NOT NULL,
    CONSTRAINT idpais FOREIGN KEY (idpais)
        REFERENCES pais (idpais),
    CONSTRAINT pessoa_pk PRIMARY KEY (idpessoa)
);

CREATE TABLE VACINA (
    IDVACINA INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    NOME VARCHAR(100) NOT NULL,
    IDPESQUISADOR INT NOT NULL,
    idpais INT NOT NULL,
    ESTAGIO VARCHAR(100) NOT NULL,
    DATA_INICIO_PESQUISA DATE NOT NULL,
    CONSTRAINT idpaisVacina FOREIGN KEY (idpais)
        REFERENCES pais (idpais),
    CONSTRAINT IDPESQUISADOR FOREIGN KEY (IDPESQUISADOR)
        REFERENCES PESSOA (IDPESSOA)
);

CREATE TABLE APLICACAO_VACINA (
    IDAPLICACAO_VACINA INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    IDPESSOA INT NOT NULL,
    IDVACINA INT NOT NULL,
    DATA_APLICACAO DATE NOT NULL,
    AVALIACAO INT NOT NULL,
    CONSTRAINT IDPESSOA FOREIGN KEY (IDPESSOA)
        REFERENCES PESSOA (IDPESSOA),
    CONSTRAINT IDVACINA2 FOREIGN KEY (IDVACINA)
        REFERENCES VACINA (IDVACINA)
);

INSERT INTO PAIS (nome, sigla) VALUES
('Afeganistão', 'AF'),
('Albânia', 'AL'),
('Argélia', 'DZ'),
('Andorra', 'AD'),
('Angola', 'AO'),
('Antígua e Barbuda', 'AG'),
('Argentina', 'AR'),
('Armênia', 'AM'),
('Austrália', 'AU'),
('Áustria', 'AT'),
('Azerbaijão', 'AZ'),
('Bahamas', 'BS'),
('Bahrein', 'BH'),
('Bangladesh', 'BD'),
('Barbados', 'BB'),
('Bielorrússia', 'BY'),
('Bélgica', 'BE'),
('Belize', 'BZ'),
('Benin', 'BJ'),
('Butão', 'BT'),
('Bolívia', 'BO'),
('Bósnia e Herzegovina', 'BA'),
('Botsuana', 'BW'),
('Brasil', 'BR'),
('Brunei', 'BN'),
('Bulgária', 'BG'),
('Burkina Faso', 'BF'),
('Burundi', 'BI'),
('Cabo Verde', 'CV'),
('Camboja', 'KH'),
('Camarões', 'CM'),
('Canadá', 'CA'),
('República Centro-Africana', 'CF'),
('Chade', 'TD'),
('Chile', 'CL'),
('China', 'CN'),
('Colômbia', 'CO'),
('Comores', 'KM'),
('República Democrática do Congo', 'CD'),
('República do Congo', 'CG'),
('Costa Rica', 'CR'),
('Croácia', 'HR'),
('Cuba', 'CU'),
('Chipre', 'CY'),
('República Tcheca', 'CZ'),
('Dinamarca', 'DK'),
('Djibuti', 'DJ'),
('Dominica', 'DM'),
('República Dominicana', 'DO'),
('Timor-Leste', 'TL'),
('Equador', 'EC'),
('Egito', 'EG'),
('El Salvador', 'SV'),
('Guiné Equatorial', 'GQ'),
('Eritreia', 'ER'),
('Estônia', 'EE'),
('Eswatini', 'SZ'),
('Etiópia', 'ET'),
('Fiji', 'FJ'),
('Finlândia', 'FI'),
('França', 'FR'),
('Gabão', 'GA'),
('Gâmbia', 'GM'),
('Geórgia', 'GE'),
('Alemanha', 'DE'),
('Gana', 'GH'),
('Grécia', 'GR'),
('Granada', 'GD'),
('Guatemala', 'GT'),
('Guiné', 'GN'),
('Guiné-Bissau', 'GW'),
('Guiana', 'GY'),
('Haiti', 'HT'),
('Honduras', 'HN'),
('Hungria', 'HU'),
('Islândia', 'IS'),
('Índia', 'IN'),
('Indonésia', 'ID'),
('Irã', 'IR'),
('Iraque', 'IQ'),
('Irlanda', 'IE'),
('Israel', 'IL'),
('Itália', 'IT'),
('Costa do Marfim', 'CI'),
('Jamaica', 'JM'),
('Japão', 'JP'),
('Jordânia', 'JO'),
('Cazaquistão', 'KZ'),
('Quênia', 'KE'),
('Kiribati', 'KI'),
('Coreia do Norte', 'KP'),
('Coreia do Sul', 'KR'),
('Kuwait', 'KW'),
('Quirguistão', 'KG'),
('Laos', 'LA'),
('Letônia', 'LV'),
('Líbano', 'LB'),
('Lesoto', 'LS'),
('Libéria', 'LR'),
('Líbia', 'LY'),
('Liechtenstein', 'LI'),
('Lituânia', 'LT'),
('Luxemburgo', 'LU'),
('Madagascar', 'MG'),
('Malaui', 'MW'),
('Malásia', 'MY'),
('Maldivas', 'MV'),
('Mali', 'ML'),
('Malta', 'MT'),
('Ilhas Marshall', 'MH'),
('Mauritânia', 'MR'),
('Maurícia', 'MU'),
('México', 'MX'),
('Micronésia', 'FM'),
('Moldávia', 'MD'),
('Mônaco', 'MC'),
('Mongólia', 'MN'),
('Montenegro', 'ME'),
('Marrocos', 'MA'),
('Moçambique', 'MZ'),
('Mianmar', 'MM'),
('Namíbia', 'NA'),
('Nauru', 'NR'),
('Nepal', 'NP'),
('Países Baixos', 'NL'),
('Nova Zelândia', 'NZ'),
('Nicarágua', 'NI'),
('Níger', 'NE'),
('Nigéria', 'NG'),
('Niue', 'NU'),
('Macedônia do Norte', 'MK'),
('Noruega', 'NO'),
('Omã', 'OM'),
('Paquistão', 'PK'),
('Palau', 'PW'),
('Panamá', 'PA'),
('Papua Nova Guiné', 'PG'),
('Paraguai', 'PY'),
('Peru', 'PE'),
('Filipinas', 'PH'),
('Polônia', 'PL'),
('Portugal', 'PT'),
('Catar', 'QA'),
('Romênia', 'RO'),
('Rússia', 'RU'),
('Ruanda', 'RW'),
('São Cristóvão e Nevis', 'KN'),
('Santa Lúcia', 'LC'),
('São Vicente e Granadinas', 'VC'),
('Samoa', 'WS'),
('San Marino', 'SM'),
('São Tomé e Príncipe', 'ST'),
('Arábia Saudita', 'SA'),
('Senegal', 'SN'),
('Sérvia', 'RS'),
('Seychelles', 'SC'),
('Serra Leoa', 'SL'),
('Cingapura', 'SG'),
('Eslováquia', 'SK'),
('Eslovênia', 'SI'),
('Ilhas Salomão', 'SB'),
('Somália', 'SO'),
('África do Sul', 'ZA'),
('Sudão do Sul', 'SS'),
('Espanha', 'ES'),
('Sri Lanka', 'LK'),
('Sudão', 'SD'),
('Suriname', 'SR'),
('Suécia', 'SE'),
('Suíça', 'CH'),
('Síria', 'SY'),
('Tajiquistão', 'TJ'),
('Tanzânia', 'TZ'),
('Tailândia', 'TH'),
('Togo', 'TG'),
('Tonga', 'TO'),
('Trinidad e Tobago', 'TT'),
('Tunísia', 'TN'),
('Turquia', 'TR'),
('Turcomenistão', 'TM'),
('Tuvalu', 'TV'),
('Uganda', 'UG'),
('Ucrânia', 'UA'),
('Emirados Árabes Unidos', 'AE'),
('Reino Unido', 'GB'),
('Estados Unidos', 'US'),
('Uruguai', 'UY'),
('Uzbequistão', 'UZ'),
('Vanuatu', 'VU'),
('Cidade do Vaticano', 'VA'),
('Venezuela', 'VE'),
('Vietnã', 'VN'),
('Iêmen', 'YE'),
('Zâmbia', 'ZM'),
('Zimbábue', 'ZW');



insert into pessoa (nome ,data_nascimento,sexo,cpf,tipo_pessoa,idpais) values('zelda','2015-09-05','f','34307100816','voluntario',1);
insert into pessoa (nome ,data_nascimento,sexo,cpf,tipo_pessoa,idpais) values('pablo','2015-09-05','m','3435100816','Voluntario',24);
insert into pessoa (nome ,data_nascimento,sexo,cpf,tipo_pessoa,idpais) values('Victoria','2002-03-01','f','23209800865','PESQUISADOR',24);
insert into pessoa (nome ,data_nascimento,sexo,cpf,tipo_pessoa,idpais) values('Emma','2002-05-15','f','12345678901','PESQUISADOR',132);
insert into pessoa (nome ,data_nascimento,sexo,cpf,tipo_pessoa,idpais) values('Tati','1985-03-23','f','00066677752','PESQUISADOR',36);

INSERT INTO VACINA (NOME,  IDPESQUISADOR, idpais, ESTAGIO, DATA_INICIO_PESQUISA) 
VALUES 
('ZeldaVac',  3, 1, 'APLICACAO_EM_MASSA', '2023-05-10'),
('Raiva',  3, 132, 'TESTES', '2022-12-15'),
('Vacina C',  2, 32, 'INICIAL', '2023-08-20');


select * from pais;


SELECT * FROM PESSOA;

SELECT * FROM APLICACAO_VACINA;
select * from pais where sigla = 'BR';
select * from vacina;




