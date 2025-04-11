# 🧾 Pedidex

**Sistema de cadastro de clientes e pedidos para restaurantes.**  
Primeiro projeto da virada radical de Edmilson para impactar vidas com tecnologia.

---

## 🚀 Tecnologias Utilizadas

### Backend:
- Java 21
- Spring Boot
    - Spring Web
    - Spring Data JPA
    - Spring Boot DevTools
    - Spring Boot Actuator
    - Validation
    - Docker Compose Support
- Lombok
- PostgreSQL Driver

### Frontend (em breve):
- React
- Vite
- TailwindCSS
- Axios
- Zustand ou Context API

---

## 🧩 Funcionalidades (em construção)

- [ ] Autenticação com JWT (múltiplos usuários)
- [ ] Cadastro de clientes (nome, telefone, endereço, observações)
- [ ] Cadastro de pedidos (cliente, itens, valor, status, data)
- [ ] Listagem de pedidos por cliente
- [ ] Impressão em impressoras Zebra (via ZPL)

---

## 🐳 Docker

O projeto será containerizado com suporte completo a Docker e Docker Compose.

---

## 🧪 Health Checks e Monitoramento

Com suporte ao Spring Boot Actuator para verificação de status da aplicação.

---

## 📦 Como rodar localmente

```bash
git clone git@github.com:eddie-naipes/pedidex.git
cd pedidex
./mvnw spring-boot:run
