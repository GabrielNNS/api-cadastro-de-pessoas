-- Tabela de endereço
CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    logradouro VARCHAR(255) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    numero INTEGER NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    principal BOOLEAN
);

-- Tabela de pessoas
CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento VARCHAR(10) NOT NULL,
    ativado BOOLEAN
);

-- Tabela de Relacionamento Pessoas_Endereco
CREATE TABLE pessoa_endereco (
    id SERIAL PRIMARY KEY,
    pessoa_id INTEGER,
    endereco_id INTEGER,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);