# 💰 Gestão de Finanças Pessoais - API

[![Licença](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Linguagem](https://img.shields.io/badge/Linguagem-Java-pink)]()
[![Framework](https://img.shields.io/badge/Framework-Spring--Boot-green)]()

## 📜 Sobre o Projeto FinUP

Esta é a API para um sistema de gestão de finanças pessoais. Desenvolvida com **Java e o framework Spring Boot**, a API oferece uma solução robusta e segura para que os usuários possam gerenciar suas receitas, despesas e orçamentos de forma eficiente. A arquitetura RESTful permite a integração com diferentes aplicações frontend (web, mobile, desktop), garantindo flexibilidade e escalabilidade.

## ✨ Funcionalidades

* **Autenticação de Usuários:** Cadastro, login e gestão de usuários com tokens de autenticação (JWT).
* **Gestão de Transações:**
    * Registrar receitas e despesas.
    * Visualizar, editar e excluir transações.
    * Filtrar transações por data, categoria ou tipo.
* **Categorias:** Criar e gerenciar categorias personalizadas para classificar as transações.

## ⚙️ Tecnologias Utilizadas

* **Linguagem:** `Java 17+`
* **Framework:** `Spring Boot 3`
* **Banco de Dados:** `MySQL`
* **Ferramenta de Build:** `Maven`
* **Outras Tecnologias:**
    * `Spring Data JPA` (para persistência de dados)
    * `Spring Security` (para segurança e JWT)
    * `Lombok` (para reduzir o boilerplate de código)
    * `Swagger` (para documentação da API)

## 🚀 Como Executar o Projeto Localmente

Siga os passos abaixo para ter uma cópia do projeto em execução na sua máquina.

### Pré-requisitos

Certifique-se de ter instalado:
* `Java Development Kit (JDK) 17` ou superior
* `Maven`
* Uma instância do `MySQL` rodando (localmente ou em um serviço de nuvem)

### Instalação

1.  Clone o repositório:
    ```bash
    git clone https://github.com/Gestao-de-Financas-Pessoais/api.git
    ```

2.  Configure o banco de dados:
    * Clone o repositório do banco de dados:
    ```bash
    git clone https://github.com/Gestao-de-Financas-Pessoais/banco-de-dados.git
    ```
      
    * Execute o scrpit `Gestao Financeira Pessoal.sql`.
    * No arquivo `src/main/resources/application.properties`, configure a conexão com o banco de dados:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/gestao_financas?useSSL=false&serverTimezone=UTC
      spring.datasource.username=seu_usuario_mysql
      spring.datasource.password=sua_senha_mysql
      spring.jpa.hibernate.ddl-auto=update # Ou 'create' na primeira execução
      ```

3.  Execute a aplicação:
    Com **Maven**:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## 🗺️ Estrutura da API (Endpoints)

| Método | Endpoint                    | Descrição                                 |
| :----- | :-------------------------- | :---------------------------------------- |
| `POST`   | `/api/usuarios/criar`     | Cadastra um novo usuário.                 |
| `PUT`    | `/api/usuarios/{id}`      | Atualiza um usuário.                      |
| `DELETE` | `/api/usuarios/{id}`      | Deleta um usuário.                        |
| `GET`    | `/api/usuarios/{email}`   | Busca um usuário pelo email.              |
| `POST`   | `/api/auth/login`         | Autentica um usuário e retorna um token JWT. |

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

