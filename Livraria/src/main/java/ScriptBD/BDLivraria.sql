-- criando banco de dados BDLivraria
CREATE DATABASE BDLivraria
DEFAULT CHARACTER SET utf8 -- fotmatação de caracteres especiais, incluindo nossos caracteres latinos
DEFAULT COLLATE utf8_general_ci; -- collate tambem é para definição de caracteres

Use BDLivraria;

CREATE TABLE USUARIO (
  COD_USER INT NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(100) NOT NULL,
  DTNASC VARCHAR(10),
  SEXO VARCHAR(11),
  EMAIL VARCHAR(30),
  CEL INTEGER(255),
  FIXO INTEGER(255),
  SETOR VARCHAR(255),
  TP_ACESSO CHAR(12) NOT NULL,
  SENHA VARCHAR(15) NOT NULL,
  ENABLED BOOLEAN,
 CONSTRAINT PK_ID_USER PRIMARY KEY (COD_USER));

CREATE TABLE CLIENTE ( 
  COD_CLI INT NOT NULL AUTO_INCREMENT, 
  NOME VARCHAR (100) NOT NULL, 
  CPF VARCHAR (14) NOT NULL UNIQUE,
  ENDERECO VARCHAR (100),
  BAIRRO VARCHAR (50),
  CEP VARCHAR (9),
  ESTADO VARCHAR (50),    
  CEL INTEGER (15), 
  EMAIL VARCHAR (100), 
ENABLED BOOLEAN,
CONSTRAINT PK_ID_CLI PRIMARY KEY (COD_CLI));

CREATE TABLE PRODUTOS ( 
  PRODID INT NOT NULL AUTO_INCREMENT, 
  PRODFILIAL INTEGER NOT NULL, 
  PRODNOME VARCHAR (100) NOT NULL,
  PRODGENERO VARCHAR (30) NOT NULL, 
  PRODAUTOR VARCHAR (100) NOT NULL, 
  PRODQTD INTEGER NOT NULL, 
  PRODVALCOMPRA DOUBLE DEFAULT NULL,  
  PRODVALVENDA DOUBLE DEFAULT NULL, 
  PRODDESC VARCHAR (225)
CONSTRAINT PK_ID_PROD PRIMARY KEY (PRODID));

CREATE TABLE EMPRESA ( 
  COD_EMP INT NOT NULL AUTO_INCREMENT, 
  RZ_SOCIAL VARCHAR (100) NOT NULL, 
  CNPJ VARCHAR (19) NOT NULL UNIQUE,
  INS_ESTAD VARCHAR (15) NOT NULL,
  TEL INTEGER (15),
  ENDERECO VARCHAR (100),
  NUMERO INT,
  COMPLEMENTO VARCHAR (50),
  CEP VARCHAR (9),
  BAIRRO VARCHAR (50),
  CIDADE VARCHAR (50),
  ESTADO VARCHAR (50), 
ENABLED BOOLEAN,
CONSTRAINT PK_ID_EMP PRIMARY KEY (COD_EMP));

CREATE TABLE VENDA ( 
  COD_VENDA INT NOT NULL AUTO_INCREMENT, 
  COD_CLI INT  NOT NULL, 
  DT_VENDA VARCHAR(10) NOT NULL,
  VALOR_TOTAL DECIMAL (7,2) NOT NULL, 
CONSTRAINT PK_ID_VENDA PRIMARY KEY (COD_VENDA),
CONSTRAINT FK_CLI FOREIGN KEY (COD_CLI) REFERENCES CLIENTE(COD_CLI));

CREATE TABLE HASVENDA( 
  COD_HASVENDA INT NOT NULL AUTO_INCREMENT, 
  COD_VENDA INT NOT NULL,
  VL_ITEM DOUBLE DEFAULT NULL,
  DT_VENDA VARCHAR(10) NOT NULL,
  COD_PROD INT NOT NULL, 
  QTD_PROD INT NOT NULL, 
CONSTRAINT PK_HAS_VEND PRIMARY KEY (COD_HASVENDA), 
CONSTRAINT FK_ID_VENDA FOREIGN KEY (COD_VENDA) REFERENCES VENDA(COD_VENDA),
CONSTRAINT FK_HAS_PROD FOREIGN KEY (COD_PROD) REFERENCES PRODUTO(COD_PROD));