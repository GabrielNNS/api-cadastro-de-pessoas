CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    logradouro VARCHAR(255) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    numero INTEGER NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    pessoa_id INTEGER,
    principal BOOLEAN
);

CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento VARCHAR(10) NOT NULL,
    ativado BOOLEAN
);