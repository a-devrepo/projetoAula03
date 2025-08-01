USE funcionarios_db;

CREATE TABLE funcionario (
id_funcionario    CHAR(36)    	PRIMARY KEY,
nome              VARCHAR(50)   NOT NULL,
cpf               CHAR(11)		NOT NULL,
data_admissao     DATE          NOT NULL
);

CREATE TABLE endereco (
id_endereco    CHAR(36)      PRIMARY KEY,
logradouro     VARCHAR(150)  NOT NULL,
numero         VARCHAR(15)   NOT NULL,
complemento    VARCHAR(50)   NOT NULL,
bairro         VARCHAR(100)  NOT NULL,
cidade         VARCHAR(50)   NOT NULL,
estado         VARCHAR(50)   NOT NULL,
cep            VARCHAR(10)   NOT NULL,
id_funcionario CHAR(36),
FOREIGN KEY(id_funcionario) REFERENCES funcionario(id_funcionario)
);