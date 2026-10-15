# DSCommerce Backend

Projeto backend desenvolvido em **Java** com **Spring Boot**, **Spring Security** e **JWT**, como parte das aulas do capítulo 5.

---

## 🚀 Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Security (OAuth2 + JWT)
- Maven
- JPA / Hibernate
- Banco de dados relacional (H2/PostgreSQL)

---

## 🔑 Autenticação e Autorização
O sistema utiliza **OAuth2 com JWT** para autenticação.

### Perfis de usuário
- **CLIENT**: pode consultar produtos e pedidos, além de inserir novos pedidos.
- **ADMIN**: pode gerenciar produtos (CRUD) e consultar pedidos de qualquer cliente.

### Fluxo de login
- Endpoint: `POST /login`
- Corpo da requisição:
  ```json
  {
    "username": "client@test.com",
    "password": "123456"
  }
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}
Authorization: Bearer <token>

📌 Endpoints principais
Produtos
GET /products → público (catálogo de produtos).

GET /products/{id} → público (detalhes do produto).

POST /products → apenas ADMIN.

PUT /products/{id} → apenas ADMIN.

DELETE /products/{id} → apenas ADMIN.

Pedidos
GET /orders/{id} → CLIENT (se dono do pedido) ou ADMIN.

POST /orders → apenas CLIENT.

POST /orders/{id}/payment → CLIENT (se dono do pedido) ou ADMIN.

📌 Status de pedidos
WAITING_PAYMENT → pedido criado, aguardando pagamento.

PAID → pagamento registrado.

▶️ Como executar
Clone o repositório:

bash
git clone https://github.com/Paschoalhenrique/dscommerce-backend-aulas-cap05-base.git
Entre na pasta do projeto:

bash
cd dscommerce-backend-aulas-cap05-base
Execute com Maven:

bash
./mvnw spring-boot:run
📌 Autor
Projeto desenvolvido por Paschoal Henrique durante as aulas do capítulo 5.



