<div align="center">
  <h1>🏦 Hexagonal Core Banking API</h1>

  ![Hexagonal Architecture Diagram](docs/Hexagonal_architecture_header.png)  
  
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/Architecture-Hexagonal-0052CC?style=for-the-badge" alt="Hexagonal Architecture" />
</div>

---

## 🚀 Overview

This project is a RESTful banking API developed to demonstrate the principles of **Hexagonal Architecture (Ports and Adapters)** combined with **Domain-Driven Design (DDD)**. It is structured as a multi-module Maven project to ensure a clear separation between the business domain and infrastructure details, making the core logic framework-agnostic, testable, and maintainable.

> **Purpose**: This is a personal portfolio project to showcase my skills in modern Java, Spring Boot, and software architecture design.

## ✨ Core Features

The API provides the following banking operations via REST endpoints:

- **Account Creation**: Open a new bank account with a unique identifier.
- **Credit Operation**: Add funds to an existing account.
- **Debit Operation**: Withdraw funds from an account (with balance validation).
- **Transfers**: Transfer money between two distinct accounts.
- **Balance Inquiry**: Check the current available balance.
- **Account Details**: Retrieve detailed information about a specific account.

## 🏗️ Architecture Design

The application is modeled using **Hexagonal Architecture** (also known as Ports and Adapters). This approach decouples the core business logic from external concerns like databases, web frameworks, and messaging systems.

### Layers and Modules

| Layer | Module | Description |
| :--- | :--- | :--- |
| **Domain / Core** | `banking-hexagon` | Contains all business entities, value objects, and domain services. **Zero dependencies** on Spring or external frameworks. |
| **Ports** | `banking-hexagon` | Interfaces that define how the core communicates with the outside world (inbound and outbound). |
| **Driver Adapters** | `banking-api` | Inbound adapters (e.g., REST Controllers) that handle HTTP requests and delegate to the domain. |
| **Driven Adapters** | `banking-h2-adapter`<br>`banking-mysql-adapter` | Outbound adapters that implement persistence interfaces (e.g., Spring Data JPA repositories for H2 and MySQL). |

### Diagram

![Hexagonal Architecture Diagram](docs/Ports%20&%20Adapters.png)  

## 📂 Project Structure

The project is divided into several Maven modules for better separation of concerns:

```
hexagonal-core-banking-api/
├── banking-parent          # Parent POM for dependency and plugin management
├── banking-hexagon         # Domain & Ports (pure business logic)
├── banking-api             # REST API adapter (inbound)
├── banking-h2-adapter      # H2 database adapter (outbound)
└── banking-mysql-adapter   # MySQL adapter (outbound, optional)
```

This modular setup allows easy swapping of persistence implementations and promotes maintainability.

## 🛠️ Technologies Used

- **Java 17** (Records, Pattern Matching, etc.)
- **Spring Boot 4.0.x** (Web, Data JPA)
- **Maven** (Multi-module build)
- **H2 Database** (In-memory for development)
- **JUnit 5 & Mockito** (Testing)
- **Lombok** (Boilerplate reduction)

## 📋 Prerequisites

- JDK 17 or higher
- Maven 3.8+

## 🏁 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/LuizFelipeLPG/hexagonal-core-banking-api.git
   cd hexagonal-core-banking-api
   ```

2. Build the entire project:
   ```bash
   mvn clean install
   ```

3. Run the application (from the root or `banking-api` module):
   ```bash
   mvn spring-boot:run -pl banking-api
   ```
   Alternatively, you can run the `BankingApiApplication` main class from your IDE.

4. The API will be available at `http://localhost:8080`.

## 📡 API Endpoints (Planned)

| Method | Endpoint                           | Description                     |
|--------|------------------------------------|---------------------------------|
| POST   | `/api/accounts`                    | Create a new account            |
| POST   | `/api/accounts/{id}/credit`        | Add funds to account            |
| POST   | `/api/accounts/{id}/debit`         | Withdraw funds from account     |
| POST   | `/api/accounts/{id}/transfer`      | Transfer amount to another account |
| GET    | `/api/accounts/{id}/balance`       | Get current balance             |
| GET    | `/api/accounts/{id}`               | Get account details             |

> *Note: Endpoints are under development and subject to change.*

## 🔮 Future Improvements

- **Authentication & Authorization**: Implement JWT-based security.
- **Unit & Integration Tests**: Expand test coverage for domain and infrastructure layers.
- **API Documentation**: Add OpenAPI/Swagger for interactive API testing.
- **Input Validation**: Enhance validation with Bean Validation.
- **Docker Support**: Containerize the application for easy deployment.

## 📄 License

This project is licensed under the MIT License.

## 👤 Author

**Luiz Felipe Lopes Pessoa de Goes**  

---

> ⭐ Feel free to star the repository!