# Api Cadastro de Pessoas
> Uma api simples para criar, editar e consultar pessoas e endereços, 
> podendo ainda definir qual o endereço principal.

## Pré-requisitos
- Java 19.0.2 2023-01-17
- SpringBoot 3.2.3
- Maven
- Banco de dados PostgreSQL

## Instalação
1. Clonar o repositório.
2. Ter um banco local configurado no postgres.
3. Configurar as variáveis de ambiente (DB_URL, DB_USER e DB_PASSWORD).
4. Dar reload no maven para instalar as dependências.

## Uso
Após configurado e rodando temos os seguintes endpoints:

**Swagger:** http://localhost:8080/swagger-ui/index.html#/

Ou...

**Get (Todos):** http://localhost:8080/all

**Get (Por ID):** http://localhost:8080/{id}

**Get (Por ID, mas os endereços são detalhados):** http://localhost:8080/{id}/enderecos

**Post:** http://localhost:8080/create

**Put (ID):** http://localhost:8080/update/{id}

**Delete (ID):** http://localhost:8080/delete/{id}