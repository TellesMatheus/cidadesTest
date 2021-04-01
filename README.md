# Teste Da Compasso

## Crud em Java & Spring Boot


### Tabela de Conteúdos

* [Status](#Status)
* [Requisitos](#Requisitos)
* [Utilização](#Utilização)
* [Features](#Features)
* [Roadmap](#Roadmap)
* [Tecnologias](#Tecnologias)
* [Autor](#Autor)


### Status

* Completo

### Requisitos

* Eclipse
* Java 

### Utilização

* Para rodar o projeto, no eclipse basta dar: "run as CidadesProjetoApplication" e para realizar os testes é: "run ass JUnit Test". Para rodar o projeto com o docker use: "docker run -p 8080:8080 cidades/projeto" na prompt de comando.

### Features

- [x] Cadastrar cidade
- [x] Cadastrar cliente
- [x] Consultar cidade pelo nome
- [x] Consultar cidade pelo estado
- [x] Consultar cliente pelo nome
- [x] Consultar cliente pelo Id
- [x] Remover cliente
- [x] Alterar o nome do cliente

### Roadmap

* Cadastrar cidade (POST): http://localhost:8080/cidades/cadastrar
* Cadastrar cliente (POST): http://localhost:8080/clientes/cadastrar
* Consultar cidade pelo nome (GET): http://localhost:8080/cidades/nome/{nome}
* Consultar cidade pelo estado (GET): http://localhost:8080/cidades/estado/{estado}
* Consultar cliente pelo nome (GET): http://localhost:8080/clientes/nome/{nome}
* Consultar cliente pelo Id (GET): http://localhost:8080/clientes/id/{id}
* Remover cliente (DELETE): http://localhost:8080/clientes/{id}
* Listar Cidades (GET): http://localhost:8080/cidades/listar
* Listar Clientes (GET): http://localhost:8080/clientes/listar
* Alterar o nome do cliente (POST): http://localhost:8080/clientes/{id}
* Swagger: http://localhost:8080/swagger-ui.html
* Swagger Documentation: http://localhost:8080/v2/api-docs
* H2 Database: http://localhost:8080/h2-console

### Tecnologias

- [Java](https://java.com/)
- [Spring Boot](https://spring.io/)
- [Eclipse](https://www.eclipse.org/)
- [Postman](https://www.postman.com/)
- [Swagger](https://swagger.io/)
- [H2 Database](https://www.h2database.com/)
- [Docker](https://www.docker.com/)

### Autor

* Matheus Adroaldo Telles











